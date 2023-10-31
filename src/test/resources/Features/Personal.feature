
Feature: Management Personal page

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
    And   I click on "personal" button
  @smoke
  Scenario: As a user, i want to see personal page is display as expect
    Then  I should see "HỒ SƠ CỦA TÔI." on "titlePersonal"
    And   I should see "Tên đăng nhập:" displayed on "label" list screen
    And   I should see "Email:" displayed on "label" list screen
    And   I should see "Số điện thoại:" displayed on "label" list screen
    And   I should see "Giới tính:" displayed on "label" list screen
    And   I should see "Ngày sinh:" displayed on "label" list screen
    And   I should see "Địa chỉ:" displayed on "label" list screen
    And   I should see "namePersonal" will be displayed on UI
    And   I should see "emailPersonal" will be displayed on UI
    And   I should see "numberPersonal" will be displayed on UI
    And   I should see "datePersonal" will be displayed on UI
    And   I should see "addressPersonal" will be displayed on UI
    And   I should see "save" will be displayed on UI
    And   I should see "Lưu" on "save"
  @smoke
  Scenario Outline: As a user, i want to see username, email and number were displayed correct data
    Then  I should see "<username>" on "namePersonal"
    And   I should see "<email>" on "emailPersonal"
    And   I should see "<number>" on "numberPersonal"

    Examples:
      | username     | email                 | number     |
      | toanb1906785 | toanautomation@grr.la | 0123456789 |







