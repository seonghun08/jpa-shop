package jpabook.jpashop.repository.order;

import jpabook.jpashop.domain.OrderStatus;
import lombok.Data;

@Data
public class OrderSearch {

    private String memberName;

    private OrderStatus orderStatus;
}
