package com.crud.example.CRUD.userDONE.gateways;

import com.crud.example.CRUD.userDONE.domain.User;
import com.crud.example.CRUD.userDONE.mongo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
