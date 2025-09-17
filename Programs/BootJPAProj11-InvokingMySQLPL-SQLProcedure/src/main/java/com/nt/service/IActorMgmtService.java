package com.nt.service;

import java.util.List;

import com.nt.entity.Actor;

public interface IActorMgmtService {
     public List<Actor>  showActorsByCategories(String cat1,String cat2,String cat3);
}
