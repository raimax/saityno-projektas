Feature: Top Likes Posts REST endpoint
  Scenario: Fetch all top liked posts list by REST endpoint
    When The user sends GET request to the Top liked posts endpoint
    Then The HTTP status of top liked posts is OK
    Then The Response contains a list of top liked posts