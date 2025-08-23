@UI

Feature: Test Ebay

  @TestSomething
  Scenario Outline: Validate search results and filter
    Given I open url "https://www.ebay.com/"
    When I search with "<Search_Keyword>"
    Then I should see search results containing all or partial search Keyword "<Search_Keyword>"
    And I notice the count of results displayed
    And I filter under "Transmission" with "Manual"
    Examples:
      | Search_Keyword |
      | mazda mx-5     |