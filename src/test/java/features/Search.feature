# Author: Nadim Mahmud

Feature: Search functionality

  Background:
    Given User navigates to home page

  Scenario: Search with valid product
    When User enters valid product "HP" into search input field
    And User clicks on search button
    Then User should get valid product displayed in search result

  Scenario: Search with invalid product
    When User enters invalid product "Dell" into search input field
    And User clicks on search button
    Then User should get message about no product matching

  Scenario: Search with empty product
    When User enters no product into search input field
    And User clicks on search button
    Then User should get message about no product matching