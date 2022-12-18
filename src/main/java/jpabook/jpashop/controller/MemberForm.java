package jpabook.jpashop.controller;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MemberForm {

    @NotBlank(message = "회원 이름은 필수 입니다.")
    private String name;

    private String city;

    private String street;

    private String zipcode;
}
