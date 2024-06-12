package com.community.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "title is required")
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;
    
    @Future
    @Temporal(TemporalType.DATE)
    private Date FutureDate;
    
 
    private Boolean status;
    
    @NotBlank(message = "Skills are required")
    private String skills;
    
    @Pattern(regexp="(^$|[0-9]{10})", message = "Invalid mobile number")
    private String mobNumber;
    
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "company_id")
    private Company company;
    
//	  @ManyToOne
//	  @JsonBackReference
//	  @JoinColumn(name = "admin_id")
//	  private Admin admin;
	 
	 
	public Post(Long id, @NotBlank(message = "Description is required") String description,
			@NotBlank(message = "title is required") String title,
			@NotNull(message = "Date is required") Date postDate,
			Date FutureDate,
			@NotBlank(message = "Status is required") Boolean status, Company company,String skills) {
		super();
		this.id = id;
		this.description = description;
		this.title = title;
		this.postDate = postDate;
		this.FutureDate = FutureDate;
		this.status = status;
		this.company = company;
		this.skills = skills;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Date getFutureDate() {
		return FutureDate;
	}

	public void setFutureDate(Date futureDate) {
		FutureDate = futureDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
}
