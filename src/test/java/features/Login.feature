# Author: Nadim Mahmud

Feature: Login Functionality

  Scenario: Login with valid credentials
    Given User navigates to login page
    When User enters valid email address "test900@gmail.com"
    And User enters valid password "test12345"
    And User clicks on Login button
    Then User should get successfully login

  Scenario: Login with invalid credentials
    Given User navigates to login page
    When User enters invalid email address "test100@gmail.com"
    And User enters invalid password "test123456"
    And User clicks on Login button
    Then User should get proper warning message "Warning: No match for E-Mail Address and/or Password."

  Scenario: Login with invalid email and valid password
    Given User navigates to login page
    When User enters invalid email address "test100@gmail.com"
    And User enters valid password "test12345"
    And User clicks on Login button
    Then User should get proper warning message "Warning: No match for E-Mail Address and/or Password."

  Scenario: Login with valid email and invalid password
    Given User navigates to login page
    When User enters valid email address "test900@gmail.com"
    And User enters invalid password "test123456"
    And User clicks on Login button
    Then User should get proper warning message "Warning: No match for E-Mail Address and/or Password."

  Scenario: Login with empty email and password
    Given User navigates to login page
    When User enters valid email address ""
    And User enters valid password ""
    And User clicks on Login button
    Then User should get proper warning message "Warning: No match for E-Mail Address and/or Password."