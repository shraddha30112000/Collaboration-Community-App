package com.community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.Service.AdminService;
import com.community.entity.Admin;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin, HttpServletRequest request) {

		// System.out.println("Content-Type: " + request.getContentType());
		Admin saveAdmin = this.adminService.createAdmin(admin);
		return new ResponseEntity<Admin>(saveAdmin, HttpStatus.CREATED);

	}

	@GetMapping("/getAll")
	public List<Admin> getAll() {
		return adminService.getAllAdmin();
	}
	
	@GetMapping("/{id}")
	public Admin getAdminById(@Valid @PathVariable Long id) {
		return adminService.getAdminById(id);
	}

}
