/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

/**
 *
 * @author huy
 */
public class Specification {

    private int specificationId;
    private String specificationKey;
    private String specification;
    private boolean status;
    private String productId;

    public Specification() {
    }

    public Specification(String specificationKey) {
        this.specificationKey = specificationKey;
    }

    public Specification(String specificationKey, String specification) {
        this.specificationKey = specificationKey;
        this.specification = specification;
    }

    public Specification(int specificationId, String specificationKey, String specification, boolean status, String productId) {
        this.specificationId = specificationId;
        this.specificationKey = specificationKey;
        this.specification = specification;
        this.status = status;
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(int specificationId) {
        this.specificationId = specificationId;
    }

    public String getSpecificationKey() {
        return specificationKey;
    }

    public void setSpecificationKey(String specificationKey) {
        this.specificationKey = specificationKey;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
