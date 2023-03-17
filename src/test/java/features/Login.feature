# Author: Nadim Mahmud

@all
Feature: Login Functionality

Background:
  Given User navigates to login page

@login @smoke @regression
Scenario Outline: Login with valid credentials
  When User enters valid email address <email>
  And User enters valid password <password>
  And User clicks on Login button
  Then User should get successfully login

  Examples:
  |email              |password      |
  |test900@gmail.com  |test12345     |
  |test100@gmail.com  |test123456    |
  |test100@gmail.com  |test12345     |
  |test900@gmail.com  |test123456    |

@login @smoke @regression
Scenario: Login with invalid credentials
  When User enters invalid email address <email>
  And User enters invalid password <password>
  And User clicks on Login button
  Then User should get proper warning message "Warning: No match for E-Mail Address and/or Password."

@login @smoke @regression
Scenario: Login with invalid email and valid password
  When User enters invalid email address <email>
  And User enters valid password <password>
  And User clicks on Login button
  Then User should get proper warning message "Warning: No match for E-Mail Address and/or Password."

@login @smoke @regression
Scenario: Login with valid email and invalid password
  When User enters valid email address <email>
  And User enters invalid password <password>
  And User clicks on Login button
  Then User should get proper warning message "Warning: No match for E-Mail Address and/or Password."

@login @smoke @regression
Scenario: Login with empty email and password
  When User dont enters any credentials
  And User clicks on Login button
  Then User should get proper warning message "Warning: No match for E-Mail Address and/or Password."