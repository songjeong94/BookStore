package com.project.bookstore.service;

import com.project.bookstore.domain.Book;
import com.project.bookstore.dto.BookDto;
import com.project.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookService {

    private BookRepository bookRepository;

    public Book findBook(String bookName) {
        return bookRepository.findByBookName(bookName)
                .orElseThrow(() -> new EntityNotFoundException("책이 없습니다: " + bookName));
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }


}
