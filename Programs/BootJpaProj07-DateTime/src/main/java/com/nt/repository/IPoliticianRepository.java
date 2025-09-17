package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Politician;

public interface IPoliticianRepository extends JpaRepository<Politician, Integer> {
	//@Query(value="select round((sysdate-dob)/365.25, 2) from Politician  where  pid=:id",nativeQuery = true)  //for oracle
	@Query(value="select round(timestampdiff(DAY,dob,curdate())/365.25,2) from Politician  where  pid=:id",nativeQuery = true)  //for mysql
   public    float   fetchPoliticianAgeById(int  id);

	@Query(value="select pname,round(timestampdiff(DAY,dob,curdate())/365.25,2) from Politician",nativeQuery = true)  //for mysql
	public  List<Object[]>  fetchPolicianNameAgeDetails();  
}
