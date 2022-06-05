Feature: Users REST endpoint
  Scenario: Fetch all users list by REST endpoint
    When The user sends GET request to the endpoint
    Then The HTTP status is OK
    Then The Response contains a list of users