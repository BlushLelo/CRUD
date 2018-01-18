package com.crud.example.CRUD.user.gateways.controllers;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.crud.example.CRUD.config.AbstractComponentTest;
import com.crud.example.CRUD.user.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class UserControllerTest extends AbstractComponentTest {

    private static final String API_END_POINT = "/users";

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;


    @Autowired
    private UserController userController;

    @Autowired
    private MongoTemplate mongoTemplate;


    @BeforeClass
    public static void setUpClass() {
        FixtureFactoryLoader.loadTemplates("com.crud.example.CRUD");
    }
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mongoTemplate.dropCollection("users");
        mockMvc = standaloneSetup(userController).build();
        objectMapper = new ObjectMapper();
    }


    @Test
    public void createUserWithSuccess() throws Exception {
        //Dado uma base de dados vazia

        //Retornar 201 (CREATED) ao receber um usuário válido
        User user = Fixture.from(User.class).gimme("valid");

        //Converter user para JSON
        String json = objectMapper.writeValueAsString(user);

        //Quando realizo um post
        MvcResult result = mockMvc.perform(post(API_END_POINT).contentType(APPLICATION_JSON)
                .content(json)).andReturn();

        String body = result.getResponse().getContentAsString();

        User resultBody = objectMapper.readValue(body, User.class);

        assertEquals(CREATED.value(), result.getResponse().getStatus());
        assertTrue(resultBody.getId() != null);
        assertTrue(resultBody.getEmail().equals("joaooctf@gmail.com"));
        assertTrue(resultBody.getName().equals("João"));
    }

}
