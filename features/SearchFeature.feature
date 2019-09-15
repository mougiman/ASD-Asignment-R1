# SearchFeature Feature
# language: en
@SearchFeatureScenario
Feature: SearchFeature
  As a user of Shop and Buy
  I want to browse items by category
  In order to find my items easier

Background: User navigates to Shop and Buy homepage
   Given I am on the home page

  Scenario: Successful view of items with "car" category
    When I fill in "Searchbox" with "car"
    And I select the "Category" radio button
    Then I should see items with category "car"

  Scenario Outline: Failed to view items with "car" category using wrong category
    When I fill "Searchbox" with nothing
    And I select the "Category" radio button
    Then I should see no items