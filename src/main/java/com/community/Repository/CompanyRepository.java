package com.community.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.community.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
