package jpabook.jpashop.repository.order;

import jpabook.jpashop.domain.Order;

import java.util.List;

public interface OrderRepositoryExtension {

    List<Order> findAll(OrderSearch orderSearch);

    List<Order> findAllByString(OrderSearch orderSearch);

    List<Order> findAllByCriteria(OrderSearch orderSearch);

    List<Order> findAllWithMemberDelivery();

    List<Order> findAllWithMemberDelivery(int offset, int limit);

    List<Order> findAllWithItem();
}
