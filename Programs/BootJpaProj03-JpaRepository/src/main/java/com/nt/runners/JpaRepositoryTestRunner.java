package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Actor;
import com.nt.service.IActorMgmtService;

@Component
public class JpaRepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private IActorMgmtService actorService;
	
	
	@Override
	public void run(String... args) throws Exception {
		/*	try{
				String msg=actorService.removeActorsByIdsInBatch(List.of(101,102,566));
				System.out.println(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*try {
			Actor actor=new Actor();
			 actor.setCategory("hero"); actor.setAddrs("hyd");
			List<Actor>  list=actorService.showActorsByData(actor,true,"aname");
			list.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			//Actor  actor=actorService.showActorById(1056);
			actorService.showActorById(105);
			//System.out.println("Actor info ::"+actor);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("======================");
		
		try {
			Actor proxy=actorService.fetchActorById(1057);
			/*System.out.println("Proxy obj class name::"+proxy.getClass()+"...."+proxy.getClass().getSuperclass());
			System.out.println("id  value ::"+proxy.getAid());
			*//*System.out.println("actor name::"+proxy.getAname());
			System.out.println("actor name::"+proxy.getCategory());
			*/
			//System.out.println("Actor Data::"+actor);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}

}
