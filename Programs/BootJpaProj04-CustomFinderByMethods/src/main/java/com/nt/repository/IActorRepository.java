package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Actor;

public interface IActorRepository extends JpaRepository<Actor, Integer> {
	public List<Actor>  findByCategoryEquals(String category);    
	public Iterable<Actor>  getByCategoryIs(String category);    
	public Iterable<Actor>  readByCategory(String category);    
	
	public   Iterable<Actor>  findByFeeBetween(double start,double end);
	public   Iterable<Actor>  findByAnameStartingWith(String initChars);
	public   Iterable<Actor>  findByAnameEndingWith(String lastChars);
	public   Iterable<Actor>  findByAnameContaining(String chars);
	public   Iterable<Actor>  findByCategoryIn(List<String> categories);
	public   Iterable<Actor>  findByAnameLikeOrderByAnameAsc(String chars);
	public   Iterable<Actor>  findByAnameLikeIgnoreCase(String chars);
	public   Iterable<Actor>  findByCategoryInAndFeeBetweenOrderByAnameAsc(List<String> categories,double start,double end);
	public   Iterable<Actor>  findByCategoryIsNullOrAddrsIn(List<String> list);
	
	
	
}
