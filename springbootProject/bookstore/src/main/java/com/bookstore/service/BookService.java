package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	public void saveBook(Book book) {
		bookRepo.save(book);
	}
	
	public List<Book> getAllBooks(){	
		return bookRepo.findAll();
	}
	
	public Book getBookById(int id) {
		return bookRepo.findById(id).get();
	}
	
	public void deleteBook(int id) {
		bookRepo.deleteById(id);
	}

	// New method for searching alphabet-wise
    public List<Book> searchBooksByStartingLetter(String query) {
        return bookRepo.findByNameStartingWithIgnoreCase(query);
    }
    
    
 // New method for pagination
    public Page<Book> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return bookRepo.findAll(pageable);
    }
}
