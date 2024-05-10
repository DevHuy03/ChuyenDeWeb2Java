package com.macquochuy.exercise02.request;
import com.macquochuy.exercise02.Entity.User;
public class AddressRequest {
    // Các trường khác...

    private String fullAddress;
    private String postalCode;
    private String city;

    // Constructors, getters và setters cho các trường khác...

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
