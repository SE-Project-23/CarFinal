Feature: User Profile

  Scenario: Successful Updating Contact Information
    Given the user  has logged in to the system
    When the customer go to "profile setting"
    And the customer click on 'edit profile'
    Then his own contact "information" should be successfully updated with new "info"




   Scenario: Successfully View order history and installation requests
    Given the user is logged in
    When the user navigates to the "order history page"
    Then the user should see a list of past orders





  Scenario:Successfully  View  installation requests
    Given the user is logged in
    When the user navigates to the "installation requests page"
    Then the user should not  see a list of installation requests


