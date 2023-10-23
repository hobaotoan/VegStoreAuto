#Feature: Management Introduction page
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
#    And   I click on "introPage" button
#  @smoke
#  Scenario: As a user, i want to see introduction page is display as expect
#    Then  I should see "GIỚI THIỆU." on "introTitle"
#    And   I should see "Veg là cửa hàng thực phẩm sạch chuyên cung cấp các mặt hàng rau củ quả với mục tiêu giúp người tiêu dùng Việt Nam có một cuộc sống khỏe mạnh hơn thông qua những loại thực phẩm hữu cơ có chứng nhận, thực phẩm tự nhiên." on "content"
#    And   I should see "Miễn phí vận chuyển" displayed on "policy" list screen
#    And   I should see "Thanh toán dễ dàng" displayed on "policy" list screen
#    And   I should see "Phục vụ 24/7" displayed on "policy" list screen
#    And   I should see "policyCard" will be displayed on UI
#    And   I should see "imgIntro" will be displayed on UI
#
#
#
#
#
