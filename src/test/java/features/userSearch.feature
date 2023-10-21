@smoke
Feature: User Search

  Scenario Outline: User Search
    Given get data from datasheet with "<row_number>" and "<sheetName>"
    Then login to the application
    When User navigate to admin page
    And User search for username
    Then User verify the search results
    And User clear the search results

    Examples: 
      | row_number | sheetName |
      |          1 | Login     |
      |          2 | Login     |
