package ru.ivmiit.web.transfer;


import lombok.*;
import ru.ivmiit.web.model.Order;
import ru.ivmiit.web.model.OrderStatus;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class OrderDto {
    private Long id;

    private String address;

    private OrderStatus status;

    private Boolean payAfterDelivery;

    private Date createDate;

    private Date paymentDate;

    private Date deliveredDate;

    private String comment;

    private Double price;

    private Double salePercent;

    private UserDto user;

    private List<BookDto> books;

    public static OrderDto from(Order order){
        OrderDto orderDto = OrderDto.builder()
                .id(order.getId())
                .address(order.getAddress())
                .status(order.getStatus())
                .payAfterDelivery(order.getPayAfterDelivery())
                .createDate(order.getCreateDate())
                .paymentDate(order.getPaymentDate())
                .deliveredDate(order.getDeliveredDate())
                .comment(order.getComment())
                .price(order.getPrice())
                .salePercent(order.getDiscount() == null? null : order.getDiscount().getSalePercent())
                .books(
                        order.getBooks()
                        .stream()
                        .map(b -> BookDto.from(b.getBook()))
                        .collect(Collectors.toList())
                )
                .user(UserDto.from(order.getUser()))
                .build();
        return orderDto;
    }


    public static List<OrderDto> from(List<Order> orders){
        return orders.stream()
                .map(OrderDto::from)
                .collect(Collectors.toList());
    }
}
