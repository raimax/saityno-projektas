Feature: SignUp REST endpoint
  Scenario: Signup to the app
    When The user sends POST request to the signup endpoint
    Then The HTTP status of signup is OK