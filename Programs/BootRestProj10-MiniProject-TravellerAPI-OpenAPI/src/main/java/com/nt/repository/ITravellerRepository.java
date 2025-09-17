package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.TravellerEntity;

import jakarta.transaction.Transactional;

public interface ITravellerRepository extends JpaRepository<TravellerEntity, Integer> {

	@Query("select  distinct te from  TravellerEntity   te inner join te.visitedCountries vc where  vc  in  :countries order by  te.name")
	public  List<TravellerEntity>  fetchTravellersByCountries(List<String>  countries);
	public  List<TravellerEntity>  findByCurrentLocation(String location);
	
	 @Query(
		      value = "DELETE FROM TRAVELLER_VISITED_COUNTRIES " +
		              "WHERE VISITED_COUNTRIES IN (:countries)",
		      nativeQuery = true   )
		    	@Modifying
	@Transactional
	public  int  deleteTravellersByCountries(List<String> countries);
	 
	 @Modifying
	    @Transactional
	    @Query(
	      value = "DELETE FROM REST_TRAVELLER " +
	              "WHERE tid NOT IN (SELECT traveller_id FROM TRAVELLER_VISITED_COUNTRIES)",
	      nativeQuery = true
	    )
	    int deleteOrphanTravellers();
}
