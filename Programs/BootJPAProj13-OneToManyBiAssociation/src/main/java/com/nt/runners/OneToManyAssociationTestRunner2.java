package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.IPLPlayer;
import com.nt.entity.IPLTeam;
import com.nt.service.IIPLLeagueMgmtService;

@Component
public class OneToManyAssociationTestRunner2 implements CommandLineRunner {
	@Autowired
	private  IIPLLeagueMgmtService  leagueService;

	@Override
	public void run(String... args) throws Exception {
		/*	try {
				String msg=leagueService.deleteTeamItsPlayer(1);
				System.out.println(msg);
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		/*	try {
				String msg=leagueService.deleteAllPlayersAndTheirTeam(7, 8);
				System.out.println(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		/*try {
		    String msg=leagueService.deleteAllPlayersOfATeam(2);
		    System.out.println(msg);
		}
		catch(Exception e) {
		   e.printStackTrace();
		}
		*/
		/*	try {
				String msg=leagueService.deletePlayerFromATeam(2, 2);
				System.out.println(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		try {
			IPLPlayer player=new IPLPlayer("surya", "mumbai", 455455.0);
			 String msg=leagueService.addNewPlayerToTheExistingTeam(player, 2);
			 System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//main

}//class
