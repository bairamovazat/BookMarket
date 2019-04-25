package ru.ivmiit.web.forms;


import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderForm {

    private List<OrderBook> books = new ArrayList<>();

    private Boolean payAfterDelivery;
    private String address;
    private String comment;

    private String saleCode;

    public List<OrderBook> getOrderBooksList(){
        return books;
    }

}
