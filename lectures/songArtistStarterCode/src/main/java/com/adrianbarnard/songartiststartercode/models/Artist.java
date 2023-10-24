package com.adrianbarnard.songartiststartercode.models;

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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    
    /* Additional attributes we added */
    
    // Is active or not
    @NotNull(message="Please select whether this artist or group is active")
    private Boolean isActive;
    // Genre
    @NotBlank(message="Please select a genre")
    @Size(min=3, max=255, message="Genre must be 3-255 characters")
    private String genre;
    // Name of artist/group
    @NotBlank(message="Please enter the artist's or group's name")
    @Size(min=1, max=255, message="Name must be 1-255 characters")
    private String name;
    // Description
    @NotBlank(message="Please enter a description for this artist or group")
    @Size(min=10, message="Description must be 10 or more characters")
    @Column(columnDefinition="TEXT")
    private String description;
    // Solo or group?
    @NotNull(message="Please specify if this is a solo artist or a group")
    private Boolean isSolo;
    // Number of members
    @Min(value=1,message="Must have at least 1 member")
    @Max(value=20,message="Cannot have more than 20 members")
    private Integer memberCount;
    
    // Constructors
    public Artist() {} // Mandatory zero-argument constructor

    public Artist(@NotNull(message = "Please select whether this artist or group is active") Boolean isActive,
			@NotBlank(message = "Please select a genre") @Size(min = 3, max = 255, message = "Genre must be 3-255 characters") String genre,
			@NotBlank(message = "Please enter the artist's or group's name") @Size(min = 1, max = 255, message = "Name must be 1-255 characters") String name,
			@NotBlank(message = "Please enter a description for this artist or group") @Size(min = 10, message = "Description must be 10 or more characters") String description,
			@NotNull(message = "Please specify if this is a solo artist or a group") Boolean isSolo,
			@Min(value = 1, message = "Must have at least 1 member") @Max(value = 20, message = "Cannot have more than 20 members") Integer memberCount) {
		this.isActive = isActive;
		this.genre = genre;
		this.name = name;
		this.description = description;
		this.isSolo = isSolo;
		this.memberCount = memberCount;
	}
    
	// Getters and setters
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
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getIsSolo() {
		return isSolo;
	}
	public void setIsSolo(Boolean isSolo) {
		this.isSolo = isSolo;
	}
	public Integer getMemberCount() {
		return memberCount;
	}
	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}
    
    
}
