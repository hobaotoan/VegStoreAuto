Feature: Management Contact page

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
    And   I click on "contactPage" button
  @smoke
  Scenario: As a user, i want to see contact page is display as expect
    Then  I should see "LIÊN HỆ." on "titleContact"
    And   I should see "Địa chỉ: 3/2, Xuân Khánh, Ninh Kiều, TP.Cần Thơ" displayed on "informationContact" list screen
    And   I should see "Đại lý: 30/4, Hưng Lợi, Ninh Kiều, TP.Cần Thơ" displayed on "informationContact" list screen
    And   I should see "Cửa hàng: 1 Lý Tự Trọng, An Lạc, Ninh Kiều, TP.Cần Thơ" displayed on "informationContact" list screen
    And   I should see "Email: cskh@veg.com" displayed on "informationContact" list screen
    And   I should see "Hotline: 0123 456 789" displayed on "informationContact" list screen
    And   I should see "Website: https://www.vegstore.com/" displayed on "informationContact" list screen





