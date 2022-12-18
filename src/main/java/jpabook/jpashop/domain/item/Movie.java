package jpabook.jpashop.domain.item;

import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class Movie extends Item {

    private String director;

    private String actor;

    public Movie(String name, int price, int stockQuantity, String director, String actor) {
        super(name, price, stockQuantity);
        this.director = director;
        this.actor = actor;
    }

    protected Movie() {
    }
}
