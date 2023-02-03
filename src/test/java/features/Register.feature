# Author: Nadim Mahmud

Feature: Registration Functionality

  Scenario: Register with all required input fields
    Given User has navigate to register page
    When User enters the details into below fields
    | firstName      | William    |
    | lastName       | Smith      |
    | email          |            |
    | telephone      | 9085380500 |
    | validPassword  | test12345  |


  Scenario: Register with all input fields

  Scenario: Register with existing email address

  Scenario: Register with empty data

