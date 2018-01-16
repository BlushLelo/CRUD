package com.crud.example.CRUD.user.usecases;

import com.crud.example.CRUD.user.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CreateUser {

    public User execute(User user) {

        List<Error> errors = new ArrayList<>();
        if(StringUtils.isBlank(user.getName())) {
            errors.add(new Error("Name is mandatory"));
        }
        if(StringUtils.isBlank(user.getEmail())) {
            errors.add(new Error("Email is mandatory"));
        }

        user.setErrors(errors);

        return user;
    }
}
