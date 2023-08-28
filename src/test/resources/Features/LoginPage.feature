Feature: Management Login page

  Background: As a user, i navigate to the Sauce website
    Given I navigate to the Sauce website

  Scenario Outline: As a user, i want to signin successfully with correct value
    And   I enter "<username>" into input "usernameTxt" field
    And   I enter "<password>" into input "passwordTxt" field
    And   I click on "signinBtn" button
    Then  I should see "logoHomePage" will be displayed on UI

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |

  Scenario Outline: As a user, i should be signin fail with leaves blank any input
    And   I enter "<username>" into input "usernameTxt" field
    And   I enter "<password>" into input "passwordTxt" field
    And   I click on "signinBtn" button
    Then  I should see "Epic sadface: Username is required" on "errorMessage"

    Examples:
      | username | password  |
      |          | 123456aA@ |
      |          |           |

  Scenario Outline: As a user, i should be signin fail with leaves blank password input
    And   I enter "<username>" into input "usernameTxt" field
    And   I enter "<password>" into input "passwordTxt" field
    And   I click on "signinBtn" button
    Then  I should see "Epic sadface: Password is required" on "errorMessage"

    Examples:
      | username      | password  |
      | standard_user |           |

  Scenario Outline: As a user, i should be signin fail with wrong password
    And   I enter "<username>" into input "usernameTxt" field
    And   I enter "<password>" into input "passwordTxt" field
    And   I click on "signinBtn" button
    Then  I should see "Epic sadface: Username and password do not match any user in this service" on "errorMessage"

    Examples:
      | username       | password      |
      | standard_user  | secret_sauce1 |
      | standard_user1 | secret_sauce  |
