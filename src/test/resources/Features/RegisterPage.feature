#@test
#Feature: Management Registration page
#
#  Background: As a user, i navigate to the Veg Store website
#    Given I navigate to Veg Store website
#  @smoke
#  Scenario Outline: As a user, i want to signup successfully with correct value
#    And   I enter "<username>" into input "username" field
#    And   I enter "<email>" into input "email" field
#    And   I enter "<password>" into input "password" field
#    And   I enter "<confirmpassword>" into input "confirmpassword" field
#    And   I click on "male" button
#    And   I enter "<birthday>" into input "birthday" field
#    And   I enter "<number>" into input "number" field
#    And   I enter "<address>" into input "address" field
#    When  I click on "register" button
#    Then  I should be navigate to Login Page
#
#    Examples:
#      | username     | email                 | password  | confirmpassword | birthday   | number     | address     |
#      | toanb1906785 | toanautomation@grr.la | 123456aA@ | 123456aA@       | 16/09/2001 | 0123456789 | Ly Tu Trong |
#  @smoke
#  Scenario Outline: As a user, i should be register fail with leaves blank password input
#    And   I enter "<username>" into input "username" field
#    And   I enter "<email>" into input "email" field
#    And   I enter "<password>" into input "password" field
#    And   I enter "<confirmpassword>" into input "confirmpassword" field
#    And   I click on "male" button
#    And   I enter "<birthday>" into input "birthday" field
#    And   I enter "<number>" into input "number" field
#    And   I enter "<address>" into input "address" field
#    When  I click on "register" button
#    Then  I should see "Mật khẩu phải ít nhất 6 ký tự!" in alert message
#
#    Examples:
#      | username     | email                 | password  | confirmpassword | birthday   | number     | address     |
#      | toanb1906785 | toanautomation@grr.la |           | 123456aA@       | 16/09/2001 | 0123456789 | Ly Tu Trong |
#  @smoke
#  Scenario Outline: As a user, i should be register fail with leaves blank username input
#    And   I enter "<username>" into input "username" field
#    And   I enter "<email>" into input "email" field
#    And   I enter "<password>" into input "password" field
#    And   I enter "<confirmpassword>" into input "confirmpassword" field
#    And   I click on "male" button
#    And   I enter "<birthday>" into input "birthday" field
#    And   I enter "<number>" into input "number" field
#    And   I enter "<address>" into input "address" field
#    When  I click on "register" button
#    Then  I should see "Tên đăng nhập ít nhất có 3 ký tự!" in alert message
#
#    Examples:
#      | username     | email                 | password  | confirmpassword | birthday   | number     | address     |
#      |              | toanautomation@grr.la | 123456aA@ | 123456aA@       | 16/09/2001 | 0123456789 | Ly Tu Trong |
#  @smoke
#  Scenario Outline: As a user, i should be register fail with leaves blank confirm password input
#    And   I enter "<username>" into input "username" field
#    And   I enter "<email>" into input "email" field
#    And   I enter "<password>" into input "password" field
#    And   I enter "<confirmpassword>" into input "confirmpassword" field
#    And   I click on "male" button
#    And   I enter "<birthday>" into input "birthday" field
#    And   I enter "<number>" into input "number" field
#    And   I enter "<address>" into input "address" field
#    When  I click on "register" button
#    Then  I should see "Mật khẩu nhập lại không đúng!" in alert message
#
#    Examples:
#      | username     | email                 | password  | confirmpassword | birthday   | number     | address     |
#      | toanb1906785 | toanautomation@grr.la | 123456aA@ |                 | 16/09/2001 | 0123456789 | Ly Tu Trong |
#  @smoke
#  Scenario Outline: As a user, i should be register fail with leaves blank sex textbox
#    And   I enter "<username>" into input "username" field
#    And   I enter "<email>" into input "email" field
#    And   I enter "<password>" into input "password" field
#    And   I enter "<confirmpassword>" into input "confirmpassword" field
#    And   I enter "<birthday>" into input "birthday" field
#    And   I enter "<number>" into input "number" field
#    And   I enter "<address>" into input "address" field
#    When  I click on "register" button
#    Then  I should see "Vui lòng chọn giới tính!" in alert message
#
#    Examples:
#      | username     | email                 | password  | confirmpassword | birthday   | number     | address     |
#      | toanb1906785 | toanautomation@grr.la | 123456aA@ | 123456aA@       | 16/09/2001 | 0123456789 | Ly Tu Trong |
#  @smoke
#  Scenario Outline: As a user, i should be register fail with leaves blank birthday input
#    And   I enter "<username>" into input "username" field
#    And   I enter "<email>" into input "email" field
#    And   I enter "<password>" into input "password" field
#    And   I enter "<confirmpassword>" into input "confirmpassword" field
#    And   I click on "male" button
#    And   I enter "<birthday>" into input "birthday" field
#    And   I enter "<number>" into input "number" field
#    And   I enter "<address>" into input "address" field
#    When  I click on "register" button
#    Then  I should see "Nhập không đúng format ngày sinh" in alert message
#
#    Examples:
#      | username     | email                 | password  | confirmpassword | birthday   | number     | address     |
#      | toanb1906785 | toanautomation@grr.la | 123456aA@ | 123456aA@       |  21354sda  | 0123456789 | Ly Tu Trong |
#  @smoke
#  Scenario Outline: As a user, i should be register fail with leaves blank number phone input
#    And   I enter "<username>" into input "username" field
#    And   I enter "<email>" into input "email" field
#    And   I enter "<password>" into input "password" field
#    And   I enter "<confirmpassword>" into input "confirmpassword" field
#    And   I click on "male" button
#    And   I enter "<birthday>" into input "birthday" field
#    And   I enter "<number>" into input "number" field
#    And   I enter "<address>" into input "address" field
#    When  I click on "register" button
#    Then  I should see "Vui lòng nhập số điện thoại!" in alert message
#
#    Examples:
#      | username     | email                 | password  | confirmpassword | birthday    | number     | address     |
#      | toanb1906785 | toanautomation@grr.la | 123456aA@ | 123456aA@       |  16/09/2001 |            | Ly Tu Trong |
#  @smoke
#  Scenario Outline: As a user, i should be register fail with leaves blank address input
#    And   I enter "<username>" into input "username" field
#    And   I enter "<email>" into input "email" field
#    And   I enter "<password>" into input "password" field
#    And   I enter "<confirmpassword>" into input "confirmpassword" field
#    And   I click on "male" button
#    And   I enter "<birthday>" into input "birthday" fielda
#    And   I enter "<number>" into input "number" field
#    And   I enter "<address>" into input "address" field
#    When  I click on "register" button
#    Then  I should see "Vui lòng nhập địa chỉ" in alert message
#
#    Examples:
#      | username     | email                 | password  | confirmpassword | birthday    | number     | address     |
#      | toanb1906785 | toanautomation@grr.la | 123456aA@ | 123456aA@       |  16/09/2001 | 0123456789 |             |