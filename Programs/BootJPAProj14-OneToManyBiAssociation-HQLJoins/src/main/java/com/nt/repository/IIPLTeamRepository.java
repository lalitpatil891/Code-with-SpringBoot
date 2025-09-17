package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.IPLTeam;

public interface IIPLTeamRepository extends JpaRepository<IPLTeam, Integer> {
	
	
	//@Query("select  t.tid,t.tname,t.owner,t.captain ,p.pid,p.pname,p.paddrs,p.price from IPLTeam  t inner join t.players p")
	//@Query("select  t.tid,t.tname,t.owner,t.captain ,p.pid,p.pname,p.paddrs,p.price from IPLTeam  t left join t.players p")
	//@Query("select  t.tid,t.tname,t.owner,t.captain ,p.pid,p.pname,p.paddrs,p.price from IPLTeam  t right join t.players p")
	@Query("select  t.tid,t.tname,t.owner,t.captain ,p.pid,p.pname,p.paddrs,p.price from IPLTeam  t full join t.players p")

	public  List<Object[]>  showTeamAndPlayersDataUsingJoins();

}
