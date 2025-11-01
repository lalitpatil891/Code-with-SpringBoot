package com.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bookstore.entity.MyBookList;
import com.bookstore.repository.MyBookRepository;

@Service
public class MyBookListService {

		@Autowired
		private MyBookRepository myBookRepo;
		
		
		public void saveMyBooks(MyBookList book) {
			myBookRepo.save(book);
		}
		
		/*public List<MyBookList> getAllMyBooks() {
			return myBookRepo.findAll();
		}*/
		

		public Page<MyBookList> getPaginatedMyBooks(int page, int size) {
		    Pageable pageable = PageRequest.of(page - 1, size);
		    return myBookRepo.findAll(pageable);
		}

		
		public void deleteMyBook(int id) {
	        myBookRepo.deleteById(id);
	    }
		
}
