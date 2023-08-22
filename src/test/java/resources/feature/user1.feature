Feature: Testing different request on the user application

  Scenario: Check if the student application can be accessed by users
    When User sends a GET request to list endpoint
    Then User must get back a valid status code 200

  Scenario Outline: Create a new user & verify if the user is added
    When I create a new user by providing the information name "<name>" email "<email>" gender "<gender>" status "<status>"
    Then I verify that the user with "<email>" is created
    Examples:
      | name                    | email                               | gender | status |
      | Mr. Karunanidhi Dubashi | karunanidhi_dubashi_mr2@conn.example | female | active |
      | Bhima Tandon I          | tandon_i_bhima2@moore.test           | male   | active |
