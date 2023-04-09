package com.project.bookstore.repository;

import com.project.bookstore.domain.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DisplayName("BookRepository - JPA 테스트")
@DataJpaTest
class BookRepositoryTest {

    private BookRepository bookRepository;

    public BookRepositoryTest(@Autowired BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @DisplayName("Book")
    @Test
    public void findBook() {

        bookRepository.save(bookEntity1());

        Optional<Book> testBook = bookRepository.findById(1L);

        assertThat(testBook.get().getBookName()).isEqualTo("해리포터");
    }

    @DisplayName("find-Books")
    @Test
    public void findAll() {

        bookRepository.save(bookEntity1());
        bookRepository.save(bookEntity2());
        bookRepository.save(bookEntity3());

        List<Book> books = bookRepository.findAll();

    }

    @DisplayName("find-book")
    @Test
    public void givenBookName_WhenSearchingBook_ThenReturnBook() {

        bookRepository.save(bookEntity1());
        bookRepository.save(bookEntity2());
        bookRepository.save(bookEntity3());

        Optional<Book> book = bookRepository.findByBookName(bookEntity1().getBookName());

        assertThat(book.get().getBookNum()).isEqualTo(1L);

    }



    private Book bookEntity1() {
        return  Book.builder()
                .bookNum(1L)
                .bookName("해리포터")
                .content("1.fasfad 2.fddfdsfsfs 3.fdsfsd")
                .description("sadlksanllasdnlasnlk")
                .publicationDate(LocalDateTime.now())
                .build();
    }

    private Book bookEntity2() {
        return  Book.builder()
                .bookNum(2L)
                .bookName("해리포터2")
                .content("1.asda 2.ad 3.adsqw")
                .description("asdad")
                .publicationDate(LocalDateTime.now())
                .build();
    }

    private Book bookEntity3() {
        return  Book.builder()
                .bookNum(3L)
                .bookName("해리포터3")
                .content("1.dd 2.aa 3.asd")
                .description("ddd")
                .publicationDate(LocalDateTime.now())
                .build();
    }

}