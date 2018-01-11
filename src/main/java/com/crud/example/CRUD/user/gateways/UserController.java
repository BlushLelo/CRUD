package com.crud.example.CRUD.user.gateways;

import com.crud.example.CRUD.user.domain.User;
import com.crud.example.CRUD.user.usecases.CreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/users")
public class UserController {


    private CreateUser createUser;

    @Autowired
    public UserController(CreateUser createUser) {
        this.createUser = createUser;
    }

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_UTF8_VALUE, value="/create", produces = APPLICATION_JSON_UTF8_VALUE)
    public void execute(@NotNull @Valid @RequestBody final User user){
        createUser.createUser(user);
    }
}
