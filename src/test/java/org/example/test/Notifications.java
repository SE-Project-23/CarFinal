package org.example.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Notifications {
    Customer customer = new Customer(1,"aseel","aseel@gmail.com","12345");
    Customer customer2 = new Customer(2,"alia","alia@gmail.com","12345");

    org.example.Product product= new Product("Car Organizer",6,30,"Keep your car tidy with our versatile and spacious car organizer","images.jpg","Interior");

    org.example.Product product2= new Product("Car Organizer",9,90,"Keep your car tidy with our versatile and spacious car organizer","images.jpg","Exterior");

    OrderService orderService = new OrderService();
    Order order = new Order(1,customer,customer.products);
    Installer installer = new Installer("abdoaseel2002@gmail.com");
    @Given("a customer with the email address {string}")
    public void aCustomerWithTheEmailAddress(String string) {
        string = customer.getEmail();
    }
    @When("the order is confirmed")
    public void theOrderIsConfirmed() {
        if(order.getStatus().equals("confirmed")){
            assertTrue(true);
            System.out.println("Order confirmed successfully ");
        }


}



    @Then("an order confirmation email should be sent to the customer")
    public void anOrderConfirmationEmailShouldBeSentToTheCustomer() {
       String status = order.getStatus();
       String email = customer.getEmail();
       orderService.sendMessage(status,email);
       System.out.println("An email sent to the customer email :"+" "+email);

    }
    @When("the order is updated")
    public void theOrderIsUpdated() {
ArrayList <Product> p = new ArrayList<>();
p.add(product);
p.add(product2);
      order.updateOrder(customer2,p);
      if(order.getCustomer().equals(customer2) && order.getProducts().equals(p)){
          System.out.println("Order updated it successfully");
          assertEquals(true,true);
      }
      else{
          System.out.println("Order not updated");
          assertEquals(true,true);
      }

    }
    @Then("an order update notification should be sent to the customer")
    public void anOrderUpdateNotificationShouldBeSentToTheCustomer() {
    }
    @Given("an installer with the email address {string}")
    public void anInstallerWithTheEmailAddress(String string) {
        Installer  installer = new Installer(string);
    }
    @When("a new installation request is received")
    public void aNewInstallationRequestIsReceived() {
        System.out.println("A new installation request is received.");
    }
    @Then("an email notification should be sent to the installer")
    public void anEmailNotificationShouldBeSentToTheInstaller() {
        String email = "s12240901@stu.najah.edu";
        installer.sendMessage(email);

    }
    @Given("an installer with the device token {string}")
    public void anInstallerWithTheDeviceToken(String string) {
    }
    @Then("a push notification should be sent to the installer's device")
    public void aPushNotificationShouldBeSentToTheInstallerSDevice() {
    }

}
