package com.nt.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.IPLPlayer;
import com.nt.entity.IPLTeam;
import com.nt.repository.IIPLPlayerRepository;
import com.nt.repository.IIPLTeamRepository;

@Service
public class IPLLeagueMgmtSErviceImpl implements IIPLLeagueMgmtService {
	@Autowired
	private  IIPLTeamRepository  teamRepo;
	@Autowired
	private  IIPLPlayerRepository  playerRepo;
	
	@Override
	public List<Object[]> fetchTeamAndPlayerDataByJoins() {
		return teamRepo.showTeamAndPlayersDataUsingJoins();
	}

	
}
