package com.crud.example.CRUD.user.usecases;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.crud.example.CRUD.user.domain.User;
import com.crud.example.CRUD.user.gateways.database.UserGateway;
import com.crud.example.CRUD.user.usecases.CreateUser;
import com.crud.example.CRUD.user.usecases.SaveUser;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateUserTest {

    @Mock
    UserGateway userGateway;

    @InjectMocks
    CreateUser createUser;


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

        //Then i call the method save 1 time
        verify(userGateway, times(0)).save(result);

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
