Feature: Comment REST endpoint
  Scenario: Add a comment
    When The user sends POST request to the comments endpoint
    Then The HTTP status of post comments is OK