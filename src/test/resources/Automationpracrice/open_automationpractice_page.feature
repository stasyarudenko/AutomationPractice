Feature: Practicing at automationpractice.com page

Scenario: Check if automationpractice.com home page is open
    Given I open google home page
    When I open automationpractice.com page
    Then the page title should be "My Store"
    And the logo should be displayed