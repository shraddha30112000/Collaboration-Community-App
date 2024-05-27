package com.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.Service.AdminService;
import com.community.entity.Admin;
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/add")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
		Admin saveAdmin=this.adminService.createAdmin(admin);
		return new ResponseEntity<Admin>(saveAdmin,HttpStatus.CREATED);
				
	}

}
