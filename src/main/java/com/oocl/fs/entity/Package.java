package com.oocl.fs.entity;

import javax.persistence.*;

@Entity
public class Package {

    @Id
    private String packageNumber;
    private String receiver;
    private String receiverContact;
    private String status;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PACKAGE_NUMBER")
    private Order order;

    public String getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(String packageNumber) {
        this.packageNumber = packageNumber;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiverContact() {
        return receiverContact;
    }

    public void setReceiverContact(String receiverContact) {
        this.receiverContact = receiverContact;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
