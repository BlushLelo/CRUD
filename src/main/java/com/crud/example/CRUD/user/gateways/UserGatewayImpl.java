package com.crud.example.CRUD.user.gateways;

import com.crud.example.CRUD.user.domain.User;
import com.crud.example.CRUD.user.mongo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserGatewayImpl implements UserGateway {

    private final UserRepository userRepository;

    @Autowired
    public UserGatewayImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(final User user) {
        return userRepository.save(user);
    }
}
