/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.util.Date;

/**
 *
 * @author huy
 */
public class Product {
    String productId;
    String productName;
    float priceOutput;
    int discount;
    int quantity;
    int quality;
    String title;
    int guarantee;
    int oneSwitchOne;
    String description;
    long view;
    long sold;
    Date created;
    String catalogId;

    public Product() {
    }

    public Product(String productId, String productName, float priceOutput, int discount, int quantity, int quality, String title, int guarantee, int oneSwitchOne, String description, long view, long sold, Date created, String catalogId) {
        this.productId = productId;
        this.productName = productName;
        this.priceOutput = priceOutput;
        this.discount = discount;
        this.quantity = quantity;
        this.quality = quality;
        this.title = title;
        this.guarantee = guarantee;
        this.oneSwitchOne = oneSwitchOne;
        this.description = description;
        this.view = view;
        this.sold = sold;
        this.created = created;
        this.catalogId = catalogId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPriceOutput() {
        return priceOutput;
    }

    public void setPriceOutput(float priceOutput) {
        this.priceOutput = priceOutput;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    public int getOneSwitchOne() {
        return oneSwitchOne;
    }

    public void setOneSwitchOne(int oneSwitchOne) {
        this.oneSwitchOne = oneSwitchOne;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getView() {
        return view;
    }

    public void setView(long view) {
        this.view = view;
    }

    public long getSold() {
        return sold;
    }

    public void setSold(long sold) {
        this.sold = sold;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

            
}
