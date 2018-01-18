package com.crud.example.CRUD.user.gateways.database;

import com.crud.example.CRUD.user.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
