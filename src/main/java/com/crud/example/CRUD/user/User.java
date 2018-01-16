package com.crud.example.CRUD.user;

import com.crud.example.CRUD.user.usecases.Error;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    String name;

    String email;

    private List<Error> errors;


}
