@UI

Feature: Test Orange HRM

  Background:
    Given I open url "https://opensource-demo.orangehrmlive.com/"

  @TestSomething
  Scenario Outline: Validate create and delete user
    Given I login with "Admin" user
    And I open tab named "Admin"
    And I read the number of existing user records
    When I add new user
      | User Role     | Admin              |
      | Employee Name | Peter Mac Anderson |
      | Status        | Enabled            |
      | Username      | <Username>         |
      | Password      | Automation123      |
    Then Number of existing users will be increased by 1
    When I search for user with username "<Username>"
    And I delete user "<Username>"
    And Reset search
    Then Original number of users will be displayed
    Examples:
      | Username |
      | Test123z |