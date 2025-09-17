package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;
import com.nt.service.IActorMgmtService;

@Component
public class CrudRepositoryTestRunner implements CommandLineRunner {


	@Autowired
	private  IActorMgmtService  actorService;




	@Override
	public void run(String... args) throws Exception {
		/*	try {
				Actor actor=new  Actor();
				actor.setAname("mukesh1");actor.setAddrs("mumbai");
				actor.setCategory("side character"); actor.setFee(90001.0); 
				//invoke the method
				String msg=actorService.registerActor(actor);
				System.out.println(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		*/
		
		/*try {
			 Actor  actor1=new Actor("RK singh","mumbai","hero",900000.0);
			 Actor  actor2=new Actor("RKapoor","mumbai","hero",1200000.0);
			 Actor  actor3=new Actor("shahid","mumbai","hero",1100000.0);
			 String msg=actorService.registerActors(List.of(actor1,actor2,actor3));
			 System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			String msg=actorService.isActorExistById(1021);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		/*	try {
			    Iterable<Actor>  list=actorService.showAllActors();
			    list.forEach(System.out::println);
			    System.out.println("===========");
			    list.forEach(actor->System.out.println(actor));
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/

		/*try {
		// Iterable<Actor>  list=actorService.showActorsByIds(List.of(101,102,103,null,999));
		 Iterable<Actor>  list=actorService.showActorsByIds(Arrays.asList(101,102,103,null,9999));
		 list.forEach(System.out::println);
		}
		catch(Exception e) {
		   e.printStackTrace();	 
		}*/
		 
		/*try {
			Optional<Actor>  opt=actorService.showActorById(1020);
			if(opt.isPresent()) {
				System.out.println("Actor Details are "+opt.get());
			}
			else {
				System.out.println("Actor not found");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			Actor  actor= actorService.findActorById(102);
			System.out.println(actor);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		/*try {
			Actor actor=actorService.fetchActorById(102);
			System.out.println(actor);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/

		
		/*		try {
					String msg=actorService.updateActorFee(102, 10.0f);
					System.out.println(msg);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
		*/
		
		/*try {
			Actor actor=new Actor(1015,"Anubhav","vizag",null,51145.55);
			String msg=actorService.registerOrUpdateActor(actor);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*	try {
				String msg=actorService.removeActorById(10200);
				System.out.println(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*try {
			Actor actor=new Actor(1031,"xxx","yyyy","aaa",45555.0);
		 String msg=actorService.removeActor(actor);
		 System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		/*	try {
				String msg=actorService.removeActorsByIds(List.of(104,105,107,196,193));
				System.out.println(msg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		*/	
		
		try {
			String msg=actorService.removeAllActors();
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		
	}//main
}//class
