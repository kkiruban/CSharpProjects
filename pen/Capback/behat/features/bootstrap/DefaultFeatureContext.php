<?php

use Behat\Behat\Exception\PendingException;
use Behat\Gherkin\Node\TableNode;
use Drupal\DrupalExtension\Context\DrupalContext;
use Symfony\Component\Process\Process;
use Behat\Behat\Context\Step\Given;
use Behat\Behat\Context\Step\When;
use Behat\Behat\Context\Step\Then;
use Behat\Behat\Event\ScenarioEvent;
use Behat\Behat\Event\StepEvent;
use Behat\Mink\Exception\ElementNotFoundException;
use Behat\Gherkin\Node\PyStringNode;
use Behat\Mink\Exception\ResponseTextException;
use Behat\Mink\Exception\ExpectationException;
use Drupal\Component\Utility\Random;

require 'vendor/autoload.php';

abstract class HackyDataRegistry {

    public static $data = array();

    public static function set($name, $value) {
        self::$data[$name] = $value;
    }

    public static function get($name) {
        $value = "";
        if (isset(self::$data[$name])) {
            $value = self::$data[$name];
        }
        if ($value === "") {
            $backtrace = debug_backtrace(FALSE, 2);
            $calling = $backtrace[1];
            if (array_key_exists('line', $calling) && array_key_exists('file', $calling)) {
                throw new Exception(sprintf("Fix HackyDataRegistry accessing with unset key at %s:%d in %s.", $calling['file'], $calling['line'], $calling['function']));
            }
        }
        return $value;
    }

    public static function keyExists($name) {
        if (isset(self::$data[$name])) {
            return TRUE;
        }
        return FALSE;
    }

}

class LocalDataRegistry {

    public $data = array();

    public function set($name, $value) {
        $this->data[$name] = $value;
    }

    public function get($name) {
        $value = "";
        if (isset($this->data[$name])) {
            $value = $this->data[$name];
        }
        return $value;
    }

}

/**
 * Features context.
 */
class DefaultFeatureContext extends DrupalContext {

    private $browser;
    public $bankHolidays;
    private $timeoutDuration;
    protected $users;
    private $groupname;

    /**
     * Create a context specific data storage container.
     */
    private $dataRegistry = '';

    /**
     * Initializes context.
     * Every scenario gets it's own context object.
     *
     * @param array $parameters context parameters (set them up through behat.yml)
     */
    public function __construct(array $parameters) {
        $this->default_browser = $parameters['default_browser'];
        if (isset($parameters['drupal_users'])) {
            $this->drupal_users = $parameters['drupal_users'];
        }
        if (isset($parameters['post title'])) {
            $this->postTitle = $parameters['post title'];
        }
        if (isset($parameters['environment'])) {
            $this->environment = $parameters['environment'];
        }
        if (isset($parameters['browser'])) {
            $this->browser = $parameters['browser'];
        }
        if (isset($parameters['bank_holidays'])) {
            $this->bankHolidays = $parameters['bank_holidays'];
        }
        if (isset($parameters['timeout_duration'])) {
            $this->timeoutDuration = $parameters['timeout_duration'];
        }
        $this->dataRegistry = new LocalDataRegistry();
    }

    /**
     * Helper function to fetch previously generated random strings stored by randomString().
     *
     * @param string $name
     *   The name of the random string.
     *
     * @return string
     *   The stored string.
     */
    public function fetchRandomString($name) {
        return HackyDataRegistry::get('random:' . $name);
    }

    /** it will reset the session
     *
     * @Given /^I should reset my session$/
     */
    public function iShouldResetMySession() {
        $this->getSession()->reset();
    }

    /** Check if page has links mentioned in links parameter.
     *
     * @Given /^I (?:should |)see the following:$/
     */
    public function iShouldSeeTheFollowingLinks(TableNode $table) {
        $page = $this->getSession()->getPage();
        $table = $table->getHash();

        foreach ($table as $key => $value) {
            $link = $table[$key]['links'];
            $result = $page->findLink($link);
            if (empty($result)) {
                throw new Exception("The link '" . $link . "' was not found");
            }
        }
    }

    /**
     * Function to check if the field specified is outlined in red or not
     *
     * @Given /^the field "([^"]*)" should be outlined in red$/
     *
     * @param string $field
     *   The form field label to be checked.
     * @throws Exception
     */
    public function theFieldShouldBeOutlinedInRed($field) {
        $page = $this->getSession()->getPage();
        // get the object of the field
        $formField = $page->findField($field);
        if (empty($formField)) {
            throw new Exception('The page does not have the field with label "' . $field . '"');
        }
        // get the 'class' attribute of the field
        $class = $formField->getAttribute("class");
        // we get one or more classes with space separated. Split them using space
        $class = explode(" ", $class);
        // if the field has 'error' class, then the field will be outlined with red
        if (!in_array("error", $class)) {
            throw new Exception('The field "' . $field . '" is not outlined with red');
        }
    }

    /**
     * Helper function to fetch user details stored in behat.local.yml.
     *
     * @param string $type
     *   The user type, e.g. drupal.
     *
     * @param string $name
     *   The username to fetch the password for.
     *
     * @throws Exception
     * @return string
     *   The matching password or FALSE on error.
     */
    public function fetchUserDetails($type, $name) {
        $property_name = $type . '_users';
        try {
            $property = $this->$property_name;
            $details = $property[$name];

            return $details;
        }
        catch (Exception $e) {
            throw new Exception("Non-existant user/password for $property_name:$name please check behat.local.yml.");
        }
    }

    /**
     * function returns working date with a specified no of days from today's date excluding bank holidays.
     *
     */
    public function getTheWorkingDayFrom($days) {
        $date = date('Y-m-j');
        $bankholidayArray = explode(",", $this->bankHolidays); //get bank holiday as array
        $temp_deliveryDate = date('Y-m-j', strtotime($date . ' +' . $days . ' days'));
        $dayOfWeek = date('l', strtotime($date . ' +' . $days . ' days'));
        if ($dayOfWeek === "Sunday") {
            $deliveryDate = date('Y-m-j', strtotime($temp_deliveryDate . ' +1 day'));
        }
        else {
            $deliveryDate = $temp_deliveryDate;
        }
        foreach ($bankholidayArray as $value) { //for every bank holiday
            if ($deliveryDate === $value) { //if the next day is a bank holiday
                $deliveryDate = date('Y-m-j', strtotime($value . ' +1 Weekday')); //look for next weekday after bank holiday, set it as delivery
            }
        }
        //$deliveryDate="Wed. 3 Jul";
        return $deliveryDate;
    }

    /**
     * Waits for a set amount of time.
     *
     * @Then /^I wait for (\d+) seconds$/
     */
    public function iWaitFor($seconds) {
        $miliseconds = $seconds * 1000;
        $this->getSession()->wait($miliseconds);
    }

    /**
     * Switches to Iframe
     *
     * @Then /^I switch to the "([^"]*)" frame$/
     */
    public function SwitchToFrame($frame) {
        $this->getSession()->switchToIFrame($frame);
    }

    /**
     * Switches to Iframe's, used for 3d secure*
     * @Then /^I switch back from the frame$/
     */
    public function switchBackFromFrame() {
        $this->getSession()->switchToIFrame(NULL);
    }

    /**
     * Switches to window
     *
     * @Then /^I switch to the "([^"]*)" window$/
     */
    public function switchToWindow($window) {
        $this->getSession()->switchToWindow($window);
    }

    /**
     * Switches to window
     *
     * @Then /^I switch back from the window$/
     */
    public function switchBackFromWindow() {
        $this->getSession()->switchToWindow(NULL);
    }

    /**
     * @Then /^I should see the following values in "([^"]*)" as "([^"]*)" dropdown:$/
     * this functions is use to verify the values from letter size
     *
     * @param string $letter_size
     *   the letter_size argument will fetch the size of the letter
     *
     * @param string $id
     *   The id argument will fetch the value of the id 
     *
     * @throws Exception
     * @return string
     * 
     */
    public function iShouldSeeTheFollowingValuesInAsDropdown($letter_size, $id, TableNode $table) {
        $option_elements = $this->getSession()->getPage()->findAll('xpath', "//*[@id='" . $id . "']//option");
        $values = array();
        //iterate each element in options and push in array
        foreach ($option_elements as $element) {
            array_push($values, $element->getText());
        }
        $values_expected = $table->getHash();
        //compare each element in dropdown list with as mentioned in list
        foreach ($values_expected as $key => $value) {

            $found = in_array($values_expected[$key]['values'], $values);
            if (empty($found)) {
                throw new Exception("The following '" . $values_expected[$key]['values'] . "' value not found");
            }
        }
    }

    /**
     * Pay with a 3D secure card.                                                ]
     *
     * @Then /^I pay with a non 3D secure card$/
     */
    public function payWithANon3dSecure() {
        $currentdate = date("Y");
        if ($this->browser == "firefox") {
            $this->getSession()->switchToIFrame("datacash-payment-frame");
            $page = $this->getSession()->getpage();
            $page->fillField("dc_card_number", "1000350000000007");
            $page->fillField("dc_capf1", "Test user");
            $page->selectFieldOption("exp_month", "03");
            $page->selectFieldOption("exp_year", $currentdate + 1);
            $page->fillField("dc_cv2_number", "123");
            $page->pressButton("Confirm and pay");
            $this->getSession()->switchToIFrame(NULL);
            $this->getSession()->wait(10000);
        }
        else { //Chrome has issues using mink functions in a iframe. Instead inject javascript to change the values if using chrome.
            $this->getSession()->switchToIFrame("datacash-payment-frame");
            $this->getSession()->getDriver()
                ->executeScript('document.getElementById(\'dc_card_number\').value="1000350000000007"');
            $this->getSession()->getDriver()
                ->executeScript('document.getElementById(\'dc_capf1\').value="Test user"');
            $this->getSession()->getDriver()
                ->executeScript('document.getElementsByName("exp_month")[0].value="03"');
            $this->getSession()->getDriver()
                ->executeScript('document.getElementsByName("exp_year")[0].value="2014"');
            $this->getSession()->getDriver()
                ->executeScript('document.getElementById(\'dc_cv2_number\').value="123"');
            $this->getSession()->getDriver()
                ->executeScript('document.getElementsByClassName("nextButton")[0].click();');
            $this->getSession()->switchToIFrame(NULL);
            $this->getSession()->wait(5000);
        }
    }

    /**
     * Pay with a 3D secure card.
     *
     * @Then /^I scroll to the bottom$/
     */
    public function scrollBottom() {
        $this->getSession()->wait(2000);
        $this->getSession()->getDriver()->executeScript("scroll(0, 50000)");

        $this->getSession()->wait(1000);
    }

    /**
     * Deleting a retailer name
     *
     * @Given /^I should delete "([^"]*)" in the table has class name "([^"]*)" in the column "([^"]*)"$/
     */
    public function iShouldDeleteInTheTableHasClassNameInTheColumn($value, $classname, $colnum) {
        $column_xpath = "//table[@class='" . $classname . "']//tr//td[" . $colnum . "]//a";

        $page = $this->getSession()->getPage();
        $retailerlinks = $page->findAll('xpath', $column_xpath);
        $linkfound = null;
        foreach ($retailerlinks as $link) {
            $linktext = $link->getText();
            if (preg_match("/" . $value . "/", $linktext) == 1) {

                $deletexpath = "//table[@class='" . $classname . "']//tr//td[contains(.,'" . $linktext . "')]/following-sibling::*/span/div/a";
                return array(
                  new When("I click on the element with xpath \"" . $deletexpath . "\""),
                  new Then("I wait for 5 seconds")
                );
            }
        }

        if ($linkfound == null) {

            $next = "//a[contains(text(),'next')]";
            if ($page->find('xpath', $next) == null) {
                throw new Exception("next button is not present or retailer name not ");
            }
            return array(
              new When("I click on the element with xpath \"" . $next . "\""),
              new Then("I wait for 5 seconds"),
              new When("I should delete \"" . $value . "\" in the table has class name \"" . $classname . "\" in the column \"" . $colnum . "\"")
            );
        }
    }

    /**
     * Pay with a 3D secure card.
     *
     * @Then /^I pay with a non authenticated 3D secure card$/
     */
    public function payWithA3dSecureFail() {
        $currentdate = date("Y");
        $this->getSession()->switchToIFrame("datacash-payment-frame");
        $page = $this->getSession()->getpage();
        $page->fillField("Card number", "1000350000000007");
        $page->fillField("Cardholder name", "Test User");
        $page->selectFieldOption("exp_month", "01");
        $page->selectFieldOption("exp_year", $currentdate + 1);
        $page->fillField("Security code", "123");
        $page->pressButton("Confirm and pay");
        $this->getSession()->wait(7000);
        $page->pressButton("Not Authenticated");
        $this->getSession()->getDriver()->getWebDriverSession()->accept_alert();
        $this->getSession()->switchToIFrame(NULL);
        $this->getSession()->wait(7000);
    }

    /**
     * Checks the terms and conditions have been accepted
     *
     * @Given /^I have accepted the terms and conditions$/
     */
    public function iAcceptTheTermsAndConditions() {
        if ($this->getSession()->getPage()
                ->find('xpath', '//*[contains(text(),"You have already accepted the terms and conditions")]')
        ) {
            return;
        }
        else {
            if ($this->getSession()->getPage()
                    ->find('xpath', '//*[contains(text(),"You have already accepted the")]')
            ) {
                return;
            }
            else {
                if ($this->getSession()->getPage()
                        ->findById("edit-terms-conditions")
                ) {
                    $this->getSession()->getPage()->checkField("edit-terms-conditions");
                }
                else {
                    if ($this->getSession()->getPage()->findById("edit-smartstamp-tc")) {
                        $this->getSession()->getPage()->checkField("edit-smartstamp-tc");
                    }
                    else {
                        if ($this->getSession()->getPage()->findById("edit-olp-flows-tc")) {
                            $this->getSession()->getPage()->checkField("edit-olp-flows-tc");
                        }
                        else {
                            if ($this->getSession()->getPage()->findById("edit-prepay-tc")) {
                                $this->getSession()->getPage()->checkField("edit-prepay-tc");
                            }
                            else {
                                if ($this->getSession()->getPage()
                                        ->find('xpath', '//*[contains(text(),"I have previously read and accepted the")]')
                                ) {
                                    return;
                                }
                                else {
                                    if ($this->getSession()->getPage()
                                            ->findById("edit-olp-flows-tc")
                                    ) {
                                        $this->getSession()->getPage()
                                            ->checkField("edit-olp-flows-tc");
                                    }
                                    else {
                                        if ($this->getSession()->getPage()
                                                ->findById("edit-prepay-tc")
                                        ) {
                                            $this->getSession()->getPage()
                                                ->checkField("edit-prepay-tc");
                                        }
                                        else {
                                            if ($this->getSession()->getPage()
                                                    ->findById("edit-terms-and-conditions")
                                            ) {
                                                $this->getSession()->getPage()
                                                    ->checkField("edit-terms-and-conditions");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Pay with a 3D secure card.                                                ]
     *
     * @Then /^I pay with a 3D secure card$/
     */
    public function payWithA3dSecure() {
        $currentdate = date("Y");
        if ($this->browser == "firefox") {
            $this->getSession()->switchToIFrame("datacash-payment-frame");
            $page = $this->getSession()->getpage();
            $page->fillField("Card number", "1000350000000007");
            $page->fillField("dc_capf1", "Test User");
            $page->selectFieldOption("exp_month", "01");
            $page->selectFieldOption("exp_year", $currentdate + 1);
            $page->fillField("Security code", "123");
            $page->pressButton("Confirm and pay");
            $this->getSession()->wait(15000);
            $this->getSession()->switchToIFrame(NULL);
            $this->getSession()->switchToIFrame("datacash-payment-frame");
            $page->pressButton("Authenticated");
            try {
                $this->getSession()->getDriver()->getWebDriverSession()->accept_alert();
            }
            catch (Exception $e) {
                echo 'Testing on UAT, no alert found';
            }
            $this->getSession()->wait(15000);
            $this->getSession()->switchToIFrame(NULL);
        }
        else { // Chrome has issues using mink functions in a iframe. Instead inject javascript to change the values if using chrome.
            $this->getSession()->switchToIFrame("datacash-payment-frame");
            $this->getSession()->getDriver()
                ->executeScript('document.getElementById(\'dc_card_number\').value="1000350000000007"');
            $this->getSession()->getDriver()
                ->executeScript('document.getElementById(\'dc_capf1\').value="Test user"');
            $this->getSession()->getDriver()
                ->executeScript('document.getElementsByName("exp_month")[0].value="01"');
            $this->getSession()->getDriver()
                ->executeScript('document.getElementsByName("exp_year")[0].value="2014"');
            $this->getSession()->getDriver()
                ->executeScript('document.getElementById(\'dc_cv2_number\').value="123"');
            $this->getSession()->getDriver()
                ->executeScript('document.getElementsByClassName("nextButton")[0].click();');
            $this->getSession()->wait(5000);
            $this->getSession()->getDriver()
                ->executeScript('document.getElementsByName("choice")[0].click();');
            $this->getSession()->switchToIFrame(NULL);
            $this->getSession()->wait(5000);

            try { //On SIT3 a alert is present that causes behat tests to fail, if detected accept it. Otherwise ignore.
                $this->getSession()->getDriver()->getWebDriverSession()->accept_alert();
            }
            catch (Exception $e) {
                echo 'Testing on UAT, no alert found';
            }
        }
    }

    /**
     * Opens specified external page.
     *
     * @Given /^(?:|I )am on external page "(?P<page>[^"]+)"$/
     * @When /^(?:|I )go to external page "(?P<page>[^"]+)"$/
     */
    public function visitExternal($page) {
        $this->getSession()->visit($page);
    }

    /**
     * Checks the review process is functioning
     *
     * @Given /^I should see the text:$/
     */
    public function iShouldSeeTheText(PyStringNode $markdown) {
        $linesArray = $markdown->getLines();
        foreach ($linesArray as $value) {
            $this->assertSession()->pageTextContains($value);
        }
    }

    /**
     * Select a radio button by id.
     *
     * @Given /^I select radio button "([^"]*)"$/
     */
    public function iSelectRadioButton($id) {

        $this->spin(function ($context) use ($id) {
                $ui_object = $context->getSession()->getPage()->findByID($id);
                if (!is_object($ui_object)) {
                    throw new Exception("$id not found.");
                }
                $ui_object->click();
                return TRUE;
            });
    }

    /**
     * Click on element with xpath as parameter
     *
     * @When /^I click on the element with xpath "([^"]*)"$/
     */
    public function iClickOnTheElementWithXpath($xpath) {

        $session = $this->getSession(); // get the mink session

        $element = $session->getPage()
            ->find('xpath', $xpath); // runs the actual query and returns the element
        // errors must not pass silently
        if (NULL === $element) {
            throw new InvalidArgumentException(sprintf('Could not evaluate XPath: "%s"', $xpath));
        }
        // ok, let's click on it
        $element->click();
    }

    /**
     * Verify a table with css class in webpage has a column name
     *
     * @Then /^I verify the table with class "([^"]*)" has column name "([^"]*)"$/
     */
    public function iVerifyTheTableWithClassHasColumnName($class_name, $col_header) {

        $i = 1;
        do {
            $column_xpath = "//table[@class='" . $class_name . "']//tr//th[" . $i . "]";
            // $column_xpath="{$xpath}{$str}";
            $page = $this->getSession()->getPage();
            $column_val = $page->find('xpath', $column_xpath);
            if ($column_val == NULL) {
                throw new Exception("column header not found");
                break;
            }
            else {

                $column_text = $column_val->getText();
                if ($column_text == $col_header) {

                    return TRUE;
                    break;
                }

                $i++;
            }
        } while ($column_val <> NULL);
    }

    /**
     * Verify that a table with css class has text(value ) in a cell mentioned with row, column
     *
     * @Then /^I verify the table with class "([^"]*)" has "([^"]*)" in row "([^"]*)" and column "([^"]*)"$/
     */
    public function iVerifyTheTableWithClassHasInRowAndColumn($class_name, $text, $row, $column) {
        $table_xpath = "//table[@class='" . $class_name . "']//tr[" . $row . "]//td[" . $column . "]";

        $page = $this->getSession()->getPage();
        $table_val = $page->find('xpath', $table_xpath);

        if ($table_val === NULL) {
            throw new Exception("Element not found");
        }
        else {

            $table_text = $table_val->getText();
            if (strcasecmp($table_text, $text) == 0) {
                return TRUE;
            }
            else {
                throw new Exception("Text not found");
            }
        }
    }

    /**
     * Verify table with css class has n number of rows
     *
     * @Then /^I verify the table with class "([^"]*)" has "([^"]*)" no of rows$/
     */
    public function iVerifyTheTableWithClassHasNoOfRows2($class_name, $row) {
        $page = $this->getSession()->getPage();
        $j = 0;
        for ($i = 1; $i <= $row; $i++) {

            $table_xpath = "//table[@class='" . $class_name . "']//tr[" . $i . "]";

            //echo $table_xpath;
            $table_val = $page->find('xpath', $table_xpath);
            if ($table_val === NULL) {
                //echo "table has only".$j."rows";
                throw new Exception("Number of Rows is not correct");
                break;
            }
            else {
                return TRUE;
            }


            $j = $i;
        }
    }

    /**
     * This step definition will verify a particular option is selected
     *
     * @Given /^I verify option "([^"]*)" in list with name "([^"]*)" should be selected$/
     */
    public function iVerifyOptionInListWithNameShouldBeSelected($optionValue, $select) {

        $selectElement = $this->getSession()->getPage()
            ->find('named', array('select', "\"{$select}\""));
        $optionElement = $selectElement->find('named', array(
          'option',
          "\"{$optionValue}\""
            ));

        //it should have the attribute selected and it should be set to selected
        if ($optionElement->getAttribute("selected") == TRUE)
            return TRUE;
        else {

            throw new Exception("No such Option is selected");
        }
    }

    /**
     * Switches to the last opened window.
     *
     * @Given /^I switch to the last opened window$/
     */
    public function iSwitchToLast() {
        $window_array = $this->getWindowNames();
        $this->getSession()->switchToWindow(end($window_array));
    }

    /**
     * Return the names of all open windows
     *
     * @return array    array of all open windows
     */
    public function getWindowNames() {
        return $this->getSession()->getDriver()->getWebDriverSession()
                ->window_handles();
    }

    /**
     * Return the name of the currently active window
     *
     * @return string    the name of the current window
     */
    public function getWindowName() {
        return $this->getSession()->getDriver()->getWebDriverSession()
                ->window_handle();
    }

    /**
     * Pay with a 3D secure card.                                                ]
     *
     * @Then /^I pay with$/
     */
    public function payWith($card, $card_no, $exp_mnth, $cvv) {

        $currentdate = date("Y");
        $this->getSession()->switchToIFrame("datacash-payment-frame");
        $page = $this->getSession()->getpage();
        $page->selectFieldOption("dc_cardtype", $card);
        $page->fillField("Card number", $card_no);
        $page->fillField("Name on card", "Test user");
        $page->selectFieldOption("exp_month", $exp_mnth);
        $page->selectFieldOption("exp_year", $currentdate + 1);
        $page->fillField("Security code", $cvv);
        $page->pressButton("Confirm and pay");
        $this->getSession()->wait(15000);
        if ($exp_mnth == '01') {
            $this->getSession()->switchToIFrame("datacash-payment-frame");

            $page->pressButton("Authenticated");


            try {
                $this->getSession()->getDriver()->getWebDriverSession()->accept_alert();
            }
            catch (Exception $e) {
                echo 'Testing on UAT, no alert found';
            }
            $this->getSession()->wait(15000);
            $this->getSession()->switchToIFrame(NULL);
        }
        try { //On SIT3 a alert is present that causes behat tests to fail, if detected accept it. Otherwise ignore.
            $this->getSession()->getDriver()->getWebDriverSession()->accept_alert();
        }
        catch (Exception $e) {
            echo 'Testing on UAT, no alert found';
        }
    }

    /**
     * passing a random group name in to create a group field
     *
     * @Given /^I fill in "([^"]*)" with a random group address$/
     */
    public function iFillInWithARandomGroupAddress($field) {
        $chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        $randomgroup = substr(str_shuffle($chars), 0, 6);
        $this->groupname[] = $randomgroup;
        $this->getSession()->getPage()->fillField($field, $randomgroup);
    }

    /**
     * @Given /^I fill in "([^"]*)" with a random address$/
     */
    public function iFillInWithARandomAddress($label) {

        $randomString = strtolower(Random::name(10)) . "@example.com";

        HackyDataRegistry::set('random:' . $label, $randomString);
        $step = "I fill in \"$label\" with \"$randomString\"";
        return new Then($step);
    }

    /**
     * @Then /^I should see the random "([^"]*)" text$/
     */
    public function iShouldSeeTheRandomText($label) {
        $text = $this->fetchRandomString($label);
        if (!$text) {
            throw new Exception("No random text stored for $label.");
        }
        $step = "I should see \"$text\"";
        return new Then($step);
    }

    /**
     * to add the contacts in last random group
     *
     * @Given /^I select last random group from "([^"]*)"$/
     */
    public function iSelectLastRandomGroupFrom($field) {
        $last = end($this->groupname);
        $this->getSession()->getPage()->selectFieldOption($field, $last);
    }

    /**
     * passing a random prefix in to prefix field
     *
     * @Given /^I fill in "([^"]*)" with random prefix$/
     */
    public function iFillInWithRandomPrefix($field) {
        $chars = "abcdefghijklmnopqrstuvwxyz";
        $randomprefix = substr(str_shuffle($chars), 0, 2);
        $this->getSession()->getPage()->fillField($field, $randomprefix);
    }

    /**
     * payment with card no with specified exp date.
     *
     * @Then /^I pay via "([^"]*)" card number "([^"]*)" with exp date "([^"]*)"$/
     */
    public function iPayViaWithExpDateWithCvvNumber($card, $card_no, $exp_mth) {

        switch ($card) {
            case "Visa":
                $this->payWith('Visa', $card_no, $exp_mth, '012');
                break;

            case "MasterCard":
                $this->payWith('MasterCard', $card_no, $exp_mth, '012');
                break;

            case "Maestro":
                $this->payWith('Maestro', $card_no, $exp_mth, '444');
                break;

            case "Visa Electron":
                $this->payWith('Visa Electron', $card_no, $exp_mth, '444');
                break;

            case "Mastercardnon3d":
                $this->payWith('MasterCard', $card_no, $exp_mth, '012');
                break;

            case "default":
                $this->payWith('Visa', $card_no, $exp_mth, '012');
                break;
        }
    }

    /**
     * click on link which is inside a table cell.
     *
     * @Given /^I click on the value "([^"]*)" in the table has class name "([^"]*)" in the column "([^"]*)"$/
     */
    public function iClickOnTheValueInTheTableHasClassNameInTheColumn($value, $classname, $colnum) {
        $column_xpath = "//table[@class='" . $classname . "']//tr//td[" . $colnum . "]//a";

        $page = $this->getSession()->getPage();
        $retailerlinks = $page->findAll('xpath', $column_xpath);
        $linkfound = null;
        foreach ($retailerlinks as $link) {
            $linktext = $link->getText();
            if (preg_match("/" . $value . "/", $linktext) == 1) {

                $link->doubleClick();
                return true;
                break;
            }
        }

        if ($linkfound == null) {

            $next = "//a[contains(text(),'next')]";
            if ($page->find('xpath', $next) == null) {
                throw new Exception("next button is not present or retailer name not ");
            }
            return array(
              new When("I click on the element with xpath \"" . $next . "\""),
              new Then("I wait for 5 seconds"),
              new When("I click on the value \"" . $value . "\" in the table has class name \"" . $classname . "\" in the column \"" . $colnum . "\"")
            );
        }
    }

    /**
     * Below function is to click on the element identified using CSS
     * @Given /^I click on the element with css "([^"]*)"$/
     */
    public function iClickOnTheElementWithCss($locator) {


        $session = $this->getSession(); // get the mink session
        $element = $session->getPage()
            ->find('css', $locator); // runs the actual query and returns the element
// raising exception
        if (NULL === $element) {
            throw new InvalidArgumentException(sprintf('Could not evaluate CSS selector: "%s"', $locator));
        }
// click on it
        $element->click();
    }

    /**
     *  Checks expected no of elements in an array.
     */
    protected function assertCount($expected, array $elements, $message = NULL) {
        if (intval($expected) !== count($elements)) {
            if (is_null($message)) {
                $message = sprintf(
                    '%d elements found, but should be %d.', count($elements), $expected
                );
            }
            throw new ExpectationException($message, $this->getSession());
        }
    }

    /**
     * Spin function to keep trying until an element appears or times out
     */
    public function spin($lambda, $wait = 30) {
        for ($i = 0; $i < $wait; $i++) {
            try {
                if ($lambda($this)) {
                    return true;
                }
            }
            catch (Exception $e) {
// do nothing
            }

            sleep(1);
        }

        $backtrace = debug_backtrace();

        throw new Exception(
            "Timeout thrown by " . $backtrace[1]['class'] . "::" . $backtrace[1]['function'] . "()\n"
        );
    }

    /**
     * @Then /^I should not see "([^"]*)" button$/
     */
    public function iShouldNotSeeButton($button) {
        expect($this->getMainContext()->getSession()->getPage()
                ->hasButton($button))->toBe(FALSE);
    }

    /**
     * @Then /^I should wait for the message "([^"]*)"$/
     */
    public function iShouldWaitForTheMessage($arg1) {
        $this->getMainContext()->spin(function ($context) use ($arg1) {
                return $context->getMainContext()->getSession()->getPage()
                        ->find('xpath', "//*[text()='" . $arg1 . "']");
            });
    }

    /**
     * This function will use spin method completed in RB-348.
     *
     * @Then /^I should not see "([^"]*)" field$/
     */
    public function iShouldNotSeeField($field) {
        expect($this->getMainContext()->getSession()->getPage()
                ->hasField($field))->toBe(FALSE);
    }

    /**
     * @Then /^I should see "([^"]*)" field$/
     */
    public function iShouldSeeField($field) {
        expect($this->getMainContext()->getSession()->getPage()
                ->hasField($field))->toBe(TRUE);
    }

    /**
     * @Given /^I should see "([^"]*)" button$/
     */
    public function iShouldSeeButton($button) {
        expect($this->getMainContext()->getSession()->getPage()
                ->hasButton($button))->toBe(TRUE);
    }

    /**
     * @Given /^the "([^"]*)" button should be "([^"]*)"$/
     */
    public function theButtonShouldBe($button, $visiblity) {
        switch ($visiblity) {
            case "visible":
                expect($this->getMainContext()->getSession()->getPage()
                        ->hasButton($button))->toBe(TRUE);
                break;
            case "invisible":
                expect($this->getMainContext()->getSession()->getPage()
                        ->hasButton($button))->toBe(FALSE);
                break;
        }
    }

    /**
     * Fills in form field with specified id|name|label|value with email generated on date.
     *
     * @Then /^I fill in "(?P<field>(?:[^"]|\\")*)" with a random email address$/
     */
    public function fillFieldGenerated($field) {

        $randomnum = rand(1, 10000);
        $seconds = date('His');
        $total = $randomnum * $seconds / 10;
        $user = round($total) . '@rmgsmoketest.com';
        $this->users[] = $user;
        $this->getSession()->getPage()->fillField($field, $user);
    }

    /**
     * Fills in form field with specified the last generated email address.
     *
     * @Then /^I fill in "(?P<field>(?:[^"]|\\")*)" with the last random email address$/
     */
    public function fillFieldGeneratedLast($field) {
        $last = end($this->users);
        $this->getSession()->getPage()->fillField($field, $last);
    }

    /**
     * This function will check if "Your email address" field is visible
     * or contains entered text in Newsletter Sign up form on homepage
     * @access public
     *
     * @param $arg1 contains 'Your email address'
     * @param $arg2 contains 'visible', 'invisible' OR 'contains rmltestuser1@.com'
     *
     * @return \Behat\Behat\Context\Step\Then
     * @Given /^the "([^"]*)" field should "([^"]*)"$/
     */
    public function theFieldShould($arg1, $arg2) {
        switch ($arg2) {
            case "be invisible":
                expect($this->getMainContext()->getSession()->getPage()
                        ->hasField($arg1))->toBe(FALSE);
                break;
            case "be visible":
                expect($this->getMainContext()->getSession()->getPage()
                        ->hasField($arg1))->toBe(TRUE);
                break;
            default:
                $search_value = explode(" ", $arg2);
                $step = "the \"Your email address\" field should contain \"$search_value[1]\"";
                return new Then($step);
        }
    }

    /**
     * attachFileToField
     * Attaches a file to field - if the field is a media field it opens the media browser and uploads
     * it, otherwise it just uses the parent's attachFileToField method
     *
     * @param mixed $field_value
     * @param mixed $field_label
     * @access public
     * @return void
     */
    public function attachFileToField($field_value, $field_label) {

        if ($this->getMinkParameter('files_path')) {
            $field_value = $this->getMinkParameter('files_path') . DIRECTORY_SEPARATOR . $field_value;
        }

        $xpath = "//div[contains(concat(' ',normalize-space(@class),' '),' form-type-media ')]//label[contains(text(),'" . $field_label . "')]/ancestor::div[1]/descendant::a";
        if (!$media_field_attach_button = $this->getSession()->getPage()
            ->find('xpath', $xpath)
        ) {
            return parent::attachFileToField($field_label, $field_value);
        }

        $media_field_attach_button->click();
        $this->getMainContext()->getSession()->switchToIFrame('mediaBrowser');
        $this->getSession()->getPage()
            ->attachFileToField("edit-upload-upload", $field_value);
        $this->getSession()->getPage()->pressButton('Upload');
        $this->getMainContext()->getSession()->wait(60000, '(0 === jQuery.active)');
        $this->getSession()->getPage()->pressButton('Next');
        $this->getSession()->getPage()->pressButton('Save');
        $this->getMainContext()->getSession()->switchToIFrame();
    }

    /**
     * Retrieves a list of tags from a Scenario or Outline event that denote a
     * fixture to be loaded for the test. The tag will be in the format
     * @fixture:fixture_name. This method returns an array of the fixture names
     * (ie the tag with the @fixture: part stripped off)
     *
     * @param mixed $event
     *  A ScenarioEvent or OutlineExampleEvent
     *
     * @return array
     *   An array of the tags that were prefixed with 'fixture:'
     */
    protected function _getFixtureTagsFromEvent($event) {
        $fixture_tags = array();
        $tags = array();

        if (is_a($event, 'Behat\Behat\Event\ScenarioEvent')) {
            $tags = $event->getScenario()->getTags();
        }
        elseif (is_a($event, 'Behat\Behat\Event\OutlineExampleEvent')) {
            $tags = $event->getOutline()->getTags();
        }

        foreach ($tags as $tag) {
            if (preg_match('/^fixture\:/', $tag)) {
                $fixture_tags[] = substr($tag, 8);
            }
        }

        return $fixture_tags;
    }

    /**
     * Loads a fixture with the given fixture name. We load fixtures using drush migrate
     * via the Behat Drush Driver,
     *
     * @param mixed $fixture_name
     *   The name of the fixture to load - this is mapped to be the group name of a migration
     * @return void
     */
    protected function _loadFixture($fixture_name) {
        if (!isset($this->loaded_fixtures)) {
            $this->loaded_fixtures = array();
        }
//although fixture loading should be idempotent, it may be time consuming, so
//just load the fixture if it's not already been loaded
        if (array_search($fixture_name, $this->loaded_fixtures) === FALSE) {
            if (is_a($this->getDriver(), 'Drupal\Driver\DrushDriver')) {
                $this->printDebug("Loading the fixture: " . $fixture_name);
                $this->getDriver()->drush('migrate-import', array("--group={$fixture_name}"));
                $this->loaded_fixtures[] = $fixture_name;
            }
            else {
                $this->printDebug("Failed to load fixture: " . $fixture_name);
            }
        }

// Or, you might want to load fixtures by just traversing directly to a URL
// (NB you'd probably want to disable this url in a production environment)
//$this->getSession()->visit($this->locatePath("/fixtures/{$fixture_name}/load"));
    }

    /**
     * Unloads a fixture with the given fixture name. We unload fixtures using
     * drush migrate-rollback via the Behat Drush Driver.
     *
     * @param mixed $fixture_name
     *   The name of the fixture to unload - this is mapped to be the group name of a migration
     * @return void
     */
    protected function _unloadFixture($fixture_name) {
        if (isset($this->loaded_fixtures) && array_search($fixture_name, $this->loaded_fixtures) !== FALSE) {
            if (is_a($this->getDriver(), 'Drupal\Driver\DrushDriver')) {
                $this->printDebug("Unloading the fixture: " . $fixture_name);
                $this->getDriver()->drush('migrate-rollback', array("--group={$fixture_name}"));
                $key = array_search($fixture_name, $this->loaded_fixtures);
                unset($this->loaded_fixtures[$key]);
            }
            else {
                $this->printDebug("Failed to unload fixture: " . $fixture_name);
            }
        }
    }

    /**
     * Implementation of Behat's beforeScenario hook. Loads fixtures before
     * a feature is executed.
     */

    /** @BeforeScenario */
    public function beforeScenario($event) {
// Load any fixtures specified in a fixture tag.
        foreach ($this->_getFixtureTagsFromEvent($event) as $fixture) {
            $this->_loadFixture($fixture);
        }
    }

    /**
     * Implementation of Behat's afterScenario hook. Unloads fixtures after
     * a feature is executed.
     */

    /** @AfterScenario */
    public function afterScenario($event) {
// Unload any fixtures specified in a fixture tag.
        foreach ($this->_getFixtureTagsFromEvent($event) as $fixture) {
            $this->_unloadFixture($fixture);
        }
    }

    /**
     * @Then /^Set drupal variable "([^"]*)" to "([^"]*)"$/
     *
     * @param mixed $var_name
     *   Name of the variable to be updated.
     * @param mixed $var_value
     *   Value to update the variable with.
     */
    public function setDrupalVariableTo($var_name, $var_value) {
        if (is_a($this->getDriver('drush'), 'Drupal\Driver\DrushDriver')) {
            $this->getDriver('drush')->drush('vset', array($var_name, $var_value));
        }
    }

    
  /**
   * @Given /^I visit on "([^"]*)"$/
   */
  public function iVisitOn($url) {
    //wait statement
    $this->getSession()->wait('5000');
    //to lunch a url
    $this->getSession()->visit($url);
    //wait statement
    $this->getSession()->wait('5000');
    //to maxmize and minimize window
    $this->getSession()->getDriver()->resizeWindow(1400, 1200);
    //to get screenshot
//    $image_data = $this->getSession()->getDriver()->getScreenshot();
//    $file_and_path = 'D:\behat_mine\screenshots\behat_screenshot.jpg';
//    file_put_contents($file_and_path, $image_data);
  }

  /**
   * @When /^I click on login or register link$/
   */
  public function iClickOnLoginOrRegisterLink() {
    $login0rRegisterField = $this->getSession()->getPage()->find('xpath', "//a[contains(text(),'Log in or register')]");
    $login0rRegisterField->click();
  }

  /**
   * @Given /^I click on register to create personal account with royal mail$/
   */
  public function iClickOnRegisterToCreatePersonalAccountWithRoyalMail() {
    $register_Field = $this->getSession()->getPage()->find('xpath', "//a[contains(text(),'Register')]");
    $register_Field->click();
    $this->getSession()->wait('5000');
    $personal_Use_Field = $this->getSession()->getPage()->findById("edit-account-type-personal");
    $personal_Use_Field->click();
    $continue_Field = $this->getSession()->getPage()->findById("edit-continue");
    $continue_Field->click();
    $this->getSession()->wait('5000');
  }

  /**
   * @Given /^I enter following details in registration form:$/
   */
  public function iEnterFollowingDetailsInRegistrationForm(TableNode $table) {
    //using table transformation i am filling form with fields and values
    foreach ($table->getHash() as $tableRow) {
      $table_field = $this->fillfield($tableRow['field'], $tableRow['value']);
    }
  }

  /**
   * @Given /^I click on select address to view list of addresses for the particular postcode$/
   */
  public function iClickOnSelectAddressToViewListOfAddressesForTheParticularPostcode() {
    $select_address_field = $this->getSession()->getPage()->findById('edit-paf-address-paf-element-lookup-button');
    $select_address_field->click();
    $this->getSession()->wait('5000');
  }

  /**
   * @Given /^I select the address from select box$/
   */
  public function iSelectTheAddressFromSelectBox() {
    $select_address_from_select_box = $this->getSession()->getPage()->find('xpath',"//*[@id='edit-paf-address-paf-select-your-address']/option[3]");
    $select_address_from_select_box->click();
    $this->getSession()->getPage()->findById("edit-paf-address-paf-select-your-address-submit")->click();
    $this->getSession()->wait('5000');
  }

  /**
   * @Given /^I accept the terms and conditions$/
   */
  public function iAcceptTheTermsAndConditiones() {
    $this->getSession()->getPage()->findById('edit-terms-conditions')->click();
  }

  /**
   * @Given /^I press register$/
   */
  public function iPressRegister() {
    $this->getSession()->getPage()->findById('edit-register')->click();
  }

//  /**
//   * @Given /^I should see the following:$/
//   */
//  public function iShouldSeeTheFollowing(TableNode $table) {
//    //using table transformation i am verifying links in a particular web-page
//    $page = $this->getSession()->getPage();
//    $table = $table->getHash();
//
//    foreach ($table as $key => $value) {
//      $link = $table[$key]['links'];
//      $result = $page->findLink($link);
//      if (empty($result)) {
//        throw new Exception("The link '" . $link . "' was not found");
//      }
//    }
//  }
//  
  /**
 * @Given /^I should fill the surname as "([^"]*)"$/
 */
public function iShouldFillTheSurnameAs($surrname) {
  $surname= $this->getSession()->getPage()->fillField("surname", $surrname);
  
}


}