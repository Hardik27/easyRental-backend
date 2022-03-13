package com.example.easyrental.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_OWNER_USER_ID = "ownerUserId";
    public static final String FIELD_BORROWER_USER_ID = "borrowerUserId";
    public static final String FIELD_PRODUCT_ID = "productId";
    public static final String FIELD_STATUS = "status";
    public static final String FIELD_START_TIME = "startTime";
    public static final String FIELD_END_TIME = "endTime";
    public static final String FIELD_TOTAL_PRICE = "total_price";


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long ownerUserId;
    private Long borrowerUserId;
    private Long productId;
    private BookingStatus status;
    private long startTime;
    private long endTime;
    private long total_price;

    public Booking() {
    }

    public Booking(String name, Long ownerUserId, Long borrowerUserId, Long productId, BookingStatus status, long startTime, long endTime, long total_price) {
        this.name = name;
        this.ownerUserId = ownerUserId;
        this.borrowerUserId = borrowerUserId;
        this.productId = productId;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.total_price = total_price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(Long userId) {
        this.ownerUserId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getTotal_price() {
        return total_price;
    }

    public void setTotal_price(long total_price) {
        this.total_price = total_price;
    }

    public Long getBorrowerUserId() {
        return borrowerUserId;
    }

    public void setBorrowerUserId(Long borrowerUserId) {
        this.borrowerUserId = borrowerUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
