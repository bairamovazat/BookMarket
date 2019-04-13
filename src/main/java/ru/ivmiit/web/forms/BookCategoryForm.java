package ru.ivmiit.web.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ivmiit.web.model.BookCategory;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookCategoryForm {
    private Long id;
    private String name;
}
