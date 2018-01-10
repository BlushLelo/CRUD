package com.crud.example.CRUD.user.gateways;

import com.crud.example.CRUD.user.domain.User;
import com.crud.example.CRUD.user.mongo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserGatewayImpl implements UserGateway{

    private UserRepository userRepository;

    @Autowired
    public UserGatewayImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findOne(User user) {
        return userRepository.findOne(user);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
