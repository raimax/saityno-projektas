Feature: Posts REST endpoint
  Scenario: Fetch all posts list by REST endpoint
    When The user sends GET request to the posts endpoint
    Then The HTTP status of posts is OK
    Then The Response contains a list of posts