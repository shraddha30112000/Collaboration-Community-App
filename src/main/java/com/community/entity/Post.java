package com.community.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "State is required")
    private String state;

    @NotNull(message = "Date is required")
    private Date date;
    
    @NotNull(message = "Future Date is required")
    @Future
    private Date FutureDate;
    
    @NotBlank(message = "Status is required")
    private String status;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "company_id")
    private Company company;

	public Post(Long id, @NotBlank(message = "Description is required") String description,
			@NotBlank(message = "State is required") String state,
			@NotNull(message = "Date is required") Date date,
			Date FutureDate,
			@NotBlank(message = "Status is required") String status, Company company) {
		super();
		this.id = id;
		this.description = description;
		this.state = state;
		this.date = date;
		this.FutureDate = FutureDate;
		this.status = status;
		this.company = company;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getFutureDate() {
		return FutureDate;
	}

	public void setFutureDate(Date futureDate) {
		FutureDate = futureDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
