Feature: Manage work flow for user from register to order product
  @regression
  Scenario: As a user, i should see products will be show correct after select order
    Given I navigate to Veg Store website
    And   I enter "toanb1906785" into input "username" field
    And   I enter "toanautomation@grr.la" into input "email" field
    And   I enter "123456aA@" into input "password" field
    And   I enter "123456aA@" into input "confirmpassword" field
    And   I click on "male" button
    And   I enter "16/09/2001" into input "birthday" field
    And   I enter "0123456789" into input "number" field
    And   I enter "Ly Tu Trong" into input "address" field
    And   I click on "register" button
    And   I enter "toanautomation@grr.la" into input "LP_email" field
    And   I enter "123456aA@" into input "LP_password" field
    And   I click on "LP_login" button
    And   I click on "productsPage" button
    And   I enter "5" into input "firstProduct" field
    And   I click on "firstOrder" button
    And   I enter "5" into input "secondProduct" field
    And   I click on "secondOrder" button
    When  I click on "cart" button
    Then  I should see "SP01" displayed on "codeProduct" list screen
    And   I should see "SP02" displayed on "codeProduct" list screen
    And   I should see "Bắp Cải" displayed on "detailProductOrder" list screen
    And   I should see "Cà Rốt" displayed on "detailProductOrder" list screen
    And   I should see "33.000 ₫" displayed on "detailProductOrder" list screen
    And   I should see "16.000 ₫" displayed on "detailProductOrder" list screen
    And   I should see "5" displayed on "detailProductOrder" list screen
    And   I should see "165.000 ₫" displayed on "detailProductOrder" list screen
    And   I should see "80.000 ₫" displayed on "detailProductOrder" list screen
    And   I should see "10" on "quantityCart"
    And   I should see "245.000 ₫" on "total"
    And   I should see "24.050 ₫" on "tax"
    And   I should see "269.500 ₫" on "totalAfterTax"








