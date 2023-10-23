#Feature: Management Cart Details page
#
#  Background: As a user, i navigate to the Veg Store website
#    Given I navigate to Veg Store website
#    And   I enter "toanb1906785" into input "username" field
#    And   I enter "toanautomation@grr.la" into input "email" field
#    And   I enter "123456aA@" into input "password" field
#    And   I enter "123456aA@" into input "confirmpassword" field
#    And   I click on "male" button
#    And   I enter "16/09/2001" into input "birthday" field
#    And   I enter "0123456789" into input "number" field
#    And   I enter "Ly Tu Trong" into input "address" field
#    And   I click on "register" button
#    And   I enter "toanautomation@grr.la" into input "LP_email" field
#    And   I enter "123456aA@" into input "LP_password" field
#    And   I click on "LP_login" button
#    And   I click on "cart" button
#  @smoke
#  Scenario: As a user, i want to see cart details page is display default as expect
#    Then  I should see "GIỎ HÀNG CỦA TÔI." on "titleCartDetail"
#    And   I should see "Mã Sản Phẩm" displayed on "titleTable" list screen
#    And   I should see "Tên Sản Phẩm" displayed on "titleTable" list screen
#    And   I should see "Hình ảnh" displayed on "titleTable" list screen
#    And   I should see "Đơn Giá" displayed on "titleTable" list screen
#    And   I should see "Số Lượng" displayed on "titleTable" list screen
#    And   I should see "Thành Tiền" displayed on "titleTable" list screen
#    And   I should see "Tổng thành tiền (A) = 0 ₫" displayed on "informationTotalDefault" list screen
#    And   I should see "Chiết khấu (B) = 0.1 x A =0 ₫" displayed on "informationTotalDefault" list screen
#    And   I should see "Thuế (C) = 10% x (A - B) = 0 ₫" displayed on "informationTotalDefault" list screen
#    And   I should see "Tổng đơn hàng = A - B + C = 0 ₫" displayed on "informationTotalDefault" list screen
#    And   I should see "0" on "quantityCart"
#
#
#
