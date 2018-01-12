package com.crud.example.CRUD.user.gateways;

import com.crud.example.CRUD.user.domain.User;

import java.util.List;


public interface UserGateway {
    User save(User user);

    List<User> findAll();
}
