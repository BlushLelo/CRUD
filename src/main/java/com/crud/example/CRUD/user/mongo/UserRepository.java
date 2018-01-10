package com.crud.example.CRUD.user.mongo;

import com.crud.example.CRUD.user.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{

    @Override
    User findOne(String id);
}
