package com.pascob.pkbookservices.model;

import org.springframework.hateoas.RepresentationModel;

import com.pascob.pkbookservices.domain.User;

import lombok.Getter;

@Getter
public class UserModel extends RepresentationModel<UserModel>{
    private final User user;

    public UserModel(final User user){
        this.user = user;
    }
}
