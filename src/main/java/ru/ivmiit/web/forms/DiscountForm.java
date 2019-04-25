package ru.ivmiit.web.forms;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiscountForm {
    private Long id;
    private String code;
    private Double salePercent;
}
