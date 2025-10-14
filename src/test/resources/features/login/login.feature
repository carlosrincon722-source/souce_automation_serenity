Feature: login with correct user and password
  i want start session correctly

    Scenario: login with correct user and password
      Given  The user open the web page
      When the user try to login in the web page with the username "standard_user" and password "secret_sauce"
      Then the user must see the inventory
