package com.crud.example.CRUD.userDONE.gateways;

import com.crud.example.CRUD.userDONE.domain.User;

import java.util.List;


public interface UserGateway {
    User save(User user);

    List<User> findAll();
}
