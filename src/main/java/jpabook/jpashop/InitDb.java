package jpabook.jpashop;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
        initService.dbInit2();
    }


    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit1() {
            Member member = new Member("userA", new Address("서울", "1", "1111"));
            em.persist(member);

            Book book1 = new Book("jpa-book1", 10000, 100, "tobe", "00110011");
            Book book2 = new Book("jpa-book2", 20000, 100, "tobe", "00110011");

            em.persist(book1);
            em.persist(book2);

            OrderItem orderItem1 = OrderItem.createOrderItem(book1, 10000, 1);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, 20000, 1);

            Order order = Order.createOrder(member, new Delivery(member.getAddress()), orderItem1, orderItem2);
            em.persist(order);
        }

        public void dbInit2() {
            Member member = new Member("userB", new Address("인천", "2", "2222"));
            em.persist(member);

            Book book1 = new Book("spring-book1", 10000, 100, "tobe", "00110011");
            Book book2 = new Book("spring-book2", 30000, 100, "tobe", "00110011");

            em.persist(book1);
            em.persist(book2);

            OrderItem orderItem1 = OrderItem.createOrderItem(book1, 10000, 1);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, 30000, 1);

            Order order = Order.createOrder(member, new Delivery(member.getAddress()), orderItem1, orderItem2);
            em.persist(order);
        }

    }
}
