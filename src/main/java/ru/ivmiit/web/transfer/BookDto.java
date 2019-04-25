package ru.ivmiit.web.transfer;

import lombok.*;
import ru.ivmiit.web.model.Book;

import java.util.List;
import java.util.stream.Collectors;

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

    private String categoryName;

    private String publisherName;

    private String description;
    private Double price;
    private Integer count;
    private Integer rating;

    private List<CommentDto> comments;

    public static BookDto from(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .author(book.getAuthor())
                .pageCount(book.getPageCount())
                .titlePageId(book.getTitlePage() != null ? book.getTitlePage().getId() : null)
                .categoryName(book.getCategory() != null ? book.getCategory().getName() : null)
                .publisherName(book.getPublisher() != null ? book.getPublisher().getName() : null)
                .description(book.getDescription())
                .price(book.getPrice())
                .count(book.getCount())
                .rating(book.getRating())
                .comments(
                        book.getComments().stream()
                                .map(CommentDto::from)
                                .collect(Collectors.toList())
                )
                .build();

    }

}
