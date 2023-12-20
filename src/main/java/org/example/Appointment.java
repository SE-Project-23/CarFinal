package org.example;

import java.time.LocalDateTime;

public class Appointment {
    private int appointmentId;
    private Customer customer;
    private Installer installer;
    private Product product;
    private LocalDateTime scheduledTime;
    private boolean isCanceled;

    public Integer getID(){
        return appointmentId;
    }

    public boolean isCanceled(){
        return isCanceled;
    }
public void setIsCanceled(boolean isCanceled){
        this.isCanceled = isCanceled;
}

    public Appointment(int appointmentId, Installer installer, Product product, LocalDateTime scheduledTime) {
        this.appointmentId = appointmentId;
//        this.customer = customer;
        this.installer = installer;
        this.product = product;
        this.scheduledTime = scheduledTime;
        this.isCanceled = false;
    }










}
