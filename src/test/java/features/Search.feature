Feature: Search Item
  Scenario: Search some value
    When Search for a product called "kablosuz kulaklik" using the search bar.
    When Verify that the search results are displayed.
    Then Validate that the results contain the searched keyword.