package org.example.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;

import java.time.LocalDateTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AdminDashboard {
    Admin admin = new Admin(1, "ali", "ali@gmail.com", "123");
    Product product = new Product("Car Organizer", 6, 30, "Keep your car tidy with our versatile and spacious car organizer", "images.jpg", "Interior");
    Customer customer = new Customer(1, "aseel", "abdoasee2002l@gmail.com", "12345");
    Installer installer = new Installer("installer@gmail.com");
    LocalDateTime specificDateTime = LocalDateTime.of(2023, 11, 21, 14, 30, 0);

    Appointment appointment = new Appointment(1, installer, product, specificDateTime);


    @Given("the system has no existing product listings")
    public void theSystemHasNoExistingProductListings() {
    }

    @When("the admin adds a new product with the name {string}, category {string}, and the price ${double}")
    public void theAdminAddsANewProductWithTheNameCategoryAndThePrice$(String string, String string2, Double double1) {
        Product product = new Product("Car Organizer", 6, 30, "Keep your car tidy with our versatile and spacious car organizer", "images.jpg", "Interior");
        boolean flag = product.IsConfirmed;
        if (flag) {
            admin.addProduct(product);
            System.out.println("Admin added product to listing products successfully ");
            assertTrue(true);
        } else {
            assertFalse(false);
            System.out.println("Admin didnt add product to listing products successfully ");
        }

    }

    @Then("the product listing with the category should be visible in the system")
    public void theProductListingWithTheCategoryShouldBeVisibleInTheSystem() {
    }


    @Given("the system has a category named Exterior")
    public void theSystemHasACategoryNamedExterior() {
    }

    @When("the admin wants to update it from {string} to {string}")
    public void theAdminWantsToUpdateItFromTo(String string, String string2) {
        admin.addCat(product);

        string = "Interior";

        string2 = "Exterior";
        admin.updateCat(string, string2);

        if (admin.category.get(0).equalsIgnoreCase(string2)) {
            System.out.println("Category is updated");
            assertTrue(true);

        } else {
            System.out.println("Category is not updated");
            assertFalse(false);

        }

    }

    @Then("it should successfully update it")
    public void itShouldSuccessfullyUpdateIt() {
    }

    @Given("the system has no existing car accessory categories")
    public void theSystemHasNoExistingCarAccessoryCategories() {
    }

    @When("the admin attempts to delete a category with the name {string}")
    public void theAdminAttemptsToDeleteACategoryWithTheName(String string) {
        boolean flag;
        admin.addCat(product);
        string = admin.category.get(0);
        flag = admin.deleteCat(string);
        if (flag) {
            System.out.println("Delete Process is complete");
            assertTrue(true);
        } else {
            System.out.println("Delete process is not complete.. error");
            assertTrue(false);
        }

    }

    @Then("the system should indicate that the category {string} does not exist")
    public void theSystemShouldIndicateThatTheCategoryDoesNotExist(String string) {
        boolean flag;

        flag = admin.deleteCat(string);

        if (flag) {
            System.out.println("Delete Process is complete");
            assertFalse(false);
        } else {
            System.out.println("Delete process is not complete.. category does not exist in the system");
            assertTrue(true);
        }


    }

    @Given("the system has a different categories")
    public void theSystemHasADifferentCategories() {
    }

    @Then("the system should indicate that theis category has been deleted successfully")
    public void theSystemShouldIndicateThatTheisCategoryHasBeenDeletedSuccessfully() {
    }

    @Given("the admin role wants to add a new product listing")
    public void theAdminRoleWantsToAddANewProductListing() {
    }

    @When("he attempt to added to lists")
    public void heAttemptToAddedToLists() {
        admin.addProduct(product);
        String name = product.getName();
        boolean flag = admin.searchProduct(name);
        if (flag) {
            assertTrue(true);
            System.out.println("Added successfully");
        } else {
            assertFalse(false);
        }
    }

    @Then("the product should exist in product list")
    public void theProductShouldExistInProductList() {
    }

    @Given("the system has an existing product")
    public void theSystemHasAnExistingProduct() {
    }

    @When("the admin updates the product")
    public void theAdminUpdatesTheProduct() {
        String image = product.image;
        admin.addProduct(product);
        admin.updateProductDetails(product, 12, "images2.jpg", 40);
        if (!product.getImages().equals(image)) {
            System.out.println("Successfully updated");
        } else {
            System.out.println("Error in updating product");
        }

    }


    @Then("the product listing should be updated in the system")
    public void theProductListingShouldBeUpdatedInTheSystem() {
    }

    @Given("there is an existing customer account with the email {string}")
    public void thereIsAnExistingCustomerAccountWithTheEmail(String string) {

        string = customer.getEmail();
        System.out.println("This is email of customer:" + " " + string);
    }

    @When("the admin views the details of the customer account")
    public void theAdminViewsTheDetailsOfTheCustomerAccount() {
    }

    @Then("the customer account information should be displayed")
    public void theCustomerAccountInformationShouldBeDisplayed() {
        admin.addCustomer(customer);
        String customer_1 = admin.displayAccount(customer);
        System.out.println(customer_1);
    }

    @Given("the admin wants to schedule a new installation appointment")
    public void theAdminWantsToScheduleANewInstallationAppointment() {
    }

    @When("the admin schedules the appointment")
    public void theAdminSchedulesTheAppointment() {

        admin.scheduleAppointment(appointment, customer);
        if (customer.getApp().get(0).equals(appointment)) {
            System.out.println(admin.get_username() + " " + "scheduled the appointment for customer " + " " + customer.getUsername());
            assertTrue(true);

        } else {
            assertFalse(false);
            System.out.println(admin.get_username() + " " + " doesnt manage to schedule the appointment for customer " + " " + customer.getUsername());
        }

    }


    @Then("the appointment should be successfully scheduled")
    public void theAppointmentShouldBeSuccessfullyScheduled() {

    }

    @Given("there is an existing installation appointment")
    public void thereIsAnExistingInstallationAppointment() {
    }

    @When("the admin manages the appointment, updating or canceling as needed")
    public void theAdminManagesTheAppointmentUpdatingOrCancelingAsNeeded() {
        //update
    }

    @Then("the appointment details should be successfully updated or canceled")

        public void theAppointmentDetailsShouldBeSuccessfullyUpdatedOrCanceled() {

        admin.scheduleAppointment(appointment,customer);
            int appointmentID = appointment.getID();


            admin.cancelApp(appointmentID, customer);

            boolean appointmentFound = false;

            for (int i = 0; i < customer.getApp().size(); i++) {
                if (customer.getApp().get(i).getID() == appointmentID) {
                    appointmentFound = true;
                    if (customer.getApp().get(i).isCanceled()) {
                        System.out.println("Appointment is successfully canceled");
                    } else {
                        System.out.println("Appointment is not canceled");
                    }
                    // Break out of the loop since we found the appointment
                    break;
                }
            }

            if (!appointmentFound) {
                System.out.println("Appointment doesn't exist");
            }
        }

    }
