package com.crud.example.CRUD.userDONE.mongo;


import com.crud.example.CRUD.userDONE.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    User findByNome(String nome);
    List<User> findAll();
}
