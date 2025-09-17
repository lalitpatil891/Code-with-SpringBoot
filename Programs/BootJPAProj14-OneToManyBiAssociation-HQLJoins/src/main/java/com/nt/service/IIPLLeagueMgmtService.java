package com.nt.service;

import java.util.List;

import com.nt.entity.IPLPlayer;
import com.nt.entity.IPLTeam;

public interface IIPLLeagueMgmtService {
    
    public  List<Object[]>  fetchTeamAndPlayerDataByJoins();    
}
