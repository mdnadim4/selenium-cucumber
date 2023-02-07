# Author: Nadim Mahmud

Feature: Search functionality

  Scenario: Search with valid product
    Given User has navigate to home page
    When User enters valid product "HP" into search input field
    And User clicks on search button
    Then User should get valid product displayed in search result

  Scenario: Search with invalid product
    Given User has navigate to home page
    When User enters invalid product "Dell" into search input field
    And User clicks on search button
    Then User should get message about no product matching

  Scenario: Search with empty product
    Given User has navigate to home page
    When User enters no product into search input field
    And User clicks on search button
    Then User should get message about no product matching