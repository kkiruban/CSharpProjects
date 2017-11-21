Feature: SpecFlowFeature

@web
Scenario: create a account
Given I have 'home' page opened
When I fill "username" as "dsintegration-admin@servicesource.com.sitbd"
And I fill "password" as "srevds123!"
And I click on submit button
Then I should see salesforce home page successfully
