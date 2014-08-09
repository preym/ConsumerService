package com.example.model;

/**
 * Created with IntelliJ IDEA.
 * User: ehc
 * Date: 9/8/14
 * Time: 2:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Vendor {
    public String vendorName;
    public String vendorMobile;
    public String vendorLocation;
    public String vendorLat;
    public String vendorLong;
    public String[] vendorProducts;


    public Vendor(String name, String mobile, String location, String lat, String lng, String[] products) {
        vendorName = name;
        vendorMobile = mobile;
        vendorLocation = location;
        vendorLat = lat;
        vendorLong = lng;
        vendorProducts = products;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorMobile() {
        return vendorMobile;
    }

    public void setVendorMobile(String vendorMobile) {
        this.vendorMobile = vendorMobile;
    }

    public String getVendorLocation() {
        return vendorLocation;
    }

    public void setVendorLocation(String vendorLocation) {
        this.vendorLocation = vendorLocation;
    }

    public String getVendorLat() {
        return vendorLat;
    }

    public void setVendorLat(String vendorLat) {
        this.vendorLat = vendorLat;
    }

    public String getVendorLong() {
        return vendorLong;
    }

    public void setVendorLong(String vendorLong) {
        this.vendorLong = vendorLong;
    }

    public String[] getVendorProducts() {
        return vendorProducts;
    }

    public void setVendorProducts(String[] vendorProducts) {
        this.vendorProducts = vendorProducts;
    }
}
