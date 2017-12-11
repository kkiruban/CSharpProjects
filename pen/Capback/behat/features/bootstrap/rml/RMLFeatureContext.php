<?php

use Behat\Behat\Exception\PendingException;
use Behat\Gherkin\Node\PyStringNode;
use Behat\Gherkin\Node\TableNode;
use Drupal\DrupalExtension\Context\DrupalContext;
use Symfony\Component\Process\Process;
use Behat\Behat\Context\Step\Given;
use Behat\Behat\Context\Step\When;
use Behat\Behat\Context\Step\Then;
use Behat\Behat\Event\ScenarioEvent;
use Behat\Behat\Event\StepEvent;
use Behat\Behat\Event\SuiteEvent;
use Behat\Mink\Exception\ElementNotFoundException;
use Guzzle\Http\Client;

require 'vendor/autoload.php';

/**
 * Features context.
 */
class RMLFeatureContext extends DefaultFeatureContext {

    protected $postofficeSite = '';
    protected $parcelforceSite = '';
    protected $isolationMode;

    /**
     * Initializes context.
     * Every scenario gets it's own context object.
     *
     * @param array $parameters context parameters (set them up through behat.yml)
     */
    public function __construct(array $parameters) {
        if (isset($parameters['postoffice_site'])) {
            $this->postofficeSite = $parameters['postoffice_site'];
        }
        if (isset($parameters['parcelforce_site'])) {
            $this->parcelforceSite = $parameters['parcelforce_site'];
        }
        if (isset($parameters['isolation_mode'])) {
            $this->isolationMode = ($parameters['isolation_mode'] == "enabled");
        }
        parent::__construct($parameters);
    }

    /** @BeforeStep */
    public function waitForAjax(StepEvent $event) {
        if ($this->getMinkParameter('browser_name') == 'firefox') {
            if ($this->getSession()->evaluateScript("return window.jQuery")) {
                $this->getSession()->wait(5000, "jQuery.active === 0");
            }
        }
    }

    /**
     * @AfterScenario
     */
    public function sessionHardReset() {
        if ($this->isolationMode) {
            $this->getSession()->restart();
        }
    }

    /** Checks history table
     *
     * @Then /^I should see "([^"]*)" in history$/
     */
    public function iShouldSeeInHistory($amounttoverify) {

        $session = $this->getSession();
        $page = $session->getPage();
        $amount = $page->find('xpath', '//table[contains(@class,"views-table")]//tr[1]/td[4]'); //checks history table's first reocrd in credit column
        if ($amount === NULL) {
            throw new ElementNotFoundException($this->getSession(), 'table cell', 'id|name|label|value', NULL);
        }

        $actualamount = $amount->getText();

        //veryfying payment method is Credit Card
        $paymentmethod = $page->find('xpath', '//table[contains(@class,"views-table")]//tr[1]/td[3]'); //checks history table's first reocrd in credit column
        if ($paymentmethod === NULL) {
            throw new ElementNotFoundException($this->getSession(), 'table cell', 'id|name|label|value', NULL);
        }
        $method = trim($paymentmethod->getText());
        if ($method != "Credit Card") {
            throw new Exception("Payment method Credit Card not found");
        }


        preg_match("/([0-9\.,-]+)/", $actualamount, $match);

        $actualamount = $match[0];

        if ($amounttoverify != $actualamount) {
            Throw new Exception("No such amount found.");
        }
    }

    /**
     * Authenticates a user.
     *
     * @Given /^I am logged in as "([^"]*)" with the password "([^"]*)"$/
     */
    public function iAmLoggedInAsWithThePassword($email_address, $passwd) {
        $cookies = $this->getSession()->getDriver()->getWebDriverSession()
            ->getAllCookies();
        foreach ($cookies as $cookie) {
            if (preg_match("/RSESS.*/", $cookie['name'])) {
                echo "\033[34;1m - Debug Message - \033[34m User already logged in - logging out.. \033[0m \n";
                $this->getSession()->visit($this->locatePath('/logout'));
            }
        }

        $element = $this->getSession()->getPage();
        if (empty($element)) {
            throw new Exception('Page not found');
        }

        // Go to the user login page.
        $this->getSession()->visit($this->locatePath('/user/login'));

        // If I see this, I'm not logged in at all so log the user in.
        $element->fillField('name', $email_address);
        echo "\033[34;1m - Debug Message - \033[34m Currently filling in name with the email address " . $email_address . "\033[0m \n";
        $element->fillField('pass', $passwd);
        echo "\033[34;1m - Debug Message - \033[34m Currently filling in pass with the password " . $passwd . "\033[0m \n";
        echo "\033[34;1m - Debug Message - \033[34m Getting Current URL = " . $this->getSession()
            ->getCurrentUrl() . "\033[0m \n";

        $submit = $element->findButton('Login');
        if (empty($submit)) {
            throw new Exception('No submit button at ' . $this->getSession()
                ->getCurrentUrl());
        }
        $name = $element->findById('edit-name');
        $pass = $element->findById('edit-pass');
        // Log in.
        echo "\033[34;1m - Debug Message - \033[34m The text in the username field is  = " . $name->getValue() . "\033[0m \n";
        echo "\033[34;1m - Debug Message - \033[34m The text in the password field is  = " . $pass->getValue() . "\033[0m \n";


        $submit->click();
        $cookies = $this->getSession()->getDriver()->getWebDriverSession()
            ->getAllCookies();
        foreach ($cookies as $cookie) {
            if (preg_match("/RSESS.*/", $cookie['name'])) {
                return;
            }
        }
        throw new Exception("Could not log user in!");
    }

    /**
     * Authenticates a user with password from configuration.                                                ]
     *
     * @Given /^I am logged in as "([^"]*)"$/
     */
    public function iAmLoggedInAs($email_address) {
        $details = $this->fetchUserDetails('drupal', $email_address);
        $email_address = $details['email'];
        $password = $details['password'];
        $this->iAmLoggedInAsWithThePassword($email_address, $password);
    }

    /**
     * Authenticates with user and password from pre-set user.
     *
     * @Given /^I am logged in as the "([^"]*)" user$/
     */
    public function iAmLoggedInAsTheUser($usertype) {
        $details = $this->fetchUserDetails('drupal', $usertype . ' user');
        $email_address = $details['email'];
        $password = $details['password'];
        if ($usertype == "pfw") {
            $this->pfwIAmLoggedInAsWithThePassword($email_address, $password);
        }
        else {
            $this->iAmLoggedInAsWithThePassword($email_address, $password);
        }
    }

    /**
     * Pay with a 3D secure card.                                                ]
     *
     * @Then /^I have saved redirections$/
     */
    public function iHaveSavedRedirections() {
        $this->getSession()
            ->visit($this->locatePath('/personal/receiving-mail/redirection'));
        $page = $this->getSession()->getPage();
        $savedRedirections = $page->find('css', 'div.saved-redirection');
        if (empty($savedRedirections)) {
            throw new Exception("This user has no saved Redirections");
        }
    }

    /**
     * Fill in field with a date 5 days from today
     * @Then /^the "([^"]*)" field should contain the earliest possible redirection date from today$/
     */
    public function assertRedirectionStart($field) {
        $future_day = substr($this->getTheWorkingDayFrom(4), 8, 9);
        $page = $this->getSession()->getpage();
        $el = $page->find('css', '#' . $field . '');
        $selectedValue = $el->getValue();
        if ($selectedValue != $future_day) {
            throw new exception('Value not in selected dropdown');
        }
    }

    /**
     * Fill field with an illegal (<5 days) date
     * @Then /^I select a date from "([^"]*)" that is too close to todays date$/
     */
    public function illegalDateTooSoon($field) {
        $future_timestamp = mktime(0, 0, 0, date("m"), date("d") + 3, date("Y")); //returns 4 days (inclusive) from now in timestamp format
        $futureTimestampArray = (getdate($future_timestamp)); //returns an array of date/time info from that day
        $future_day = (String) ($futureTimestampArray['mday']); //isolates the day of the month value and converts it to a string
        $page = $this->getSession()->getpage();
        $el = $page->find('css', '#' . $field . '');
        $el->selectOption($future_day);
    }

    /**
     * Fill field with an illegal (<5 days) date
     * @Then /^I select a date from "([^"]*)" that is too far from todays date$/
     */
    public function illegalDate($field) {
        $future_timestamp = mktime(0, 0, 0, date("m"), date("d") + 90, date("Y")); //returns 90 days (exclusive) from now in timestamp format
        $futureTimestampArray = (getdate($future_timestamp)); //returns an array of date/time info from that day
        $future_day = (String) ($futureTimestampArray['mday']); //isolates the day of the month value and converts it to a string
        $page = $this->getSession()->getpage();
        $el = $page->find('css', '#' . $field . '');
        $el->selectOption($future_day);
    }

    /**
     *  Gets new working date if current date is bank holiday or sunday
     */
    private function getNextWorkingDate($currentdate) {
        $newdate = date('Y-m-d', strtotime($currentdate)); //get todays date
        $bankholidayArray = explode(",", $this->bankHolidays); //get bank holiday as array

        foreach ($bankholidayArray as &$value) { //for every bank holiday
            if ($newdate === $value) { //if the next day is a bank holiday
                $newdate = date('Y-m-d', strtotime($value . ' +1 Weekday')); //look for next weekday after bank holiday, set it as delivery
            }
        }
        return $newdate;
    }

    /**
     * Check withdrawal balance on page Withdraw funds | Prepay account
     *
     * @Then /^I should see withdrawal balance as "([^"]*)"$/
     */
    public function iShouldSeeWithdrawalBalanceAs($amountoverify) {
        // throw new PendingException();
        $session = $this->getSession();
        $page = $session->getPage();
        $amount = $page->find('xpath', '//table[contains(@class,"sticky-enabled sticky-table caption-less")]//tr[1]/td[2]'); //checks history table's first reocrd in credit column
        if ($amount === NULL) {
            throw new ElementNotFoundException($this->getSession(), 'table cell', 'id|name|label|value', NULL);
        }
        $withdraamount = str_replace('£', '', $amount->getText());
        if (floatval($withdraamount) < floatval($amountoverify)) {
            throw new Exception("withdraw funds are less than last top up");
        }
    }

    /**
     * Below function is top up prepay account if account has less balance
     * @Then /^I topup the prepay account by "([^"]*)"$/
     */
    public function iTopupThePrepayAccountBy($topup) {
        if ($this->getSession()->getPage()->findById("edit-amount")) {
            return array(
              new When("I select \"" . $topup . "\" from \"edit-amount\""),
              new When("I have accepted the terms and conditions"),
              new When("I press \"Continue\""),
              new When("I wait for 3 seconds"),
              new When("I pay with a non 3D secure card"),
              new When("I wait for 5 seconds"),
              new When("I should see \"Top-up successful\""),
              new When("I press \"Continue\""),
              new When("I wait for 10 seconds"),
              new When("I select radio button \"edit-payment-options\""),
              new When("I wait for 15 seconds")
            );
        }
        else {
            return TRUE;
        }
    }

    /**
     * comparing whether appropriate results is displayed when user searched post code in branchfinder flow
     * @Given /^I compare postcode "([^"]*)"$/
     */
    public function iComparePostcode($pcode) {
        $page = $this->getSession()->getPage();
        //taking first two characters to match with the result displayed
        $pincode = substr($pcode, 0, 2);
        //get rowcount with xpath of table
        $i = 1;
        while ($page->find('xpath', "//table[@class='ftn_result caption-less']/tbody/tr[" . $i . "]/td[2]") <> NULL) {
            $cell = $page->find('xpath', "//table[@class='ftn_result caption-less']/tbody/tr[" . $i . "]/td[2]");
            //trim post code here
            $code = trim($cell->getText());

            //explode with spaces and get excat post code
            $postcode = explode(" ", $code);
            $cnt = count($postcode);

            $postoffice_code = substr($postcode[$cnt - 2], 0, 2);
            //take 2/4 chars form start of post code retrieved in earlier step
            $i = $i + 1;

            if (strcmp($postoffice_code, $pincode) == 0) {
                continue;
            }
            else {
                throw new Exception("Postcode displayed is not valid one");
            }
        }
    }

    /**
     * Below function is to check whether the field is highlighted when error message of that field is clicked
     * @Given /^I check the cursor in the "([^"]*)" field$/
     */
    public function iCheckTheCursorInTheField($arg1) {
        if ($this->getSession()->getDriver()
                ->evaluateScript("if (document.activeElement.id == \"" . $arg1 . "\") {return true;} else {return false;}")
        ) {
            echo "i focussed";
        }
        else {
            throw new Exception("Field is not focussed");
        }
    }

    /**
     * Below function is to select the option in the table with class name
     * @Given /^I select radiobutton with option "([^"]*)" in table with class name "([^"]*)"$/
     */
    public function iSelectRadiobuttonWithOptionInTableWithClassName($option, $classname) {
        //Setting i equal to the current row in user table
        $i = 1;

        //Enter the table, check whether the email address field is present
        while ($this->getSession()->getPage()
            ->find('xpath', "//tbody//tr[" . $i . "]") <> NULL) {

            $flag = 0;
            //Get option address in current row
            $name = $this->getSession()->getPage()
                ->find('xpath', "//tbody//tr[" . $i . "]/td[2]");
            if ($name <> NULL) {
                $name = $name->getText();
            }
            else {
                throw new Exception("radio button not found in the table");
            }

            //Check if the option in current row in table
            if (strcmp($name, $option) == 0) {
                //Check to see if primary user image is present against the required email
                if ($this->getSession()->getPage()
                        ->find('xpath', "//tbody//tr[" . $i . "]/td[1]//input") <> NULL
                ) {
                    $element = $this->getSession()->getPage()
                        ->find('xpath', "//tbody//tr[" . $i . "]/td[1]//input");
                    $element->doubleClick();
                    echo "selected";
                    $flag = 1;
                    break;
                }
            }
            //Move onto next row
            $i = $i + 1;
        }
        //No option has been found (Should never get called!...)
        if ($flag == 0) {
            throw new Exception("primary user is not there");
        }
    }

    /**
     * This function clicks on the first quick link for Fee to Pay and Redelivery
     *
     * @Given /^I follow the first quick link$/
     */
    public function iClickOnFirstQuickLink() {
        // Gets the current day in full format (e.g. Monday)
        $currentday = date("l");

        // If the current day is Sunday, set the first link text to be "Yesterday"
        if ($currentday == "Sunday") {
            $firstLinkText = "Yesterday";
        }
        // If the current day is NOT Sunday, set the first link text to be "Today"
        else {
            $firstLinkText = "Today";
        }

        if ($firstLink = $this->getSession()->getPage()->findLink($firstLinkText)) {
            // Click on the first quick link
            $firstLink->click();
        }
        else {
            throw new Exception("Could not find the first quick link element on the page");
        }
    }

    /**
     * @When /^I go to Postoffice logout page$/
     */
    public function iGoToPostofficeLogoutPage() {
        if (!empty($this->postofficeSite)) {
            $logout_page = $this->postofficeSite . '/logout';
            $this->getSession()->visit($logout_page);
        }
        else {
            throw new Exception("Could not find postoffice_site key in YAML configuration");
        }
    }

    /**
     * @When /^I go to Postoffice registration page$/
     */
    public function iGoToPostofficeRegistrationPage() {
        if (!empty($this->postofficeSite)) {
            $registration_page = $this->postofficeSite . '/user/register';
            $this->getSession()->visit($registration_page);
        }
        else {
            throw new Exception("Could not find postoffice_site key in YAML configuration");
        }
    }

    /**
     * @When /^I go to Parcelforce logout page$/
     */
    public function iGoToParcelforceLogoutPage() {
        if (!empty($this->parcelforceSite)) {
            $logout_page = $this->parcelforceSite . '/logout';
            $this->getSession()->visit($logout_page);
        }
        else {
            throw new Exception("Could not find parcelforce_site key in YAML configuration");
        }
    }

    /**
     * @When /^I go to Parcelforce registration page$/
     */
    public function iGoToParcelforceRegistrationPage() {
        if (!empty($this->parcelforceSite)) {
            $registration_page = $this->parcelforceSite . '/user/register';
            $this->getSession()->visit($registration_page);
        }
        else {
            throw new Exception("Could not find parcelforce_site key in YAML configuration");
        }
    }

    /**
     * @Given /^I search "([^"]*)" retailer$/
     */
    public function iSearchNewlyAddedActiveRetailerInTheTableHasClassNameInTheColumn($label) {
        $retailername = $this->fetchRandomString($label);
        return array(
          new When("I click on the value \"" . $retailername . "\" in the table has class name \"views-table sticky-enabled cols-3 sticky-table caption-less\" in the column \"2\"")
        );
    }

    /**
     * @Given /^I delete "([^"]*)" retailer$/
     */
    public function iShouldDeleteNewlyAddedActiveRetailerInTheTableHasClassNameInTheColumn($label) {
        $retailername = $this->fetchRandomString($label);
        return array(
          new When("I should delete \"" . $retailername . "\" in the table has class name \"views-table sticky-enabled cols-3 sticky-table caption-less\" in the column \"2\"")
        );
    }

}