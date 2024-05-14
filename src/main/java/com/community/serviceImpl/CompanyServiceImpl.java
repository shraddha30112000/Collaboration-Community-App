package com.community.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.community.Repository.CompanyRepository;
import com.community.Service.CompanyService;
import com.community.entity.Company;
import com.community.exception.ResourceNotFoundException;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public Company createCompnay(Company company) {
		company.setDate(new Date());
		company.hashPasswaord();
		return companyRepository.save(company);
	}

	@Override
	public List<Company> getAllCompanies() {
		List<Company> company = this.companyRepository.findAll();
		return company;
		
	}

	@Override
	public Company getCompanyById(Long id) {
		return companyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Company", "CompnayId", id));
	}

	@Override
	public Company updateCompany(Long id, Company updatedCompany) {
		Company company=this.companyRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Company", "CompnayId", id));
		 updatedCompany.setId(id); 
		 updatedCompany.setName(company.getName());
		 updatedCompany.setDomain(company.getDomain());
		 updatedCompany.setEmail(company.getEmail());
		 updatedCompany.setMobNumber(company.getMobNumber());
		 updatedCompany.setPassword(company.getPassword());
		 updatedCompany.setImage(company.getImage());
		 return this.companyRepository.save(updatedCompany);
		 //return companyRepository.save(updatedCompany);
		 
	}

	@Override
	public void deleteCompany(Long id) {
		Company deleteCompany=this.companyRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Company", "companyId", id));
		this.companyRepository.delete(deleteCompany);
		
	}
	
	
	
}