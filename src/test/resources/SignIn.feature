Feature: SignIn REST endpoint
  Scenario: SignIn to the app
    When The user sends POST request to the signin endpoint
    Then The HTTP status of signin is OK