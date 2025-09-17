package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.IPLPlayer;
import com.nt.entity.IPLTeam;
import com.nt.service.IIPLLeagueMgmtService;

@Component
public class OneToManyAssociationTestRunner1 implements CommandLineRunner {
	@Autowired
	private  IIPLLeagueMgmtService  leagueService;

	@Override
	public void run(String... args) throws Exception {
		/*try {
			List<IPLTeam>  list=leagueService.showAllTeamsAndPlayers();
					list.forEach(team->{
						System.out.println("Team (parent) ::"+team);
						Set<IPLPlayer>  palyers=team.getPlayers();
						palyers.forEach(player->{
							System.out.println("Player(Child) ::"+player);
							
						});
						System.out.println("=======================");
					});
			
			}//try
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			List<IPLPlayer>  list=leagueService.showAllPalyersAndTeams();
			/*		list.forEach(player->{
						System.out.println("child(Player)::"+player);
						IPLTeam team=player.getTeam();
						System.out.println("Parent (Team)::"+team);
						System.out.println("--------------------------");
					});*/
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//main

}//class
