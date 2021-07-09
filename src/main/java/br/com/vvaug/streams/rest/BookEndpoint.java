package br.com.vvaug.streams.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vvaug.streams.dto.BookRequest;
import br.com.vvaug.streams.dto.BookResponse;
import br.com.vvaug.streams.service.BookService;

@CrossOrigin("*")
@RestController
@RequestMapping("/books")
public class BookEndpoint {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<BookResponse> findAll(){
		return bookService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody BookRequest request) {
		 bookService.save(request);
	}

}
