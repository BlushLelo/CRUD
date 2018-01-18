package com.crud.example.CRUD.user.usecases;

import com.crud.example.CRUD.user.domain.Error;
import com.crud.example.CRUD.user.domain.User;
import com.crud.example.CRUD.user.gateways.database.UserGateway;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CreateUser {

    private UserGateway userGateway;

    @Autowired
    public CreateUser(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User execute(User user) {

        List<Error> errors = new ArrayList<>();
        if(StringUtils.isBlank(user.getName())) {
            errors.add(new Error("Name is mandatory"));
        }
        if(StringUtils.isBlank(user.getEmail())) {
            errors.add(new Error("Email is mandatory"));
        }

        if(CollectionUtils.isEmpty(user.getErrors())){
            return userGateway.save(user);
        }

        user.setErrors(errors);

        return user;
    }
}
