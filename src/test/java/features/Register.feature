# Author: Nadim Mahmud

Feature: Registration Functionality

  Background:
    Given User navigates to register page

  Scenario: User create an account with all required fields
    When User enters the details into below fields
    | firstName      | William            |
    | lastName       | Smith              |
    | email          | test901@gmail.com  |
    | telephone      | 9085380500         |
    | validPassword  | test12345          |
    And User selects privacy policy checkbox
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario: User create an account with all fields
    When User enters the details into below fields
      | firstName      | William            |
      | lastName       | Smith              |
      | email          | test902@gmail.com  |
      | telephone      | 9085380500         |
      | validPassword  | test12345          |
    And User selects yes for newsletter
    And User selects privacy policy checkbox
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario: User create an account with duplicate email
    When User enters the details into below fields
      | firstName      | William            |
      | lastName       | Smith              |
      | email          | test900@gmail.com  |
      | telephone      | 9085380500         |
      | validPassword  | test12345          |
    And User selects privacy policy checkbox
    And User clicks on Continue button
    Then User should get proper warning message

  Scenario: User create an account with empty data
    When User don't enter any details into input fields
    And User clicks on Continue button
    Then User should get proper warning message for every required input fields

