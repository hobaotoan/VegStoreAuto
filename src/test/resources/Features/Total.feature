Feature: Management Total Order page

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
    And   I enter "TestFirstName" into input "firstName" field
    And   I enter "TestLastName" into input "lastName" field
    And   I enter "16092001" into input "zipPostalCode" field
    And   I click on "continueButton" button

  Scenario: As a user, i should see total order page shown as expect
    Then  I should see "titleCheckout" will be displayed on UI
    And   I should see "cartQuantity" will be displayed on UI
    And   I should see "cartDesc" will be displayed on UI
    And   I should see "cartItems" will be displayed on UI
    And   I should see "Payment Information" displayed on "summaryInfor" list screen
    And   I should see "Shipping Information" displayed on "summaryInfor" list screen
    And   I should see "Price Total" displayed on "summaryInfor" list screen
    And   I should see "totalPrices" will be displayed on UI
    And   I should see "summaryValue" will be displayed on UI
    And   I should see "subTotalPrices" will be displayed on UI
    And   I should see "summaryTax" will be displayed on UI
    And   I should see "cancelButton" will be displayed on UI
    And   I should see "finishButton" will be displayed on UI

  Scenario: As a user, i should see detail items shown as expect at total order page
    Then  I should see "cartNameProduct" will be displayed on UI
    And   I should see "cartQuantityProduct" will be displayed on UI
    And   I should see "cartDescProduct" will be displayed on UI
    And   I should see "cartPriceProduct" will be displayed on UI





