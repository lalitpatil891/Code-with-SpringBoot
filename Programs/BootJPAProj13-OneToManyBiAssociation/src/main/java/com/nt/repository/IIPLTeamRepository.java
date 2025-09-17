package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.IPLTeam;

public interface IIPLTeamRepository extends JpaRepository<IPLTeam, Integer> {

}
