Feature: Likes REST endpoint
  Scenario: Add a like to post
    When The user sends POST request to the likes endpoint
    Then The HTTP status of post likes is OK