package com.example.assignment.model;

public class Resource {

    private int id;
    private String name;
    private String type;
    private String description;
    private String contactInfo;
    private String website;
    private String phoneNumber;
    private String email;
    private Category category;

    public Resource() {
    }

    public Resource(int id, String name, String type, String description, String contactInfo, String website, String phoneNumber, String email, Category category) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.contactInfo = contactInfo;
        this.website = website;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
