package com.project.bookstore.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@ToString
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookNum;

    @Column(nullable = false)
    @Setter
    private String bookName;

    @Column(nullable = false)
    @Setter
    private String content;

    @Column(nullable = false, length = 1000)
    @Setter
    private String description;

    @Column(nullable = false)
    private int price;

    @CreatedDate
    private LocalDateTime publicationDate;

    protected Book() {}

    public Book(Long bookNum, String bookName, String content, String description, LocalDateTime publicationDate) {
        this.bookNum = bookNum;
        this.bookName = bookName;
        this.content = content;
        this.description = description;
        this.publicationDate = publicationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookNum, book.bookNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookNum);
    }
}
