Feature: create crm-project

  Background:
    Given I am authorized

  Scenario Outline:
    Given I am at projects requests page
    When I fill '<name>' field
    And I fill company
    And I select priority
    And I select finance source
    And I select business unit
    And I select curator
    And I select rp
    And I select administrator
    And I select manager
    And I select contact main
    And I fill planning
    And I fill requirements management
    And I fill development
    And I fill testing
    And I click save and close button
    Then Success message is visible
    Examples:
      | name |
      | test |
      | 0    |