package com.crud.example.CRUD.user.usecases;

import com.crud.example.CRUD.user.domain.User;
import com.crud.example.CRUD.user.gateways.UserGatewayImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {

    private UserGatewayImpl userGatewayImpl;

    @Autowired
    public CreateUser(UserGatewayImpl userGatewayImpl) {
        this.userGatewayImpl = userGatewayImpl;
    }

    public User createUser(User user){
        return userGatewayImpl.save(user);
    }
}
