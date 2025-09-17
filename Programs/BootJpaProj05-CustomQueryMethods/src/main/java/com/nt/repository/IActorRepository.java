package com.nt.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Actor;

import jakarta.transaction.Transactional;

public interface IActorRepository extends JpaRepository<Actor, Integer> {
	
	//@Query("from Actor  where  fee>=?1 and fee<=?2  ")
	//@Query("from Actor  where  fee>=:min and fee<=:max  ")
	//public   List<Actor>   showActorsByFee(@Param("min") double start, @Param("max") double end);
	
	//@Query("from Actor  where  fee>=:start and fee<=:end  ")
	//@Query("select  ac from Actor as ac where  ac.fee>=:start and ac.fee<=:end  ")
	//@Query("select  ac from com.nt.entity.Actor as ac where  ac.fee>=:start and ac.fee<=:end  ")
	@Query("from Actor  where  fee>=:start and fee<=:end ")
	public   List<Actor>   showActorsByFee( double start,  double end);
	
	
	@Query("from Actor  where  category in(:cat1,:cat2,:cat3) ")
	public   List<Actor>   showActorsByCategories(String cat1,String cat2,String cat3 );
	
	//Native SQL Query
	@Query(value="select now() from dual",nativeQuery=true)
	public   LocalDateTime    showSysDateTime();
	
	
	//Bulk Select Scalar Query  specific multiple col values
	@Query("select aid,aname,category from Actor where category in(:cat1,:cat2,:cat3)")
	public  List<Object[]>  showActorsDataByCategories(String cat1,String cat2,String cat3);
	
	
	//Bulk Select Scalar Query  getting specific single col value
	@Query("select fee from Actor where category in(:cat1,:cat2,:cat3)")
	public  List<Double>  showActorsFeeByCategories(String cat1,String cat2,String cat3);
	
	
	//  Single Record Entity  Select Query
	@Query("from Actor   where  aname=:name")
	public  Actor   fetchActorByName(String name);
	
//  Single Record scalar  Select Query  (multiple col values)
	@Query("select  aid,aname,category from Actor   where  aname=:name")
	public  Object   fetchActorDataByName(String name);
	
	
//  Single Record scalar  Select Query  (single col values)
	@Query("select  fee from Actor   where  aname=:name")
	public  Double   fetchActorFeeByName(String name);
	
	
	// aggregate function calls
	@Query("select  count(distinct category)  from Actor")
	public  long    getUniqueActorCategoryCount();
	
	@Query("select  count(*),avg(fee),max(fee),min(fee),sum(fee)  from Actor")
	public    Object     showActorAggregateData();
	
	
	//HQL/JPQL  non  select Queries 
	@Query("update Actor  set fee=fee+(:hikePercent/100.0) where category in(:cat1,:cat2)")
	@Modifying
	@Transactional
	public  int    updateActorsFeeByCategories(String cat1,String cat2,double hikePercent);
	
	@Query("delete from Actor  where fee>=:start and fee<:end")
	@Modifying
	@Transactional
	public int   deleteActorsByFeeRange(double start,double end);
	

	
}
