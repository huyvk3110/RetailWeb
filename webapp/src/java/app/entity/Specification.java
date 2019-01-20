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
    private String specificationId;
    private String specificationKey;
    private String specification;
    private String status;

    public Specification() {
    }

    public Specification(String specificationId, String specificationKey, String specification, String status) {
        this.specificationId = specificationId;
        this.specificationKey = specificationKey;
        this.specification = specification;
        this.status = status;
    }

    public String getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(String specificationId) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
