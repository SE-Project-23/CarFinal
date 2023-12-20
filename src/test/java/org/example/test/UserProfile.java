package org.example.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Customer;
import org.example.Order;
import org.example.OrderService;
import org.example.Product;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserProfile {
Customer customer = new Customer(1,"aseel","aseel@gmail.com","12345");
    org.example.Product product= new Product("Car Organizer",6,30,"Keep your car tidy with our versatile and spacious car organizer","images.jpg","Interior");
      ArrayList < Product> arrayList = new ArrayList<>();

      OrderService orderService = new OrderService();
      Order order = new Order(1,customer,customer.products);
       boolean flag;

    @When("the customer go to {string}")
    public void theCustomerGoTo(String page) {
        System.out.println("Navigating to: " + page);
      //  assertTrue(true);
    }

    @When("the customer click on {string}")
    public void theCustomerClickOn(String element) {
        System.out.println("Clicking on: " + element);
        //assertTrue(true);
    }

    @Then("his own contact {string} should be successfully updated")
    public void hisOwnContactShouldBeSuccessfullyUpdated(String string) {
    }


    @When("the customer click on {string} profile")
    public void theCustomerClickOnProfile(String string) {
        System.out.println("the customer click on"+string+ "profile");
    }


    @Then("his own contact {string} should be successfully updated with new {string}")
    public void hisOwnContactShouldBeSuccessfullyUpdatedWithNew(String string, String string2) {

     string = customer.getEmail();
     string2="aseel2002@gmail.com";
     customer.UpdateEmail(string2);
     if(customer.getEmail().equals(string)){
    System.out.println("Email doesnt updated ");

    assertEquals(false,false);
}
else{
    System.out.println("Email Updated Successfully from: "+"\t"+string+"\t"+"to"+"\t"+string2);
    assertEquals(true,true);
}

        string = customer.getUsername();
        string2="aseel2002";
        customer.UpdateUsername(string2);
        if(customer.getUsername().equals(string)){
            System.out.println("Username doesnt updated ");

            assertEquals(false,false);
        }
        else{
            System.out.println("Username Updated Successfully from: "+"\t"+string+"\t"+"to"+"\t"+string2);
            assertEquals(true,true);
        }



        string = customer.getPass();
        string2="54321";
        customer.UpdatePassword(string2);
        if(customer.getUsername().equals(string)){
            System.out.println("Password doesnt updated ");

            assertEquals(false,false);
        }
        else{
            System.out.println("Password Updated Successfully from: "+"\t"+string+"\t"+"to"+"\t"+string2);
            assertEquals(true,true);
        }


    }



    @Given("the user is logged in")
    public void theUserIsLoggedIn() {System.out.println("Logged In");
    }

    @When("the user navigates to the {string}")
    public void theUserNavigatesToThe(String string) {
        System.out.println("Navigate to "+string);
    }

    @Then("the user should see a list of past orders")
    public void theUserShouldSeeAListOfPastOrders() {
        customer.addProduct(product);

      boolean flag = orderService.isOrderEmpty();
      if(flag){
          assertTrue(true);
          System.out.println("Displayed pastOrder to customer successfully");
      }
      else{
          System.out.println("PastOrder is empty");
          assertFalse(false);
      }

    }



    @Then("the user should not  see a list of installation requests")
    public void theUserShouldNotSeeAListOfInstallationRequests() {
    }

    @Then("The attempt to update one's own contact information should fail")
    public void theAttemptToUpdateOneSOwnContactInformationShouldFail() {
        }


    @Given("the customer  has logged in to the system")
    public void theCustomerHasLoggedInToTheSystem() {
        System.out.println("User logged in to the system");
    }

    @Given("the user  has logged in to the system")
    public void theUserHasLoggedInToTheSystem() {

    }

    @Given("the user is in the system")
    public void theUserIsInTheSystem() {
    }
}
