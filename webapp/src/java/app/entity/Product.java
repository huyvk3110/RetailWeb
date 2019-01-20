/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author huy
 */
public class Product {
    private String productId;
    private String productName;
    private float priceOutput;
    private int discount;
    private int quantity;
    private int quality;
    private String title;
    private int guarantee;
    private int oneSwitchOne;
    private String description;
    private long view;
    private long sold;
    private Date created;
    private boolean status = true;
    private String catalogId;
    private String catalogName;
    private List<Specification> specification;

    public Product() {
    }

    public Product(String productId, String productName, float priceOutput, int discount, int quantity, int quality, String title, int guarantee, int oneSwitchOne, String description, long view, long sold, Date created, String catalogId, String catalogName, List<Specification> specification) {
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
        this.catalogName = catalogName;
        this.specification = specification;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }
    
    

    public List<Specification> getSpecification() {
        return specification;
    }

    public void setSpecification(List<Specification> specification) {
        this.specification = specification;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
}
