package com.oocl.fs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "BOOKING")
public class Order {

    @Id
    private String id;

    @Column(name = "BOOKING_DATE")
    private Date orderDate;

}
