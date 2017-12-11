@cpq-contract
Feature:contract
  In order to test cpq application
  As a tester
  And I should test cpq response application as per client requirement


  @Contracts_TC_001 @Contracts_TC_002
  Scenario: Verifying Contracts grid
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    And I should see contract page icon image in dashboard page
    When I click on contract icon button in dashboard page
    Then I should see list of existing contract under contract grid section

    @Contracts_TC_003 @Contracts_TC_004
    Scenario: Verifying Contracts grid sorted by dropdown list
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    And I should see contract page icon image in dashboard page
    When I click on contract icon button in dashboard page
    And I should see sort by name downdrop in contract page

    @Contracts_TC_005 @Contracts_TC_006
    Scenario: Verifying Contracts grid search option
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    And I should see contract page icon image in dashboard page
    When I click on contract icon button in dashboard page
    And I should see contract grid search option in contract page
    When I search "CNR-01007-K9W1Q8" contract in a search box
    And I click on "CNR-01007-K9W1Q8" contract

    @Contracts_TC_007 @Contracts_TC_008
    Scenario: Check for grid pagination
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    And I should see contract page icon image in dashboard page
    When I click on contract icon button in dashboard page
    And I should see grid pagination in contract page