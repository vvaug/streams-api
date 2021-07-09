package br.com.vvaug.streams.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vvaug.streams.dto.BookRequest;
import br.com.vvaug.streams.dto.BookResponse;
import br.com.vvaug.streams.entity.Book;
import br.com.vvaug.streams.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<BookResponse> findAll(){
		return bookRepository.findAll()
				.stream()
				.map(BookResponse::new)
				.collect(Collectors.toList());
	}
	public List<BookResponse> findAllWithFunctionalInterface() {
		
		/*
		 * we can create a class that implements the functional interface and pass as parameter
		 *but if you're not going to use it in others classes, it's better to instantiate the
		 *interface directly (you must implement the interface methods)
		 */
		
		return bookRepository.findAll()
					.stream()
					.map(new Function<Book, BookResponse>() {
						@Override
						public BookResponse apply(Book book) {
							return new BookResponse(book);
						}
						
					})
					.collect(Collectors.toList());
	}
	
	public List<BookResponse> findAllWithLambdaExpression() {
		
		/*
		 * must be a functional interface to be able to use lambda expression
		 *
		 *it's equivalent to:
		 *Function<Book, BookResponse> function = book -> new BookResponse(book);
		 *.map(function)
		 */
		
		return bookRepository.findAll()
					.stream()
					.map(book -> new BookResponse(book))
					.collect(Collectors.toList());
	}

	public List<BookResponse> findAllWithMethodReference() {
		
		/*
		 * method reference can be used when you have not a complex logic. You just want to call a simple method.
		 *if you're going to use some logic or validation on a function interface, you must use lambda.
		 */
		
		return bookRepository.findAll()
					.stream()
					.map(BookResponse::new)
					.collect(Collectors.toList());
	}
	
	
	public void save(BookRequest request) {
		bookRepository.save(new Book(request));
	}

}
