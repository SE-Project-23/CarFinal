Feature: Order Processing and Installation Requests


  Scenario: Send order confirmation email to customer
    Given a customer with the email address "customer@example.com"
    When the order is confirmed
    Then an order confirmation email should be sent to the customer



  Scenario: Send order update notification to customer
    Given a customer with the email address "customer@example.com"
    When the order is updated
    Then an order update notification should be sent to the customer



  Scenario: Inform installer about new installation request via email
    Given an installer with the email address "installer@example.com"
    When a new installation request is received
    Then an email notification should be sent to the installer

  Scenario: Inform installer about new installation request via push notification
    Given an installer with the device token "xyz789"
    When a new installation request is received
    Then a push notification should be sent to the installer's device