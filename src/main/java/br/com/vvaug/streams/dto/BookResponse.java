package br.com.vvaug.streams.dto;

import br.com.vvaug.streams.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookResponse {

	private String name;

	public BookResponse(Book book) {
		this.name = book.getName();
	}
}
