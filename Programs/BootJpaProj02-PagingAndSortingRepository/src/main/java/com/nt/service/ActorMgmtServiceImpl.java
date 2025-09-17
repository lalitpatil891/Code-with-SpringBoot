package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;

@Service
public class ActorMgmtServiceImpl implements IActorMgmtService {
	@Autowired
	private IActorRepository  actorRepo;

	@Override
	public Iterable<Actor> showAllActorsBySorting(boolean ascOrder, String... props) {
		//create  Sort object
		 Sort sort=Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC, props);
		//use repo
		 Iterable<Actor> it=actorRepo.findAll(sort);
		return it;
	}
	
	@Override
	public Page<Actor> showActorsByPageNo(int pageno, int size) {
		// create Pageable object
		Pageable pageable=PageRequest.of(pageno, size);
		// use repo
		Page<Actor>  page=actorRepo.findAll(pageable);
		return page;
	}
	
	@Override
	public Page<Actor> showActorsByPageNoAndSorted(int pageno, int size, boolean ascOrder, String... props) {
		//create Sort object
		Sort sort=Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC, props);
		//create Pageable object
		Pageable pageable=PageRequest.of(pageno-1, size,sort);
		// use repo
				Page<Actor>  page=actorRepo.findAll(pageable);
				return page;	
				
    }
	
	@Override
	public void showActorsByPagination(int pageSize) {
	   //total records count
		long count=actorRepo.count();
		//count no.of pages
		long pagesCount=count/pageSize;
		if(count%pageSize!=0)
			 pagesCount++;
		
		for(int i=0;i<pagesCount;i++) {
			//create Pageable object
			Pageable pageable=PageRequest.of(i, pageSize);
			Page<Actor> page=actorRepo.findAll(pageable);
			System.out.println("pageNo::"+ (page.getNumber()+1) +"/"+page.getTotalPages()+" records");
			page.forEach(System.out::println);
		}
		
	}
	
	

}
