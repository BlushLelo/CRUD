package com.crud.example.CRUD.user.gateways;

import com.crud.example.CRUD.user.domain.User;


public interface UserGateway {
    User save(User user);
}
