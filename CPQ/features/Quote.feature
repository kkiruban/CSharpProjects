@CPQ-Quote-1

Feature:Quote
  In order to test cpq application
  As a tester
  And I should test cpq response application as per client requirement

   @Quote_TC_001
  Scenario: Creation of quote
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    And I should see Performance Chart
    And I should see Current Month inside performace chart
    And I should see Last Month inside performace chart
    And I should see Current Year inside performace chart
    And I should see Pipeline Chart
    And I should see "Recent Opportunities" section header
    And I should see "Recent Quotes" section header
    And I should see "Pending Drafts" section header
    And I should see "view-all" link in pending drafts section
    And I should see "view-all" link in Recent Quotes section
    And I should see Sorted by option under recent opportunities section
    And I should see search box under recent opportunities section
    And I should see opportunity bulb image in dashboard page
    And I should see contract page icon image in dashboard page
    And I should see Quote image in dashboard page
    And I should see search box under my contracts section
    When I click on plus icon in dashboard page
    And I select any one opportunity and click on next button
    And I select quote info details and click on next button
    And I select the price list from the displayed list and click on submit
    And I should get message from the current page
    Then I should see "Quote created successfully."
    When I click on ok button

    @Quote_TC_002
    Scenario: Saving draft quote
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    When I click on quote icon in dashboard page
    And I click on any existing quote link under draft quotes section
    Then I should see "Quote Title"
    When I change the address street two and click on save button
    And I get address street two from the current page

   @cpq-smoketest @Quote_TC_003
    Scenario: Verifing the quote rollback
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    When I click on quote icon in dashboard page
    And I click on any existing quote link under draft quotes section
    Then I should see "Quote Title"
    And I should see rollback button in edit quote page
    When I change the address street two and click on save button
    And I click on roll back button in edit quote page
    Then I should see "Are you sure you want to rollback all changes?"
    And I click on YES button to roll back changes

    @cpq-smoketest @Quote_TC_003_1
    Scenario: Verifing the quote rollback
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    When I click on quote icon in dashboard page
    And I click on any existing quote link under draft quotes section
    Then I should see "Quote Title"
    And I should see rollback button in edit quote page
    When I change the address street two
    And I click on roll back button in edit quote page
    Then I should see "Are you sure you want to rollback all changes?"
    And I click on NO button to roll back changes

    @cpq-smoketest @Quote_TC_004
    Scenario: Copying the draft quote
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    When I click on quote icon in dashboard page
    And I click on any existing quote link under draft quotes section
    Then I should see "Quote Title"
    And I should see copy button in edit quote page
    When I click copy button in edit quote page
    And I should see "There are unsaved changes. Are you sure you want to copy this quote? Unsaved changes will not carry over"
    And I click on NO button to carry over unsaved changes

    @cpq-smoketest @Quote_TC_004
    Scenario: Copying the draft quote
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    When I click on quote icon in dashboard page
    And I click on any existing quote link under draft quotes section
    Then I should see "Quote Title"
    And I should see copy button in edit quote page
    When I click copy button in edit quote page
    And I should see "There are unsaved changes. Are you sure you want to copy this quote? Unsaved changes will not carry over"
    And I click on YES button to carry over unsaved changes

   @cpq-smoketest @Quote_TC_005
    Scenario: Verifing the quote re-compute
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    When I click on quote icon in dashboard page
    And I click on any existing quote link under draft quotes section
    Then I should see "Quote Title"
    And I should see re-compute icon in edit quote page
    When I click on re-compute icon button in edit quote page

    @cpq-smoketest @Quote_TC_006
    Scenario: Verifing the quote exceptions
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    When I click on quote icon in dashboard page
    And I click on any existing quote link under draft quotes section
    Then I should see "Quote Title"
    And I should see show exceptions icon button in edit quote page
    When I click on show exceptions icon button in edit quote page
    Then I should see "Exceptions"
    When I close window pop up

    @cpq-smoketest @Quote_TC_007
    Scenario: Verifing the quote logs
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    When I click on quote icon in dashboard page
    And I click on any existing quote link under draft quotes section
    Then I should see "Quote Title"
    And I should see Show logs icon button in edit quote page
    When I click on Show logs icon button in edit quote page
    Then I should see "Show Logs"
    And I should see "This panel shows all edits made to the quote and it's line items since the last save"
    When I close window pop up

    @cpq-smoketest @Quote_TC_008
    Scenario: Refreshing the quote
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    When I click on quote icon in dashboard page
    And I click on any existing quote link under draft quotes section
    Then I should see "Quote Title"
    And I should see Refresh icon button in edit quote page
    When I change the address street two
    When I click on Refresh icon button in edit quote page
    Then I should see "Are you sure you want to refresh? You will lose all changes."
    And I click on YES button to carry over unsaved changes

    @cpq-smoketest @Quote_TC_008
    Scenario: Refreshing the quote
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    When I click on quote icon in dashboard page
    And I click on any existing quote link under draft quotes section
    Then I should see "Quote Title"
    And I should see Refresh icon button in edit quote page
    When I change the address street two
    When I click on Refresh icon button in edit quote page
    Then I should see "Are you sure you want to refresh? You will lose all changes."
    And I click on NO button to carry over unsaved changes
    