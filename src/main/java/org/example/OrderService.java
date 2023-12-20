package org.example;

import io.cucumber.java.it.Date;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Properties;

public class OrderService {


    private ArrayList<Order> orders=new ArrayList<>();

public boolean isOrderEmpty(){

    boolean flag;
    if(orders.isEmpty()){
        flag = true;
    }
    else {
        flag = false;
    }
    return flag;
}
    public ArrayList<Order> getPastOrdersForCustomer(Customer customer) {
        ArrayList<Order> pastOrders = new ArrayList<>();
        boolean flag = isOrderEmpty();
        if(flag) {
            for (Order order : orders) {
                if (order.getCustomer().equals(customer) && order.getStatus().equals("confirmed")) {
                    pastOrders.add(order);
                }
            }
        }


        return pastOrders;
    }
public void sendMessage(String status,String email){

    String from = "abdoaseel2002@gmail.com";
    String to = email;
    try {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator(){
            @Override
            protected  PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("abdoaseel2002@gmail.com","zmtjtexsmsfqllnu");
            }
        });
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to,false));
        message.setSubject("Order Status");
        // Now set the actual message
        message.setText("Your Order Status is : \n "+status);

        System.out.println("sending...");
        // Send message
        Transport.send(message);
        System.out.println("Sent message successfully....");
    }
    catch (MessagingException m){
        m.printStackTrace();
    }

}






}

