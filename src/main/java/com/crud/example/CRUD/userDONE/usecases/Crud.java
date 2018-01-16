package com.crud.example.CRUD.userDONE.usecases;

import com.crud.example.CRUD.userDONE.domain.User;
import com.crud.example.CRUD.userDONE.gateways.UserGatewayImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Crud {

    private UserGatewayImpl userGatewayImpl;

    @Autowired
    public Crud(UserGatewayImpl userGatewayImpl) {
        this.userGatewayImpl = userGatewayImpl;
    }

    public User createUser(User user){
        return userGatewayImpl.save(user);
    }

    public List<User> findAll() {return userGatewayImpl.findAll(); };
}
