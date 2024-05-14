package com.community.Service;

import java.util.List;
import com.community.entity.Company;

public interface CompanyService {
	Company createCompnay(Company company);
	List<Company> getAllCompanies();
	Company getCompanyById(Long id);
	Company updateCompany(Long id, Company updatedCompany);
	void deleteCompany(Long id);
}
