package ru.ivmiit.web.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "book_order")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String address;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    private Boolean payAfterDelivery;

    private Date createDate;

    private Date paymentDate;

    private Date deliveredDate;

    @Column(length = 512)
    private String comment;

    private Double price;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<OrdersBooks> books;

}
