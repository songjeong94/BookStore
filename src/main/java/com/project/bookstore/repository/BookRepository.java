package com.project.bookstore.repository;

import com.project.bookstore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByBookName(String bookName);

    Optional<List<Book>> findAllByBookName(Book book);

}
