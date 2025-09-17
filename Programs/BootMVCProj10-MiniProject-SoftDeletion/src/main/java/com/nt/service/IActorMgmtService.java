package com.nt.service;

import java.util.List;

import com.nt.vo.ActorVO;

public interface IActorMgmtService {
    public  List<ActorVO>   showAllActors();
    public  String  registerActor(ActorVO vo);
    public   ActorVO    showActorById(int id);
    public   String   updateActor(ActorVO vo);
    public   String   deleteActor(int id);
    
}
