@functional
Feature: Adding items to cart
  
  This feature is to verify amazon add to cart related scenarios

  Background: 
    Given I am on amazon web page

  @sanity
  Scenario Outline: Adding a "<item-name>" into Cart and verifying the sub total
    Given I Search for an item "<item-name>" and press enter
    And I Select the "<item-order>" item from the result page
    And I navigate to the product page and capture the product price of "<item-name>"
    And I add the item to the cart by clicking on Add to Cart button
    And I open the Cart by clicking the top-right cart icon
    Then I validate that the sub total amount on cart page is identical to the product page for "<item-name>"

    Examples: 
      | item-name | item-order |
      | Monitor   |          1 |
      | Laptop    |          2 |

  @smoke
  Scenario Outline: Adding two items into Cart and verifying the sub total
    Given I Search for an item "<item-name-1>" and press enter
    When I Select the "<item1-order>" item from the result page
    And I navigate to the product page and capture the product price of "<item-name-1>"
    And I add the item to the cart by clicking on Add to Cart button
    And I navigate to Amazon Home page
    And I Search for an item "<item-name-2>" and press enter
    And I Select the "<item2-order>" item from the result page
    And I navigate to the product page and capture the product price of "<item-name-2>"
    And I add the item to the cart by clicking on Add to Cart button
    And I open the Cart by clicking the top-right cart icon
    Then I validate that the sub total amount on cart page is identical to the product page for "<item-name-1>,<item-name-2>"

    Examples: 
      | item-name-1 | item-name-2 | item1-order | item2-order |
      | Headphone   | Keyboard    |           1 |           2 |
