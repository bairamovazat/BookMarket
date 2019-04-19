package ru.ivmiit.web.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookForm {

    private Long id;

    private String name;
    private String author;
    private Integer pageCount;

    private MultipartFile titlePage;

    private Long categoryId;
    private Long publisherId;

    private String description;

    private Double price;

    private Integer count;
    private Integer rating;
}
