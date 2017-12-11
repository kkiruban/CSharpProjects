
Feature:Quote
  In order to test cpq application
  As a tester
  And I should test cpq response application as per client requirement

   @Quote_TC_009
    Scenario: Submitting the quote
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    When I click on quote icon in dashboard page
    And I click on any existing quote link under draft quotes section
    Then I should see "Quote Title"
    When I change the address street two and click on save button
    And I get address street two from the current page
    And I click on submit button
    And I get the status for the respective draft quote
    Then I should see form disabled

    @Quote_TC_010
    Scenario: Verifing cancel in InApproval status
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    When I click on quote icon in dashboard page
    And I click on any existing quote link under draft quotes section
    Then I should see "Quote Title"
    When I change the address street two and click on save button
    And I get address street two from the current page
    And I click on submit button
    And I get the status for the respective draft quote
    And I click on cancel button in edit quote page
    And I get the status for the respective draft quote
    
    @Quote_TC_011
    Scenario: Verifing revise in InApproval status
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    When I click on quote icon in dashboard page
    And I click on any existing quote link under draft quotes section
    Then I should see "Quote Title"
    When I change the address street two and click on save button
    And I get address street two from the current page
    And I click on submit button
    And I get the status for the respective draft quote
    And I click on "Revise" button in edit quote page


    @Quote_TC_012
    Scenario: Verifing revise in InApproval status
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    When I click on quote icon in dashboard page
    And I click on any existing quote link under draft quotes section
    Then I should see "Quote Title"
    When I change the address street two and click on save button
    And I get address street two from the current page
    And I click on submit button
    And I get the status for the respective draft quote
    When I click copy button in edit quote page


    @Quote_TC_013
    Scenario: Verifing approve in InApproval status
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    When I click on quote icon in dashboard page
    And I click on any existing quote link under draft quotes section
    Then I should see "Quote Title"
    When I change the address street two and click on save button
    And I get address street two from the current page
    And I click on submit button
    And I get the status for the respective draft quote
    And I click on "Approve" button in edit quote page
    Then I should see "Show Approve"


    @Quote_TC_014
    Scenario: Verifing reject in InApproval status
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    When I click on quote icon in dashboard page
    And I click on any existing quote link under draft quotes section
    Then I should see "Quote Title"
    When I change the address street two and click on save button
    And I get address street two from the current page
    And I click on submit button
    And I get the status for the respective draft quote
    And I click on "Reject" button in edit quote page
    Then I should see "Show Reject"