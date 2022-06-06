Feature: Top Rated Posts REST endpoint
  Scenario: Fetch all top rated posts list by REST endpoint
    When The user sends GET request to the Top rated posts endpoint
    Then The HTTP status of top rated posts is OK
    Then The Response contains a list of top rated posts