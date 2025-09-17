package com.nt.runners;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.nt.BootJpaProj13OneToManyBiAssociationApp;
import com.nt.entity.IPLPlayer;
import com.nt.entity.IPLTeam;
import com.nt.service.IIPLLeagueMgmtService;

@Component
public class HQLJoinsTestRunner2 implements CommandLineRunner {

    private final BootJpaProj13OneToManyBiAssociationApp bootJpaProj13OneToManyBiAssociationApp;
	@Autowired
	private  IIPLLeagueMgmtService  leagueService;

    HQLJoinsTestRunner2(BootJpaProj13OneToManyBiAssociationApp bootJpaProj13OneToManyBiAssociationApp) {
        this.bootJpaProj13OneToManyBiAssociationApp = bootJpaProj13OneToManyBiAssociationApp;
    }

	@Override
	public void run(String... args) throws Exception {
		
		try {
			List<Object[]>  list=leagueService.fetchTeamAndPlayerDataByJoins();
			list.forEach(row->{
				System.out.println(Arrays.toString(row));
			});
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
				
	}//main

}//class
