Feature: Validate functionality of the login
  i want valid any validation in the login of the  web application


  Background:
    Given  The user open the web page

  Scenario Outline: test the diferents validations in the form login
    When the user try to login in the web page with the username "<user>" and password "<password>"
    Then the user must see the result "<result>"

    Examples:
      | user            | password     | result                                              |
      |                 |              | Epic sadface: Username is required                  |
      | standard_user   |              | Epic sadface: Password is required                  |
      |                 | secret_sauce | Epic sadface: Username is required                  |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out. |
