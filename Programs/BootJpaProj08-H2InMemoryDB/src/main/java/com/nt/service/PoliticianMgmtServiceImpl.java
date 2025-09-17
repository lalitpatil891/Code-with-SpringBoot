//PoliticianMgmtServiceImpl.java
package com.nt.service;

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
	

}
