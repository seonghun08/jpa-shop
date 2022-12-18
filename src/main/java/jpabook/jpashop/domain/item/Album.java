package jpabook.jpashop.domain.item;

import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
public class Album extends Item {

    private String artist;

    private String etc;

    public Album(String name, int price, int stockQuantity, String artist, String etc) {
        super(name, price, stockQuantity);
        this.artist = artist;
        this.etc = etc;
    }

    protected Album() {
    }
}
