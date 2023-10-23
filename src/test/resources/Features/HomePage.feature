#Feature: Management Home page
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
#    When  I click on "LP_login" button
#    And   I wait for 5 sec
#  @smoke
#  Scenario: As a user, i want to see home page is display as expect
#    Then  I should see "logo" will be displayed on UI
#    And   I should see "mainPage" will be displayed on UI
#    And   I should see "introPage" will be displayed on UI
#    And   I should see "productsPage" will be displayed on UI
#    And   I should see "contactPage" will be displayed on UI
#    And   I should see "cart" will be displayed on UI
#    And   I should see "personal" will be displayed on UI
#    And   I should see "logout" will be displayed on UI
#    And   I should see "carousel" will be displayed on UI
#    And   I should see "titleFeedback" will be displayed on UI
#    And   I should see "listCards" will be displayed on UI
#    And   I should see "titleHot" will be displayed on UI
#    And   I should see "listProducts" will be displayed on UI
#
#  Scenario: As a user, i want to see feedback card display as expect
#    When  I move to "titleFeedback" element
#    Then  I should see "imgCards" will be displayed on UI
#    And   I should see "nameCards" will be displayed on UI
#    And   I should see "starCards" will be displayed on UI
#    And   I should see "textCards" will be displayed on UI
#    And   I should see "statusCards" will be displayed on UI
#
#  Scenario: As a user, i want to see product card display as expect
#    When  I move to "titleHot" element
#    Then  I should see "imageProducts" will be displayed on UI
#    And   I should see "nameProducts" will be displayed on UI
#    And   I should see "priceProducts" will be displayed on UI
#    And   I should see "descriptionProducts" will be displayed on UI
#    And   I should see "orderProducts" will be displayed on UI
#  @smoke
#  Scenario: As a user, i should be navigated to product page after click order in Home Page
#    When  I click on "orderProducts" button
#    Then  I should be navigate to Product Page
#
#
