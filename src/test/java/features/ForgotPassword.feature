# Author: Nadim Mahmud

Feature: Forgot Password Functionality

@forgotpassowrd @smoke @regression
Scenario: Verify reset password

  Given User opens the application
  When User clicks on My Account
  And User clicks on Login option
  And Clicks on Forgotten Password option
  And Enters valid email address
  And Clicks on Continue button
  Then Proper confirmation message should be displayed
