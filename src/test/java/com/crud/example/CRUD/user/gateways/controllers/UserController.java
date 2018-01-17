
import com.crud.example.CRUD.config.AbstractComponentTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class UserController extends AbstractComponentTest {

    private UserController userController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();
    }

}

