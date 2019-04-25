package ru.ivmiit.web.model;

import lombok.*;
import ru.ivmiit.web.forms.BookForm;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @Column(length = 1024)
    private String description;
    private Double price = 0.0;
    private Integer count;
    private Integer rating;

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
