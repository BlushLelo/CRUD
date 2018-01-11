package com.crud.example.CRUD.user.mongo;


import com.crud.example.CRUD.user.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByName(String nome);
    List<User> findAll();
}
