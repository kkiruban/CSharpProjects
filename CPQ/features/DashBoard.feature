@cpq-dashboard
Feature: Dashboard
  In order to test cpq product
  As a tester
  I should able to verify all fields as per client requirement

  @DashBoard
  Scenario: verify dashboard performace chart and pipeline chart
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    And I should see Performance Chart
    And I should see Current Month inside performace chart
    And I should see Last Month inside performace chart
    And I should see Current Year inside performace chart
    And I should see Pipeline Chart
    And I should see total Opportunities count in Pipeline Chart
    And I should see total unquoted count in Pipeline Chart
    And I should see total quoted count in Pipeline Chart
    And I should see "Recent Opportunities" section header
    And I should see "Recent Quotes" section header
    And I should see "Adventure Works (sample)" section header
    And I should see "Pending Drafts" section header
    And I should see "view-all" link in pending drafts section
    And I should see "view-all" link in Recent Quotes section
    And I should see Sorted by option under recent opportunities section
    And I should see search box under recent opportunities section
    And I should see opportunity bulb image in dashboard page
    And I should see contract page icon image in dashboard page
    And I should see Quote image in dashboard page
    And I should see search box under my contracts section

  @DashBoard
  Scenario: verify Opportunities grid
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    And I should see "Opportunities" section header
    And I should see list of recent opportunities in a grid
    And I should see Sorted by option under recent opportunities section
    And I should see search box under recent opportunities section
    And I should see opportunity bulb image in dashboard page

  @DashBoard
  Scenario: My Contracts grid
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    And I should see "Contracts" section header
    And I should see list of recent contracts in a grid
    And I should see Pipeline Chart Contracts in a dashboard page
    And I should see total contracts count in Pipeline Chart Contracts
    And I should see total expired contracts count in Pipeline Chart Contracts
    And I should see Sorted by option under recent Contracts section
    And I should see search box under recent Contracts section
    And I should see contract page icon in dashboard page
    And I should see search box under my contracts section

  @Dashboard_TC_040
  Scenario: Dashboard_TC_040 Account and Logout
    Given I should navigate to response CPQ application
    Then I should see Dashboard page succesfully
    When I click account button in a dashboard page
    And I click on logout link in a dashboard page
    Then I should see login form title
