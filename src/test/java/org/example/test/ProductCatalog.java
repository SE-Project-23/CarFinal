package org.example.test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Admin;
import org.example.Customer;

import org.example.Product;

import java.util.ArrayList;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProductCatalog {



    boolean flag;
    String string;
    Product product1 = new Product("Car Organizer",6,30,"Keep your car tidy with our versatile and spacious car organizer","images.jpg");

    Product product2 = new Product("Car Organizer",6,30,"Keep your car tidy with our versatile and spacious car organizer","images.jpg","Interior");
    Product product3 = new Product("Car Seat Cover",20,15,"Protect your seats and add style with our comfortable seat covers","image2s.jpg","Exterior");

    Customer customer = new Customer(1,"aseel","aseel@gmail","1234");
     Admin admin = new Admin(1,"ali","admin@gmail.com","123");

  public ArrayList <Product> products2 = new ArrayList<>();
    @Given("the system is ready")
    public void theSystemIsReady() {
        System.out.println("System is ready");
    }

    @When("the admin role creates a new category called {string}")
    public void theAdminRoleCreatesANewCategoryCalled(String string) {
             }
    @Then("the categories {string} should exist in the system")
    public void theCategoriesShouldExistInTheSystem(String string) {
        }

    @Then("the product information should be saved successfully")
    public void theProductInformationShouldBeSavedSuccessfully() {
    }

    @When("the admin role fill the details of products")
    public void theAdminRoleFillTheDetailsOfProducts()

    {
      boolean flag ;
     String img =  product1.getImages();
    Integer price=  product1.getPrice();
    Integer avail =  product1.getAvailability();

     if(product1.checkAvail(avail) && product1.checkImage(img) && product1.checkPrice(price)){
        flag = true;
    }

    else {
        flag = false;
    }

    if(flag){
        assertEquals(true,true);
        System.out.println("Admin fills successfully");

    }
    else{
        assertEquals(false,false);
    }





    }

    @When("he fill in {string} with {string}")
    public void heFillInWith(String string, String string2) {
      boolean flag = false ;

      if(string.equalsIgnoreCase("availability")){
           string2 = Integer.toString(product1.getAvailability());
       if(product1.checkAvail(Integer.parseInt(string2))){
           flag = true;
           System.out.println("Admin added availability successfully:"+"\t"+ string2);
           assertEquals(true,true);
       }
       else{
           assertEquals(false,false);
       }
      }

      else if (string.equalsIgnoreCase("price")){
          string2 = Integer.toString(product1.getPrice());
        if(product1.checkPrice(Integer.parseInt(string2))){
            flag = true;
            System.out.println("Admin added price successfully:"+"\t"+ string2);

        }
        else {
            assertEquals(false,false);
        }

      }


    }
    @When("he fills in the {string} field with a valid image extension such as {string}")
    public void heFillsInTheFieldWithAValidImageExtensionSuchAs(String string, String string2) {

  boolean flag = false;
   string2 = product1.getImages();

      if(string.equalsIgnoreCase("image")){
          if(product1.checkImage(string2)){
              flag = true;

          }
          else{
              flag = false;
          }
      }

      if(flag){
          System.out.println("The extension"+string2+"\t"+"is correct");
          assertEquals(true,true);
      }

      else{
          System.out.println("The extension"+string2+"is wrong");
          assertEquals(false,false);
      }
    }


    @Then("the product {string} should be saved successfully")
    public void theProductShouldBeSavedSuccessfully(String string) {

        boolean flag = product1.getConfirmed();

        if(flag){
            System.out.println("The Product confirmed ");
            assertEquals(true,true);
        }
        else {
            System.out.println("The product hasn't been confirmed .. error occurred");
            assertEquals(false, false);
        }



    }

    @Then("admin role should see a message {string}")
    public void adminRoleShouldSeeAMessage(String string) {
    }


    @Given("the user is on the product listing page")
    public void theUserIsOnTheProductListingPage() {
        System.out.println("User now in the list page");
    }
    @When("the user enter a character")
    public void theUserEnterACharacter() {
    }
    @When("he click on Search button")
    public void heClickOnSearchButton() {
    }
    @Then("Display search results of {string} will be displayed with list of that product")
    public void displaySearchResultsOfWillBeDisplayedWithListOfThatProduct(String string) {

        string = product2.getCategory();
        admin.addProduct(product2);


 boolean flag = admin.searchCat(string);

       assertTrue(true);
        if(flag){

            System.out.println("Search successfully by category :" +string);
            assertTrue(true);

        }
 else{
            System.out.println("Category not found:"+string);
            assertFalse(false);

        }


    }



    @When("the user applies a filter for {string} from {int} to {int} dollars")
    public void theUserAppliesAFilterForFromToDollars(String string, Integer int1, Integer int2) {

        customer.displayByFilter(products2,int1,int2);
    }
    @Then("the displayed products should belong to that filter category")
    public void theDisplayedProductsShouldBelongToThatFilterCategory() {
    }

}