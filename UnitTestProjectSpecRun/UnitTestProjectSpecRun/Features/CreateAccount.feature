Feature:Create Account

@web
Scenario:Create account
Given I have 'home' page opened
When I fill login form for salesforce application
 | Username                                         | Password   |
 | testing                                          | testing    |
 | dsintegration-admin@servicesource.com.sitnxtfico | srevds123! |
 And I click on "Login" button
