Feature: Management Cart page

  Background: As a user, i want to signin successfully
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
    When  I click on "firstAddProduct" button
    And   I click on "shoppingCart" button

  Scenario: As a user, i should see cart shown as expect
    Then  I should see "titleCart" will be displayed on UI
    And   I should see "cartQuantity" will be displayed on UI
    And   I should see "cartDesc" will be displayed on UI
    And   I should see "cartItems" will be displayed on UI
    And   I should see "cartContinueButton" will be displayed on UI
    And   I should see "buttonCheckout" will be displayed on UI

  Scenario: As a user, i should see detail items shown as expect at cart page
    Then  I should see "cartNameProduct" will be displayed on UI
    And   I should see "cartQuantityProduct" will be displayed on UI
    And   I should see "cartDescProduct" will be displayed on UI
    And   I should see "cartPriceProduct" will be displayed on UI
    And   I should see "cartRemoveButton" will be displayed on UI



