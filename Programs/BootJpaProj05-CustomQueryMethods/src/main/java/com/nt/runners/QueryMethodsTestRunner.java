package com.nt.runners;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IActorRepository;

@Component
public class QueryMethodsTestRunner implements CommandLineRunner {

    @Autowired
	private   IActorRepository  actorRepo;

    
	@Override
	public void run(String... args) throws Exception {
		
		//actorRepo.showActorsByFee(10000.0, 200000.0).forEach(System.out::println);
		
		/*actorRepo.showActorsByCategories("hero", "comedian", "artist").forEach(System.out::println);
		System.out.println("-----------------");
		actorRepo.showActorsDataByCategories("hero", "comedian", "artist").forEach(row->{
			 for(Object val: row) {
				 System.out.print(val+"  ");
			 }
			 System.out.println();
		});
		System.out.println("---------------------");
		actorRepo.showActorsFeeByCategories("hero", "comedian", "artist").forEach(System.out::println);
		*/
		
		/*System.out.println("kiara  actor all details::"+actorRepo.fetchActorByName("kiara"));
		System.out.println("----------------------------------");
		Object row[]=(Object[])actorRepo.fetchActorDataByName("kiara");
		System.out.println("kiara  actor  multiple details::"+Arrays.toString(row));
		System.out.println("-----------------------------------");
		System.out.println("kiara actor  Fee ::"+actorRepo.fetchActorFeeByName("kiara"));
		*/
		
		/*System.out.println("Actors count::"+actorRepo.getUniqueActorCategoryCount());
		Object row[]=(Object[])actorRepo.showActorAggregateData();
		System.out.println("ACtors count::"+row[0]);
		System.out.println("ACtors fee avg::"+row[1]);
		System.out.println("ACtors  min fee::"+row[2]);
		System.out.println("ACtors  max fee::"+row[3]);
		System.out.println("ACtors  sum of fee::"+row[4]);
		*/
		
		/*int count=actorRepo.updateActorsFeeByCategories("hero", "comedian", 10.0);
		System.out.println("No.of Actors that are updated ::"+count);
		*/
		
		/*int count1=actorRepo.deleteActorsByFeeRange(1000.0, 89000.0);
		System.out.println("no.of Actors that are deleted::"+count1);
		*/
		
		
		try {
			LocalDateTime ldt=actorRepo.showSysDateTime();
			System.out.println("System Date And time ::"+ldt);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		

	}

}
