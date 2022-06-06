Feature: Users REST endpoint
  Scenario: Fetch all users list by REST endpoint
    When The user sends GET request to the users endpoint
    Then The HTTP status of get users OK
    Then The Response contains a list of users