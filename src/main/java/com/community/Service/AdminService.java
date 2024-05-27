package com.community.Service;

import java.util.List;

import com.community.entity.Admin;

public interface AdminService {
	Admin createAdmin(Admin admin);
	List<Admin> getAllAdmin();

}
