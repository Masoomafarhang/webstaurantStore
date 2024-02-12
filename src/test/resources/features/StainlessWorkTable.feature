Feature: Users should be able to search and add items
  User Story:
  As a user, I should be able to add and clear the cart with the items I searched.

  @ui
  Scenario: Verify the users can add and clear the cart with the items they search.
    Given the user lands on the home page
    When user searches for "stainless work table"
    Then the user should see the word "Table" in the title of each product
    Then the user should be able to add the last found items to the Cart
    Then the user should be able to empty the cart.