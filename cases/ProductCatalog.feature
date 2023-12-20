Feature: Product Categories

  Scenario: Successful In Making Categories
    Given the system is ready
    When the admin role creates a new category called "Interior"
    Then the categories "Interior" should exist in the system



  Scenario: Success With Inputs
    When the admin role fill the details of products
    And he fill in 'Detailed product descriptions' with 'Your in-car assistant for a smarter drive.'
    And he fills in the 'image' field with a valid image extension such as '.jpg'
    And he fill in 'price' with '20'
    And he fill in 'availability' with '35'
    Then the product information should be saved successfully




  Scenario Outline: Errors with input
    When the admin role fill the details of products
    And he fill in 'Detailed product descriptions' with '<Detailed product descriptions>'
    And he fill in 'image' with '<images>'
    And he fill in 'price' with '<prices>'
    And he fill in 'availability' with '<availability>'
    Then admin role should see a message '<message>'

    Examples:
    Examples:
      | Detailed product descriptions | image | price    | availability | message                                   |
      | 2                                | png    | 20     | 5            | Description should start with  string     |
      | Your in-car assistant for a smarter drive                 | exe    | 20     | 5            | The extension of images should be png     |
      | Your in-car assistant for a smarter drive.                | png    | -2     | 5            | prices must be over zero                  |
      | Your in-car assistant for a smarter drive.               | png    | 0      | 5            | prices must be over zero                  |
      | Your in-car assistant for a smarter drive.                 | png    | 60     | -3           | Availability should be from zero and over |



  Scenario: Product Search
    Given the user is on the product listing page
    When the user enter a character
    And  he click on Search button
    Then Display search results of "character" will be displayed with list of that product




  Scenario: Successful Product Filtering
    Given the user is on the product listing page
    When the user applies a filter for "price" from 12 to 24 dollars

    Then the displayed products should belong to that filter category


