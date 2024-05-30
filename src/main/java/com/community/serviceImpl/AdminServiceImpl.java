package com.community.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.Repository.AdminRepository;
import com.community.Service.AdminService;
import com.community.entity.Admin;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin createAdmin(Admin admin) {
		admin.setRegisterDate(new Date());
		admin.hashPassword();
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
		
	}

}
