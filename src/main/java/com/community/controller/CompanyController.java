package com.community.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.Service.CompanyService;
import com.community.entity.ApiResponse;
import com.community.entity.Company;
import com.community.exception.ResourceNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	//Add new Company
	@PostMapping("/add")
	public ResponseEntity<Company> createCompany(@Valid@RequestBody Company company)
	{
		Company saveCompany=companyService.createCompnay(company);
		return new ResponseEntity<>(saveCompany,HttpStatus.CREATED);
	}
	
	//Get All Companies
	@GetMapping
	public List<Company> getAllCompanies()
	{
		return companyService.getAllCompanies();
	}
	
	//Get Company By Id
	@GetMapping("/{id}") 
	public Company getCompanyById(@Valid@PathVariable Long id) 
	{
		return companyService.getCompanyById(id); 
	}
	
	//update company
	@PutMapping("/{id}") 
	public Company updateCompany(@Valid@PathVariable Long id, @RequestBody Company updatedCompany) { return
			  companyService.updateCompany(id, updatedCompany); 
	}
	
	// Delete the single company by id
		@DeleteMapping("/{id}")
		public ResponseEntity<ApiResponse>deleteCompany(@PathVariable Long id)
		{
			this.companyService.deleteCompany(id);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Employee deleted Successfully", true),HttpStatus.OK);
			
		}
}