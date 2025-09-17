package com.nt.runners;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.IPLPlayer;
import com.nt.entity.IPLTeam;
import com.nt.service.IIPLLeagueMgmtService;

//@Component
public class OneToManyAssociationTestRunner implements CommandLineRunner {
	@Autowired
	private  IIPLLeagueMgmtService  leagueService;

	@Override
	public void run(String... args) throws Exception {
		/*		//saving object parent to child
				try {
					IPLTeam  team=new IPLTeam("MI","Neetha","Hardik");
					IPLPlayer player1=new IPLPlayer("Rohit ", "mumbai", 100000000.0);
					IPLPlayer player2=new IPLPlayer("Hardik", "Gujarat", 11000000.0);
						//assign parent to childs
						player1.setTeam(team); player2.setTeam(team);
						
					//assign childs to parent
					   team.setPlayers(Set.of(player1,player2));
						
						//use service
						String msg=leagueService.registerIPLTeam(team);
						System.out.println(msg);
						}
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		*/		
		//saving object child to parent
				try {
					IPLTeam  team=new IPLTeam("SRH","kavyan","Cummins");
					IPLPlayer player1=new IPLPlayer("Cummins", "Australia", 100000000.0);
					IPLPlayer player2=new IPLPlayer("klassan", "SA", 13000000.0);
						//assign parent to childs
						player1.setTeam(team); player2.setTeam(team);
						
					//assign childs to parent
						Set<IPLPlayer>  childs=new HashSet<>();
						childs.add(player1);  childs.add(player2);
					   team.setPlayers(childs);
					   
					 	
						//use service
						String msg=leagueService.registerIPLPlayers(childs);
						System.out.println(msg);
						}
			     catch(Exception e) {
			    	 e.printStackTrace();
			     }


	}//main

}//class
