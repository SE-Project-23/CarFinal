package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Logger;

public class Admin {
public Product p;
    private  String email;
    private  Integer ID;

    private  String name;

    private  String password;

    private ArrayList <Product> product = new ArrayList<>();
    private ArrayList <Customer> customers = new ArrayList<>();

    public ArrayList <String> category = new ArrayList<>();

    public  Admin(Integer ID, String name,String email,String pass){

        this.name=name;
        this.ID=ID;
        this.email=email;
        this.password=pass;
    }

  public ArrayList getCatList(){
        return category;
  }





public   ArrayList getArray(){
        return product;
}

    public  void set_email(String email2) {

        this.email = email2;

    }

    public  void set_id(Integer id) {

        this.ID = id;
    }



    public  void set_name(String name) {

        this.name = name;

    }

    public  void set_password(String password2) {

        password = password2;

    }

    public  String get_username() {

        return name;
    }

    public  String get_email() {

        return email;
    }
    public  Integer get_ID() {

        return ID;
    }


    public ArrayList get_productList() {

        return product;
    }

    public  String get_password() {

        return password;
    }

    public  void addProduct(Product product1) {

      product.add(product1);

    }

    public boolean searchCat(String string) {
        boolean flag =false;
        for(Product product:product){
            if(product.getCategory().equals(string)){
                flag =true;
            }
            else{
                flag =false;
            }
        }
        return flag;
    }


    public void updateCat( String oldCategory ,String newCategory) {
       // String currentCategory = product.getCategory();

        for (int i = 0; i < category.size(); i++) {
            if (category.get(i).equals(oldCategory)) {
                category.set(i, newCategory);
            }
        }


    }

    public boolean searchProduct(String name) {
        boolean flag = false;
        for(Product product1 : product){
            if(product1.getName().equals(name))
                flag = true;

        }
      return flag;
    }

    public void addCustomer (Customer customer){
        customers.add(customer);
    }

    public  boolean searchID(Integer customer_ID){
        boolean flag =false;
        for(Customer customer:customers){
            if(customer.getID() == customer_ID){
                flag =true;
            }
        }
        return flag;
    }
    public String displayAccount(Customer customer) {
        Integer ID = customer.getID();
        boolean flag = searchID(ID);
        if(flag) {
            String s = "Customer ID:" + " " + customer.getID() + "\n" + "Customer username:" + " " + customer.getUsername() + "\n" + "Customer email:" + " " + customer.getEmail();
            return s;
        }
        else {
            return "Customer doesnt exists";
        }
    }
    public void addCat(Product product){

        category.add(product.getCategory());

    }


    public boolean deleteCat(String string) {
        boolean flag = false;
        Iterator<String> iterator = category.iterator();
        while (iterator.hasNext()) {
            String currentCategory = iterator.next();
            if (currentCategory.equals(string)) {
                iterator.remove();
                System.out.println("Category '" + string + "' is deleted");
                flag = true;
                break;  // Exit the loop after deleting the category
            }
        }

        if (!flag) {
            System.out.println("No category found");
        }

        return flag;
    }

        public void updateProductDetails(Product product_old, Integer newPrice, String newImage,Integer avail) {
            if (product.contains(product_old)) {
                if (product_old.checkImage(newImage)) {
                    product_old.setImage(newImage);
                }
                else {
        System.out.println("Wrong type of image");
                }

                if (product_old.checkPrice(newPrice)) {
                    product_old.setPrice(newPrice);
                }
                else {
                    System.out.println("Wrong type of price");

                }


                if (product_old.checkAvail(avail)) {
                    product_old.setAvailability(avail);
                }
                else {
                    System.out.println("Wrong type of availability");

                }

             System.out.println("Product details updated by admin");
            } else {
                System.out.println("Product not found. Update failed.");
            }
        }


   public void scheduleAppointment(Appointment  appointment,Customer customer) {

        customer.app.add(appointment);


    }


    public void cancelApp(int appointmentID,Customer customer) {
        for(Appointment appointment:customer.getApp()){

            if(appointment.getID() == appointmentID){

                appointment.setIsCanceled(true);
                System.out.println("Appointment is canceled");


            }
            else{
                System.out.println("Product doesn't exist.. cant cancel this appointement  ");
            }

        }
    }
}


