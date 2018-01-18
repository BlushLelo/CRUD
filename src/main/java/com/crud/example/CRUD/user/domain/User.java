package com.crud.example.CRUD.user.domain;

import com.crud.example.CRUD.user.gateways.database.UserGateway;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    String id;

    String name;

    String email;

    private List<Error> errors;

    public UserGateway userGateway;
}
