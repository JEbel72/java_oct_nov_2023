package com.adrianbarnard.studentclubdemo.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="students")
public class Student {
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
    
    /* Our own attributes */
    @NotEmpty(message="Please enter a name")
    @Size(min=2,message="Name must be 2 or more characters")
    private String name;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthdate;
    
    /* Adding a many-to-many relationship */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name="students_and_clubs",
    		joinColumns=@JoinColumn(name="student_id"),
    		inverseJoinColumns=@JoinColumn(name="club_id")
    )
    private List<Club> enrolledClubs;
    
    public Student() {}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public List<Club> getEnrolledClubs() {
		return enrolledClubs;
	}
	public void setEnrolledClubs(List<Club> enrolledClubs) {
		this.enrolledClubs = enrolledClubs;
	}
    
    
}
