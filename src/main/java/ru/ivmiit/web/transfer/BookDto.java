package ru.ivmiit.web.transfer;

import lombok.*;
import ru.ivmiit.web.model.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class BookDto {
    private Long id;

    private String name;
    private String author;
    private Integer pageCount;
    private Long titlePageId;

    private Long categoryId;

    private Long publisherId;

    private String description;
    private Double price;
    private Integer count;
    private Integer rating;

    public static BookDto from(Book book){
        return BookDto.builder()
                .name(book.getName())
                .author(book.getAuthor())
                .pageCount(book.getPageCount())
                .titlePageId(book.getTitlePage().getId())
                .categoryId(book.getCategory().getId())
                .publisherId(book.getPublisher().getId())
                .description(book.getDescription())
                .price(book.getPrice())
                .count(book.getCount())
                .rating(book.getRating())
                .build();


    }

}
