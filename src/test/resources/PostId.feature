Feature: PostId REST endpoint
  Scenario: Fetch a single post with id by REST endpoint
    When The user sends GET request to the post endpoint
    Then The HTTP status of post is OK
    Then The Response contains a post with specified ID