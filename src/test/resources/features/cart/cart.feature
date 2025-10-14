

Feature:  Validate the cart functionality
  I want to ensure that the cart updates and behaves correctly when adding or removing products


    Background:
      Given The user has logged in with the username "standard_user" and the password "secret_sauce"
      When the user adds a random number of products to the cart

  @card
  Scenario: The user adds multiple products and sees the correct cart count
    Then the cart counter should display the correct number of products

  @card
  Scenario: The user adds and removes multiple products and sees the correct cart count
    And the user removes the products that he added
    Then the cart counter should display the correct number of products

  @card1
  Scenario: The user adds multiple products and check in the cart page the same numbers of products
    And the user go to the cart page
    Then The user sees the same number of products that he selected

