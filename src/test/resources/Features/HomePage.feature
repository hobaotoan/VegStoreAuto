Feature: Management Home page

  Background: As a user, i want to signin successfully
    Given I navigate to the Sauce website
    And   I enter "standard_user" into input "usernameTxt" field
    And   I enter "secret_sauce" into input "passwordTxt" field
    And   I click on "signinBtn" button

  Scenario: As a user, i want to see home page is display as expect
    Then  I should see "logoLogin" will be displayed on UI
    And   I should see "shoppingCart" will be displayed on UI
    And   I should see "menuBurger" will be displayed on UI
    And   I should see "titleHeader" will be displayed on UI
    And   I should see "dropdown" will be displayed on UI
    And   I should see "listItem" will be displayed on UI

  Scenario: As a user, i want to see each product is display as expect
    Then  I should see "imageProduct" will be displayed on UI
    And   I should see "nameProduct" will be displayed on UI
    And   I should see "descProduct" will be displayed on UI
    And   I should see "priceProductWithDollar" will be displayed on UI
    And   I should see "buttonProduct" will be displayed on UI

  Scenario: As a user, i want to see details sidebar as expect
    When  I click on "menuBurger" button
    Then  I should see "allItemsLink" will be displayed on UI
    And   I should see "aboutLink" will be displayed on UI
    And   I should see "logoutLink" will be displayed on UI
    And   I should see "resetAppStateLink" will be displayed on UI
    And   I should see "closeButton" will be displayed on UI

  Scenario: As a user, i want to see quantity will be change after add product to cart
    When  I click on "firstAddProduct" button
    Then  I should see "quantityCart" will be displayed on UI
    And   I should see "firstRemoveProduct" will be displayed on UI

  Scenario: As a user, i want to see list name products will change after i click to order
    When  I get list name products with "nameProduct" list products
    And   I choose "Name (Z to A)" option from dropdown "selectDropDown"
    Then  I should see "nameProduct" list name product will change after sorted

  Scenario: As a user, i want to see list price products will change after i click to order
    When  I choose "Price (low to high)" option from dropdown "selectDropDown"
    And   I wait for 3 sec
    And   I get list price products with "priceProduct" list products
    And   I choose "Price (high to low)" option from dropdown "selectDropDown"
    Then  I should see "priceProduct" list price product will change after sorted

  Scenario: As a user, i want to see correct information of products as expect
    When  I get image link of product with "imgAProduct"
    And   I get data of product with "nameAProduct"
    And   I get data of product with "descAProduct"
    And   I get data of product with "priceAProduct"
    And   I click on "nameAProduct" button
    Then  I should see content details displayed on "imgAProductInDetail"
    And   I should see content details displayed on "nameAProductInDetail"
    And   I should see content details displayed on "descAProductInDetail"
    And   I should see content details displayed on "priceAProductInDetail"
    And   I should see "buttonAProductInDetail" will be displayed on UI