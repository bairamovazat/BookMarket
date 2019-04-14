package ru.ivmiit.web.model;

import lombok.*;
import ru.ivmiit.web.forms.BookForm;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String author;
    private Integer pageCount;
    @ManyToOne
    @JoinColumn(name = "title_file_id")
    private File titlePage;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private BookCategory category;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Column(length = 1024)
    private String description;
    private Double price;
    private Integer count;
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    public static Book from(BookForm form){
        return Book.builder()
                .name(form.getName())
                .author(form.getAuthor())
                .pageCount(form.getPageCount())
                .description(form.getDescription())
                .price(form.getPrice())
                .count(form.getCount())
                .rating(form.getRating())
                .build();
    }

}
