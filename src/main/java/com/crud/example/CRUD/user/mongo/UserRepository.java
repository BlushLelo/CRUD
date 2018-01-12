package com.crud.example.CRUD.user.mongo;


import com.crud.example.CRUD.user.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    User findByNome(String nome);
    List<User> findAll();
}
