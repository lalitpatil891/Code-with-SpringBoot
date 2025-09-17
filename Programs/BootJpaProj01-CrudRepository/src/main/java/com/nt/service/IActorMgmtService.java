package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Actor;

public interface IActorMgmtService {
   public String  registerActor(Actor  actor);
   public  long   showActorsCount();
   public  String   registerActors(List<Actor> list);
   public   String  isActorExistById(int id);
   public   Iterable<Actor>  showAllActors();
   public  Iterable<Actor>  showActorsByIds(Iterable<Integer> ids);
   public   Optional<Actor>  showActorById(int id);
   public   Actor  findActorById(int id);
   public   Actor   fetchActorById(int id);
   public   String    updateActorFee(int aid , float hikePercent);
   public   String    registerOrUpdateActor(Actor actor);
   public  String   removeActorById(int aid);
   public   String   removeActor(Actor actor);
   public   String  removeActorsByIds(List<Integer> ids);
   public   String   removeAllActors();
   
   
   
   
   
}
