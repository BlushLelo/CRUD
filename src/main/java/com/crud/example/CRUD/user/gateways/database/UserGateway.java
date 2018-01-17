package com.crud.example.CRUD.user.gateways.database;

import com.crud.example.CRUD.user.domain.User;

public interface UserGateway {
    User save(User user);
}
