package com.crud.example.CRUD.user.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class User {

    @Id
    String id;
}
