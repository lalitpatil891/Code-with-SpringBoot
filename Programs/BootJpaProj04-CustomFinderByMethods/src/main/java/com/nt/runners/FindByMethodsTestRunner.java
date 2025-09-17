package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;

@Component
public class FindByMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private   IActorRepository  actorRepo;

	@Override
	public void run(String... args) throws Exception {
		
		/*List<Actor>  list=actorRepo.findByCategoryEquals("hero");
		list.forEach(System.out::println);
		*/
		//actorRepo.getByCategoryIs("hero").forEach(System.out::println);
		//actorRepo.readByCategory("hero").forEach(System.out::println);
		// actorRepo.findByFeeBetween(10000.0, 200000.0).forEach(System.out::println);
		
		/*	actorRepo.findByAnameStartingWith("d").forEach(System.out::println);
			actorRepo.findByAnameEndingWith("a").forEach(System.out::println);
			actorRepo.findByAnameContaining("nt").forEach(System.out::println);
		*/	
		//actorRepo.findByCategoryIn(List.of("hero","heroine","comedian")).forEach(System.out::println);
		/*actorRepo.findByAnameLikeOrderByAnameAsc("%a").forEach(System.out::println);
		System.out.println("--------------------------------");
		actorRepo.findByAnameLikeOrderByAnameAsc("a%").forEach(System.out::println);
		System.out.println("--------------------------------");
		actorRepo.findByAnameLikeOrderByAnameAsc("%t%").forEach(System.out::println);
		*/
		//actorRepo.findByAnameLikeIgnoreCase("%a").forEach(System.out::println);
		   //actorRepo.findByCategoryInAndFeeBetweenOrderByAnameAsc(List.of("hero","comedian"),10000.0, 300000.0).forEach(System.out::println);
		   actorRepo.findByCategoryIsNullOrAddrsIn(List.of("hyd","vizag")).forEach(System.out::println);
		    
		
		

	}

}
