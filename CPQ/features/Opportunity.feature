@cpq-opportunity
Feature:opportunity
  In order to test cpq application
  As a tester
  And I should test cpq response application as per client requirement


  @Opp_TC_001 @Opp_TC_002
  Scenario: Verifying Opportunities grid
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    And I should see opportunity bulb image in dashboard page
    When I click on opportunity icon
    Then I should see list of existing opportunity under opportunities section
    When I search "Opp_Test_Renew" opportunity in a search box
    And I click on "Opp_Test_Renew" opportunity
    And I should check system will allow to modify or edit opportunity

    @Opp_TC_003 @Opp_TC_004
    Scenario: Verifying Opportunities grid sorted by dropdown list
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    And I should see opportunity bulb image in dashboard page
    When I click on opportunity icon
    Then I should see list of existing opportunity under opportunities section
    And I should see sort by name downdrop in opportunities page
    And I should see sorted by dropdown should display all the coloumn names of the grid


    @Opp_TC_005 @Opp_TC_006
    Scenario: Verifying Opportunities grid search option
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    And I should see opportunity bulb image in dashboard page
    When I click on opportunity icon
    Then I should see list of existing opportunity under opportunities section
    And I should see sort by name downdrop in opportunities page
    And I should see opportunity grid search option in opportunities page
    When I search "Opp_Test_Renew" opportunity in a search box
    And I click on "Opp_Test_Renew" opportunity

    @Opp_TC_007 @Opp_TC_008
    Scenario: Check for grid pagination
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    And I should see opportunity bulb image in dashboard page
    When I click on opportunity icon
    Then I should see list of existing opportunity under opportunities section
    And I should see grid pagination in opportunity page