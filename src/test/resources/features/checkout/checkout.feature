Feature: Validate the checkout process
  I want to verify that the user can complete the purchase flow successfully

  Background:
    Given The user has logged in with the username "standard_user" and the password "secret_sauce"
    And the user has added some products and check the products in the cart page
    When the user goes to the checkout page

    Scenario: Complete a checkout successfully
      And the user fills the form with first name "Carlos", last name "Rincon" and postal code "110111"
      And  the user calculate the price and finish the purchase
      Then the user should see the message "THANK YOU FOR YOUR ORDER!"

  Scenario Outline: Validate missing information in the checkout form
    And the user fills the form with first name "<firstName>", last name "<lastName>" and postal code "<postalCode>"
    Then the user should see the error message "<expectedMessage>"

    Examples:
      | firstName | lastName | postalCode | expectedMessage                      |
      |            | Rincon   | 110111     | Error: First Name is required        |
      | Carlos     |          | 110111     | Error: Last Name is required         |
      | Carlos     | Rincon   |            | Error: Postal Code is required       |