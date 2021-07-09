package br.com.vvaug.streams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vvaug.streams.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
