Feature: Management Checkout page

  Background: As a user, i want to signin successfully and navigate to Check out page
    Given I navigate to the Sauce website
    And   I enter "standard_user" into input "usernameTxt" field
    And   I enter "secret_sauce" into input "passwordTxt" field
    And   I click on "signinBtn" button
    And   I click on "menuBurger" button
    And   I wait for 2 sec
    And   I click on "resetAppStateLink" button
    And   I click on "logoutLink" button
    And   I enter "standard_user" into input "usernameTxt" field
    And   I enter "secret_sauce" into input "passwordTxt" field
    And   I click on "signinBtn" button
    And   I click on "firstAddProduct" button
    And   I click on "shoppingCart" button
    And   I click on "buttonCheckout" button

  Scenario: As a user, i should see check out information shown as expect
    Then  I should see "titleCheckout" will be displayed on UI
    And   I should see "firstName" will be displayed on UI
    And   I should see "lastName" will be displayed on UI
    And   I should see "zipPostalCode" will be displayed on UI
    And   I should see "continueButton" will be displayed on UI
    And   I should see "cancelButton" will be displayed on UI

  Scenario: As a user, i should see error when leaves blank with all fields
    When  I click on "continueButton" button
    Then  I should see "Error: First Name is required" on "errorNotification"

  Scenario: As a user, i should see error when leaves blank at first name field
    Given I enter "TestLastName" into input "lastName" field
    And   I enter "16092001" into input "zipPostalCode" field
    When  I click on "continueButton" button
    Then  I should see "Error: First Name is required" on "errorNotification"

  Scenario: As a user, i should see error when leaves blank at last name field
    Given I enter "TestFirstName" into input "firstName" field
    And   I enter "16092001" into input "zipPostalCode" field
    When  I click on "continueButton" button
    Then  I should see "Error: Last Name is required" on "errorNotification"

  Scenario: As a user, i should see error when leaves blank at postal code field
    Given I enter "TestFirstName" into input "firstName" field
    And   I enter "TestLastName" into input "lastName" field
    When  I click on "continueButton" button
    Then  I should see "Error: Postal Code is required" on "errorNotification"





