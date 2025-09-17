package com.nt.service;

import org.springframework.data.domain.Page;

import com.nt.entity.Actor;

public interface IActorMgmtService {
	public  Iterable<Actor>   showAllActorsBySorting(boolean ascOrder,String ...props);
	public   Page<Actor>  showActorsByPageNo(int pageno,int size);
	public   Page<Actor>  showActorsByPageNoAndSorted(int pageno,int size,boolean ascOrder,String ...props);
	public   void   showActorsByPagination(int pageSize);
	
  
}
