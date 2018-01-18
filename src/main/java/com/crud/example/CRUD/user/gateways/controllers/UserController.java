package com.crud.example.CRUD.user.gateways.controllers;

import com.crud.example.CRUD.user.domain.User;
import com.crud.example.CRUD.user.usecases.CreateUser;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private CreateUser createUser;

    @Autowired
    public UserController(CreateUser createUser) {
        this.createUser = createUser;
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> save(@RequestBody User user) {
        User result = createUser.execute(user);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}
