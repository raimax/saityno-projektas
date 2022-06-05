Feature: Random Posts REST endpoint
  Scenario: Fetch all random posts list by REST endpoint
    When The user sends GET request to the random posts endpoint
    Then The HTTP status of random posts is OK
    Then The Response contains a list of random posts