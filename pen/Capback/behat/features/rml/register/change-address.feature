@rml @registration @smoketest
Feature: User should  be able change the Registration details
  In order to update email address
  As a registered user
  I should be able to change the address from registration details

  @updateaddress
  Scenario: Changing the address for the user
    When I go to "/account-type"
    And I select the radio button "Personal use"
    And I press "Continue"
    And I wait for 3 seconds
    And I select "Mr" from "Title"
    And I fill in "First name" with "Test"
    And I fill in "Last name" with "User"
    And I fill in "edit-mail" with a random email address
    And I fill in "edit-confirm-mail" with the last random email address
    And I fill in "edit-password" with "test1234"
    And I fill in "edit-confirm-password" with "test1234"
    And I fill in "edit-password-reminder" with "WORK"
    And I fill in "Property number" with "1"
    And I fill in "edit-paf-address-paf-street" with "Forge End"
    And I fill in "edit-paf-address-paf-city" with "WOKING"
    And I fill in "edit-paf-address-paf-element-postcode" with "GU21 6DB"
    And I wait for 3 seconds
    And I fill in "Home phone number" with "112 3455 8896"
    And I fill in "Mobile number" with "889 8896 8896"
    Given I have accepted the terms and conditions
    Then I press "Register"
    And I wait for 3 seconds
    Then I should see "Thanks for registering"
    When I go to "/user"
    And I follow "Change registration details"
    And I wait for 3 seconds
    And I fill in "edit-paf-address-paf-flat-name" with "Flat 1"
    And I fill in "edit-paf-address-paf-property-name" with "Bircham House"
    And I fill in "edit-paf-address-paf-street" with "High Street"
    And I fill in "edit-paf-address-paf-city" with "CAMBRIDGE"
    And I fill in "edit-paf-address-paf-element-postcode" with "CB22 3HE"
    And I press "Submit"
    And I wait for 3 seconds
    And I fill in "edit-password" with "test1234"
    And I press "Continue"
    And I wait for 3 seconds
    And I should see "Profile Changes Have Been Completed Successfully"
    And I press "Continue"
    And I wait for 3 seconds
    And I should see "My Profile"
    And I follow "Change registration details"
    And I wait for 3 seconds
    Then the "edit-paf-address-paf-property-name" field should contain "Bircham House"
    And the "edit-paf-address-paf-city" field should contain "CAMBRIDGE"
    And the "edit-paf-address-paf-element-postcode" field should contain "CB22 3HE"