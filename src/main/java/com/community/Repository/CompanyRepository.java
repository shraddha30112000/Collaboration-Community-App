package com.community.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.community.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByName(String companyName);
    List<Company> findByNameStartingWith(String letter);
}
