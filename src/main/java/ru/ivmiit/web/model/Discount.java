package ru.ivmiit.web.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Double salePercent;

    private Boolean enabled;
    @Column(nullable =  false)
    private Date endDate;

    @OneToMany(mappedBy = "discount")
    private List<Book> books;
}
