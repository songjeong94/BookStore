package com.project.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public record BookDto(
        Long bookNum,
        String bookName,
        String content,
        String description,
        LocalDateTime publicationDate
) {

    public static BookDto of(Long bookNum, String bookName, String content, String description, LocalDateTime publicationDate) {
        return new BookDto(bookNum,bookName, content, description, publicationDate);
    }

}
