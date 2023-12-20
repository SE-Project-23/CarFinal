package org.example;

import java.util.ArrayList;

public class Customer {
    private Integer customerId;

    private boolean accountActive = false;
    private String username;

    // private String Address;

    private String email;
    private String password;

    public ArrayList<Product> products = new ArrayList<>();
    public ArrayList<Appointment> app = new ArrayList<>();


    public Customer(Integer ID, String username, String emailAddress, String password) {
        this.username = username;
        this.email = emailAddress;
        this.password = password;
        this.customerId = ID;
        this.accountActive = true;
    }

    public static void displayByCat(ArrayList<Product> List, String cat) {
        boolean flag = false;
        ArrayList<Product> temp = new ArrayList<>();
        for (Product product : List) {
            if (product.getCategory().equals(cat)) {
                temp.add(product);
                flag = true;
            }

        }

        if (!flag) {
            System.out.println("No products found in the category: " + cat);
        } else {
            System.out.println("Products in the category " + cat + ":");
            for (Product product : temp) {
                System.out.println("Product Name: " + product.getName());
                System.out.println("Product Price: " + product.getPrice());
                System.out.println("Product Description: " + product.getProduct_Description());
                System.out.println("Product Image: " + product.getImages());
            }

        }
    }


    public void UpdateEmail(String string2) {
        this.email = string2;

    }


    public void setUsername(String username) {
        this.username = username;
    }


    public void setEmail(String E) {
        this.email = E;
    }

    public static String getNotificationRecipient() {
        return "You order is successfully updated";
    }


    public String getUsername() {

        return username;
    }
    public  ArrayList<Appointment> getApp() {

        return app;
    }

    public String getEmail() {

        return email;
    }


    public void displayByFilter(ArrayList<Product> products2, Integer int1, Integer int2) {

        for (Product product : products2) {
            if (product.getPrice() >= int1 && product.getPrice() <= int2) {
                System.out.println("Product Name: " + product.getName());
                System.out.println("Price: $" + product.getPrice());
                System.out.println("Availability: " + product.getAvailability());
                System.out.println("Category: " + product.getCategory());
                System.out.println("Images:");
                System.out.println("\t" + product.getImages());
            }
            System.out.println("-------------------------------");
        }
    }

    public void UpdateUsername(String string2) {
        this.username = string2;
    }

    public String getPass() {
        return this.password;
    }
    public Integer getID() {
        return this.customerId;
    }


    public void UpdatePassword(String string2) {
        this.password = string2;
    }

    public void addProduct(Product product) {
        products.add(product);
    }



}









