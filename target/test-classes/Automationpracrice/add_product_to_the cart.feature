Feature: I can add item to the cart

Scenario: Add product to the cart
    Given I am at the home page
    When I go to the Women catalog page
    And I click on Dresses subcategory
    And I choose Summer Dresses subcategory
    And move mouse on product
    And add product to the cart
    And open the cart
    Then the product displays in the cart