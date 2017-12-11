@smoketest
Feature: creating a account in royal mail application in different environment
  As a guest
  I should create a personal type account
  And I should see the text thanks for registering

  Scenario Outline: creating a new account in royalmail
    Given I visit on "<royal_mail_site>"
#    And I should see the following:
#      | links                        |
#      | Buy and print postage online |
#      | Moving house?                |
#      | Buy postage online           |
#      | Redirect your mail           |
    When I click on login or register link
    And I click on register to create personal account with royal mail
    And I enter following details in registration form:
      | field                             | value            |
      | title_of_person                   | Mr.              |
      | first_name                        | test             |
      | last_name                         | user             |
      | edit-mail                         | user@example.com |
      | edit-confirm-mail                 | user@example.com |
      | password                          | test1234         |
      | confirm_password                  | test1234         |
      | password_reminder                 | test             |
      | paf_address[paf_element_postcode] | m11 ad           |
    And I click on select address to view list of addresses for the particular postcode
    And I select the address from select box
#    And I should fill the surname as "royalmailgroup"
    And I accept the terms and conditions
    And I press register
    Then I should see "Thanks for registering"

    Examples: 
      | royal_mail_site                |
      | https://www.royalmail.com/     |
