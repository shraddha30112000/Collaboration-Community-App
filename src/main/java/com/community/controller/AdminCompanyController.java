package com.community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.Service.CompanyService;
import com.community.entity.ApiResponse;
import com.community.entity.Company;

@RestController
@RequestMapping("/api/admin")
public class AdminCompanyController {

	@Autowired
	private CompanyService companyService;

	// Get All Companies
	@GetMapping
	public List<Company> getAllCompanies() {
		return companyService.getAllCompanies();
	}

	// Delete the single company by id
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteCompany(@PathVariable Long id) {
		this.companyService.deleteCompany(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Employee deleted Successfully", true), HttpStatus.OK);
	}

}
