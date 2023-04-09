package com.project.bookstore.service;

import com.project.bookstore.domain.Book;
import com.project.bookstore.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@DisplayName("Book - 서비스 로직")
@ExtendWith({MockitoExtension.class})
class BookServiceTest {

    @InjectMocks private BookService bookService;
    @Mock private BookRepository bookRepository;

    @DisplayName("책 이름을 검색하면 - 책 정보가 나온다.")
    @Test
    public void givenBookName_whenSearchingBookName_thenReturnsBook() {
        //given
        String bookName = "해리포터";
        //when
        Book test = bookService.findBook(bookName);
        //then
        assertThat(test.getBookName()).isEqualTo(bookName);
    }

    @DisplayName("책 이름을 검색했을때 - 책의 정보가 없다.")
    @Test
    public void givenWrongName_whenSearchingBookName_thenReturnErrorMessage() {
        //Given
        String bookName = "헝거게임";
        //When
        Book test = bookService.findBook(bookName);
        //Then
    }

}