package com.pascob.pkbookservices.model;

import com.pascob.pkbookservices.domain.User;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;

@Getter
public class UserModel extends RepresentationModel<UserModel>{
    private final User user;

    public UserModel(final User user){
        this.user = user;
    }
}
