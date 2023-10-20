package com.adrianbarnard.starterfullstackproject.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="trees") // Don't forget these two annotations - the name of the table by convention is usually plural
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key
    
    // Two timestamp columns
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
        this.updatedAt = new Date(); // Generate the timestamp for the updatedAt column when we add for the first time
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    // Add additional columns here!
    
    // Zero-argument constructor (mandatory)
    public Tree() {}
    
    // Add another constructor with the OTHER columns here
    
    // IMPORTANT: Generate (and remove) getters and setters as needed
    public Long getId() {
    	return id;
    }
    public void setId(Long id) {
    	this.id = id;
    }
    public Date getCreatedAt() {
    	return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
    	this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
    	return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
    	this.updatedAt = updatedAt;
    }
    
}
