@POST
Feature: To verify POST method operation on API endpoint http://restapi.demoqa.com/customer/register

  Scenario: To register a user using post method
    When user register a user with details firstname "Tushar", salary "1200", age "25"
    Then receives satus code as 200
    And "success" is present in response body
    # and response success code is "OPERATION_SUCCESS"
