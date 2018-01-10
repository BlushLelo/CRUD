package com.crud.example.CRUD.user.gateways;

import com.crud.example.CRUD.user.domain.User;

public interface UserGateway {
    User findOne(User user);
    User save(User user);
}
