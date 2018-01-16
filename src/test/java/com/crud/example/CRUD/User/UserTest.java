package com.crud.example.CRUD.User;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.crud.example.CRUD.user.User;
import com.crud.example.CRUD.user.usecases.CreateUser;
import com.crud.example.CRUD.user.usecases.SaveUser;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class UserTest {

    CreateUser createUser = new CreateUser();

    @BeforeClass
    public static void setupClass(){
        FixtureFactoryLoader.loadTemplates("com.crud.example.CRUD");
    }

    @Test
    public void shouldValidateInvalidUserInfo() throws Exception {
        //GIVEN a user with invalid infos
        User user = Fixture.from(User.class).gimme("invalid");

        //THEN i try to create it
        User result = createUser.execute(user);

        //Should return a list of error's
        assertNotNull("Não pode ser nulo", result.getErrors());
        assertThat(result.getErrors(), hasSize(2));
        assertTrue(result.getErrors().stream().anyMatch(e ->
                e.getMessage() == "Name is mandatory") &&
                result.getErrors().stream().anyMatch(e ->
                        e.getMessage() == "Email is mandatory"));
    }

    @Test
    public void ShouldReturnUserWithoutErrors() throws Exception {
        //Given a valid user
        User user = Fixture.from(User.class).gimme("valid");

        //Then i try to save it
        User result = createUser.execute(user);

        SaveUser saveUser = new SaveUser();
        saveUser.execute(user);
    }
}
