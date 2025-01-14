Feature: Trendyol 
  Scenario: Search Functionality
    When Search for a product called "kablosuz kulaklik" using the search bar.
    When Verify that the search results are displayed.
    Then Validate that the results contain the searched keyword.

  Scenario: Product Selection
    When Search for a product called "kablosuz kulaklik" using the search bar.
    When From the search results, click on a product to open its details page.
    Then Verify that the product name, price, and availability status are displayed correctly.

  Scenario: Add to Cart
    When Search for a product called "kablosuz kulaklik" using the search bar.
    When From the search results, click on a product to open its details page.
    When Add the selected product to the cart.
    Then Verify that the product appears in the cart with the correct details

  Scenario: Cart Price Validation
    When Search for a product called "kablosuz kulaklik" using the search bar.
    When Add multiple items to the cart.
    Then Verify that the total price in the cart matches the sum of individual product prices.

  Scenario: Remove the Item from the Cart
    When Search for a product called "kablosuz kulaklik" using the search bar.
    When From the search results, click on a product to open its details page.
    When Add the selected product to the cart.
    When Remove an item from the cart.
    Then Verify that the item is no longer listed in the cart and that the total price is updated correctly.