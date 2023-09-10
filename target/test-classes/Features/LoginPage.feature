Feature: Management Login page

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
  @smoke
  Scenario Outline: As a user, i want to login successfully with correct value has registered before
    And   I enter "<email>" into input "LP_email" field
    And   I enter "<password>" into input "LP_password" field
    When  I click on "LP_login" button
    Then  I should be navigate to Home Page
    And   I should see "logo" will be displayed on UI

    Examples:
      | email                 | password  |
      | toanautomation@grr.la | 123456aA@ |
  @smoke
  Scenario Outline: As a user, i should see a message show in alert with incorrect data
    And   I enter "<email>" into input "LP_email" field
    And   I enter "<password>" into input "LP_password" field
    When  I click on "LP_login" button
    Then  I should see "Email hoặc Mật Khẩu không trùng khớp với lúc đăng ký" in alert message

    Examples:
      | email                 | password  |
      | toanautomation@grr.la |           |
      |                       | 123456aA@ |
      | toanautomation@rr.la  | 12345aA@  |
