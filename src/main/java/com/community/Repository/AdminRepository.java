package com.community.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.community.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long> {

}
