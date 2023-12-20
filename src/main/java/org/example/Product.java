package org.example;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Product {
    public String category;
    public String Name;
    public Integer availability;
    public Integer price;
    public String Product_Description;
    public String image;
    public boolean IsConfirmed = true;

    public ArrayList<String> Category = new ArrayList();
    public ArrayList<Product> ListProduct = new ArrayList();

    public Product(String name, Integer avail, Integer prices, String product_Descriptions, String image) {
        if (checkAvail(avail))
            this.availability = avail;
        else {
            System.out.println("Wrong entry of availability ");
            IsConfirmed = false;
        }

        if (checkPrice(prices))
            this.price = prices;
        else {
            System.out.println("Wrong entry of price ");
            IsConfirmed = false;

        }
        this.Product_Description = product_Descriptions;
        if (checkImage(image)) {
            this.image = image;

        } else {
            System.out.println("Wrong entry of extension of image ");
            IsConfirmed = false;
        }
        this.Name = name;

    }


    public Product(String name, Integer avail, Integer prices, String product_Descriptions, String image, String cat) {
        this.availability = avail;
        this.category = cat;
        this.Name = name;
        this.price = prices;
        Product_Description = product_Descriptions;
        this.image = image;
        this.IsConfirmed = true;
    }

    public void findBName(String string) {

    }

    public Product() {

        availability = 0;
        price = 0;
        category = "";
        Product_Description = "";
        this.image = "";
        this.IsConfirmed = false;


    }


    public void setCategory(String Cat) {
        category = Cat;
    }

    public void setDescription(String dis) {
        Product_Description = dis;
    }

    public void setAvailability(Integer Availability) {
        availability = Availability;
    }

    public ArrayList getList() {
        return ListProduct;
    }

    public void setPrice(Integer Price) {
        price = Price;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public boolean getConfirmed() {
        return IsConfirmed;
    }

    public boolean ApplyFilter(String string) {
        boolean flag = false;
        Iterator var2 = ListProduct.iterator();

        while (var2.hasNext()) {
            Product product = (Product) var2.next();
            if (product.getCategory().equals(string)) {
                flag = true;
            }
        }

        if (!flag) {
            System.out.println("Category is not exist in the system");
        }

        return flag;
    }

    public void displayByFilter(String string) {
        Iterator var1 = ListProduct.iterator();

        while (var1.hasNext()) {
            Product product = (Product) var1.next();
            if (product.getCategory().equals(string)) {
                PrintStream var10000 = System.out;
                String var10001 = product.getName();
                var10000.println("Name:" + var10001 + "\tPrice:" + product.getPrice() + "\tDescription:" + product.getProduct_Description() + "\t");
                break;
            }
        }

    }

    public boolean isProductSaved(String string) {
        Iterator var1 = ListProduct.iterator();

        Product product;
        do {
            if (!var1.hasNext()) {
                return false;
            }

            product = (Product) var1.next();
        } while (!product.getName().equals(string));

        return true;
    }


    public boolean checkAvail(Integer avail) {
        boolean flag;
        if (avail >= 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }


    public boolean checkImage(String image) {
        boolean flag;
        if (image.endsWith(".jpg")) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean checkPrice(Integer price) {
        boolean flag;
        if (price >= 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }


    public String getName() {
        return Name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Integer getAvailability() {
        return availability;
    }

    public String getProduct_Description() {
        return Product_Description;
    }

    public String getImages() {
        return image;
    }


}
