package com.example.easyrental.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    public static final String FIELD_ID = "id";
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_USER_ID = "userId";
    public static final String FIELD_PRICE = "price";
    public static final String FIELD_TAGS = "tags";
    public static final String FIELD_IMAGES = "images";
    public static final String FIELD_PRODUCT_METADATA = "productMetaData";
    public static final String FIELD_AVAILABILITY = "availability";


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Long userId;
    private String price;
    @ElementCollection
    private List<String> tags;
    @ElementCollection
    private List<String> images;
    private String productMetaData;
    private boolean availability;

    public Product() {
    }

    public Product(String title, String description, Long userId, String price, List<String> tags, List<String> images, String productMetaData, boolean availability) {
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.price = price;
        this.tags = tags;
        this.images = images;
        this.productMetaData = productMetaData;
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getProductMetaData() {
        return productMetaData;
    }

    public void setProductMetaData(String productMetaData) {
        this.productMetaData = productMetaData;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
