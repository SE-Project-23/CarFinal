package org.example;

import java.util.ArrayList;

public class Order {
    private int orderId;
    private Customer customer;
    private ArrayList<Product> products;

    private double totalAmount;
    private String status;


    public Order(int orderId, Customer customer, ArrayList<Product> products) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = products;

        this.calculateTotalAmount();
        this.status = "confirmed";
    }


    private void calculateTotalAmount() {
        this.totalAmount = products.stream().mapToDouble(Product::getPrice).sum();
    }


    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }


    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;

    }

    public void updateOrder(Customer newCustomer, ArrayList<Product> newProducts) {

        if (newCustomer != null) {
            this.customer = newCustomer;
        }

        if (newProducts != null && !newProducts.isEmpty()) {
            this.products = newProducts;
            this.calculateTotalAmount();
        }
    }
}