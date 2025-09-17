package com.nt.service;

import java.util.List;

import com.nt.entity.Actor;

public interface IActorMgmtService {
   public String    removeActorsByIdsInBatch(List<Integer> ids);
   public   List<Actor>   showActorsByData(Actor actor,boolean ascOrder, String ...props);
   public   Actor    showActorById(int id);
   public    Actor    fetchActorById(int id);
}
