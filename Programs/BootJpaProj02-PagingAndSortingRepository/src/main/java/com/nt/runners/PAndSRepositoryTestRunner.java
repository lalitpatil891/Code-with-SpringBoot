package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.nt.BootJpaProj02PagingAndSortingRepositoryApp;
import com.nt.entity.Actor;
import com.nt.service.IActorMgmtService;

@Component
public class PAndSRepositoryTestRunner implements CommandLineRunner {

    private final BootJpaProj02PagingAndSortingRepositoryApp bootJpaProj02PagingAndSortingRepositoryApp;
	@Autowired
	private   IActorMgmtService  actorService;

    PAndSRepositoryTestRunner(BootJpaProj02PagingAndSortingRepositoryApp bootJpaProj02PagingAndSortingRepositoryApp) {
        this.bootJpaProj02PagingAndSortingRepositoryApp = bootJpaProj02PagingAndSortingRepositoryApp;
    }

	@Override
	public void run(String... args) throws Exception {
		/*	try {
				//Iterable<Actor> it=actorService.showAllActorsBySorting(true, "aname");
				Iterable<Actor> it=actorService.showAllActorsBySorting(false, "aname","fee");
				it.forEach(System.out::println);
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		/*	try {
				Page<Actor> page=actorService.showActorsByPageNo(1, 5);
				page.forEach(System.out::println);
				System.out.println("Page no  ::"+(page.getNumber()+1)+"/"+page.getTotalPages());
				System.out.println(" is the current page first page  ::"+page.isFirst());
				System.out.println(" is the current page last page  ::"+page.isLast());
				System.out.println(" is the current page has got the next page  ::"+page.hasNext());
				System.out.println(" is the current page has got the previous page  ::"+page.hasPrevious());
				System.out.println(" no.of elements(records) in the current page  ::"+page.getNumberOfElements());
			}
			catch(Exception e) {
				e.printStackTrace();
			}*/
		
		/*	try {
					Page<Actor> page=actorService.showActorsByPageNoAndSorted(1,4,true,"aname");
					page.forEach(System.out::println);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		*/
		
		try {
			actorService.showActorsByPagination(3);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
