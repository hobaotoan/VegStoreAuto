Feature: Management Complete page

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
    And   I click on "finishButton" button

  Scenario: As a user, i should see complete page shown as expect
    Then  I should see "titleComplete" will be displayed on UI
    And   I should see "imgSuccessfully" will be displayed on UI
    And   I should see "Thank you for your order!" on "headerComplete"
    And   I should see "Your order has been dispatched, and will arrive just as fast as the pony can get there!" on "textComplete"
    And   I should see "backhomeButton" will be displayed on UI

  Scenario: As a user, i should be return home page after click back home
    When  I click on "backhomeButton" button
    Then  I should be navigate to the Home Page




