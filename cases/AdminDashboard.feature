 Feature: Admin Dashboard


  Scenario: Add a new product with a category
    Given the system has no existing product listings
    When the admin adds a new product with the name "New Product", category "Electronics", and the price $10.99
    Then the product listing with the category should be visible in the system

   Scenario: Update a new product category
    Given  the system has a category named Exterior
    When   the admin wants to update it from "Exterior" to "Interior"
    Then   it should successfully update it

   Scenario: Attempt to delete a non-existent car accessory category
    Given the system has no existing car accessory categories
    When the admin attempts to delete a category with the name "NonExistentCategory"
    Then the system should indicate that the category "NonExistentCategory" does not exist

  Scenario: Attempt to delete an existent car accessory category
    Given the system has a different categories
    When the admin attempts to delete a category with the name "NonExistentCategory"
    Then the system should indicate that theis category has been deleted successfully

  Scenario: Adding a product listings
    Given the admin role wants to add a new product listing
    When he attempt to added to lists
    Then the product should exist in product list

   Scenario: Update an existing product
    Given the system has an existing product
    When the admin updates the product
    Then the product listing should be updated in the system

  Scenario: View customer account details
    Given there is an existing customer account with the email "customer@example.com"
    When the admin views the details of the customer account
    Then the customer account information should be displayed

  Scenario: Schedule a New Installation Appointment
    Given the admin wants to schedule a new installation appointment
    When the admin schedules the appointment
    Then the appointment should be successfully scheduled

  Scenario: Manage an Existing Installation Appointment
    Given there is an existing installation appointment
    When the admin manages the appointment, updating or canceling as needed
    Then the appointment details should be successfully updated or canceled
