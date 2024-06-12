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
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	// Add new Company
	@PostMapping("/add")
	public ResponseEntity<Company> createCompany(@Valid @RequestBody Company company) {
		Company saveCompany = companyService.createCompnay(company);
		return new ResponseEntity<>(saveCompany, HttpStatus.CREATED);
	}

	// Get All Companies
	@GetMapping
	public List<Company> getAllCompanies() {
		return companyService.getAllCompanies();
	}

	// Get Company By Id
	@GetMapping("/{id}")
	public Company getCompanyById(@Valid @PathVariable Long id) {
		return companyService.getCompanyById(id);
	}

	// update company
	@PutMapping("/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable Long id, @Valid @RequestBody Company company) {
		Company updatedCompany = this.companyService.updateCompany(id, company);
		return ResponseEntity.ok(updatedCompany);
	}

	// Delete the single company by id
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteCompany(@PathVariable Long id) {
		this.companyService.deleteCompany(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Employee deleted Successfully", true), HttpStatus.OK);
	}

	// Delete Company by name
	@DeleteMapping("/deleteByName/{name}")
	public ResponseEntity<String> deleteCompanyByName(@PathVariable String name) {
        companyService.deleteCompanyByName(name);
        String response = "Company with Name " + name + " deleted successfully";
        return ResponseEntity.ok(response);
    }

	// search company by letter
	@GetMapping("/search/{letter}")
	public ResponseEntity<List<Company>> searchCompanyByFirstLetter(@PathVariable String letter) {
		List<Company> companies = companyService.serchCompanyByFirstLetter(letter);
		if (companies.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(companies, HttpStatus.OK);
	}

	// get company by name
	@GetMapping("/getByName/{name}")
	public ResponseEntity<List<Company>> getCompanyByName(@PathVariable String name) {
		List<Company> companies = companyService.getCompanyByName(name);
		if (companies.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(companies, HttpStatus.OK);
	}
	
}