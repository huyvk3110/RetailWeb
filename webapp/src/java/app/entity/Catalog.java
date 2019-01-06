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
public class Catalog {
    private String catalogId;
    private String catalogName;
    private String description;
    private long view;
    private int priority;
    private boolean status;
    private String parentId;

    public Catalog() {
    }

    public Catalog(String catalogId, String catalogName, String description, long view, int priority, boolean status, String parentId) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.description = description;
        this.view = view;
        this.priority = priority;
        this.status = status;
        this.parentId = parentId;
    }
    
    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
