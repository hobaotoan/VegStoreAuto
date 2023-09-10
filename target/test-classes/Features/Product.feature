@test
Feature: Management Product page

  Background: As a user, i navigate to the Veg Store website
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
  @smoke
  Scenario: As a user, i want to see introduction page is display as expect
    Then  I should see "SẢN PHẨM." on "titleProduct"
    And   I should see "listProduct" will be displayed on UI
    And   I should see "pagination" will be displayed on UI
  @smoke
  Scenario: As a user, i want to see product display as expect
    Then  I should see "imgProduct" will be displayed on UI
    And   I should see "nameProduct" will be displayed on UI
    And   I should see "descriptionProduct" will be displayed on UI
    And   I should see "quantityProduct" will be displayed on UI
    And   I should see "orderProduct" will be displayed on UI
  @smoke
  Scenario: As a user, i want to see product display as expect after navigate to first of pagination
    When  I click on "paginationFirst" button
    Then  I should see "imgProduct" will be displayed on UI
    And   I should see "nameProduct" will be displayed on UI
    And   I should see "descriptionProduct" will be displayed on UI
    And   I should see "quantityProduct" will be displayed on UI
    And   I should see "orderProduct" will be displayed on UI
  @smoke
  Scenario: As a user, i want to see product display as expect after navigate to second of pagination
    When  I click on "paginationSecond" button
    Then  I should see "imgProduct" will be displayed on UI
    And   I should see "nameProduct" will be displayed on UI
    And   I should see "descriptionProduct" will be displayed on UI
    And   I should see "quantityProduct" will be displayed on UI
    And   I should see "orderProduct" will be displayed on UI
  @smoke
  Scenario: As a user, i want to see product display as expect after navigate to last of pagination
    When  I click on "paginationLast" button
    Then  I should see "imgProduct" will be displayed on UI
    And   I should see "nameProduct" will be displayed on UI
    And   I should see "descriptionProduct" will be displayed on UI
    And   I should see "quantityProduct" will be displayed on UI
    And   I should see "orderProduct" will be displayed on UI




