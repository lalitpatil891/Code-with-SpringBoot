package com.nt.service;

import java.util.List;

import com.nt.entity.Politician;

public interface IPoliticianMgmtService {
  public  String  registerPolitician(Politician  pltcn);
  public   Politician  showPoliticianById(int id);
  public  Iterable<Politician> showAllPoliticians();
  public  String   getPoliticianAgeById(int id);
  public List<Object[]> showAllPoliticiansNameAgeDetails();
  
}
