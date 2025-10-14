Feature: Validated filters of the products page
  i want validated every filter on the products


  Background:
    Given The user has logged in with the username "standard_user" and the password "secret_sauce"

    Scenario Outline: test the diferents filters
      When the user select the filter value "<value>"
      Then the user has to look at the products in a specific order "<order>" and the value in the filter

      Examples:
        | value | order               |
        | az    | Name (A to Z)       |
        | za    | Name (Z to A)       |
        | lohi  | Price (low to high) |
        | hilo  | Price (high to low) |
