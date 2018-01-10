package com.crud.example.CRUD.user.usecases;

import com.crud.example.CRUD.user.domain.User;
import com.crud.example.CRUD.user.gateways.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateUser {

    private UserGateway userGateway;

    @Autowired
    public CreateUser(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User createUser(User user){
        return userGateway.save(user);
    }
}
