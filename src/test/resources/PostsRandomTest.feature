Feature: Random Posts REST endpoint
  Scenario: Fetch all random posts list by REST endpoint
    When The user sends GET request to the random post endpoint
    Then The HTTP status of random post is OK
    Then The Response contains a random post