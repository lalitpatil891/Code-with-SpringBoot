//PoliticianMgmtServiceImpl.java
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Politician;
import com.nt.repository.IPoliticianRepository;

@Service
public class PoliticianMgmtServiceImpl implements IPoliticianMgmtService {
	@Autowired
	private IPoliticianRepository  politicianRepo;

	@Override
	public String registerPolitician(Politician politician) {
	   int idVal=politicianRepo.save(politician).getPid();
		return  "Policitian  is registered with Party  with the id  value ::"+idVal;
	}
	
	public    Politician  showPoliticianById(int id) {
		return  politicianRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid id"));
	}

	@Override
	public Iterable<Politician> showAllPoliticians() {
		return politicianRepo.findAll();
	}

	@Override
	public String getPoliticianAgeById(int id) {
		//use repo
		boolean flag=politicianRepo.existsById(id);
		if(flag) {
			float age=politicianRepo.fetchPoliticianAgeById(id);
			return  id+" Politician age is ::"+age;
		}
		return id+" Politician not found";
			
		
	}
	
	@Override
	public List<Object[]> showAllPoliticiansNameAgeDetails() {
		//use repo
		return politicianRepo.fetchPolicianNameAgeDetails();
	}
	

}
