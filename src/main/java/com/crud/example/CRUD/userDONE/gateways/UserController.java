package com.crud.example.CRUD.userDONE.gateways;

import com.crud.example.CRUD.userDONE.domain.User;
import com.crud.example.CRUD.userDONE.usecases.Crud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/users")
public class UserController {


    private Crud Crud;

    @Autowired
    public UserController(Crud Crud) {
        this.Crud = Crud;
    }

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public void execute(@NotNull @Valid @RequestBody final User user){
        Crud.createUser(user);
    }

    @RequestMapping(method = GET, consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public List<User> execute2(){
        return Crud.findAll();
    }
}
