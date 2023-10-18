package com.adrianbarnard.artistdemo.models;

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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="artists")
public class Artist {
	// Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Timestamp fields
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
        this.updatedAt = new Date(); // Generate the time stamp for updatedAt when adding a new Artist
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    // INCOMPLETE - will complete Wednesday with more annotations and other important pieces
    
    // Is active or not
    private Boolean isActive;
    // Genre
    @Size(min=3, max=255, message="Genre must be 3-255 characters")
    private String genre;
    // Name of artist/group
    @Size(min=1, max=255, message="Name must be 1-255 characters")
    private String name;
    // Description
    @Size(min=10, message="Description must be 10 or more characters")
    private String description;
    // Solo or group?
    private Boolean isSolo;
    // Number of members
    @Min(value=1,message="Must have at least 1 member")
    @Max(value=20,message="Cannot have more than 20 members")
    private Integer memberCount;
}
