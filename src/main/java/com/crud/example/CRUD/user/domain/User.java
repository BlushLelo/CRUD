package com.crud.example.CRUD.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection ="Users")
public class User {

    @Id
    private int id;

    private String nome;
}
