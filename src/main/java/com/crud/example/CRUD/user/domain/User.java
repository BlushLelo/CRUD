package com.crud.example.CRUD.user.domain;

import com.crud.example.CRUD.user.gateways.database.UserGateway;
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

    public UserGateway userGateway;
}
