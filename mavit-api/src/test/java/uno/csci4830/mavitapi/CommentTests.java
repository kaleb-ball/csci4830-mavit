package uno.csci4830.mavitapi;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import uno.csci4830.mavitapi.model.Comment;
import uno.csci4830.mavitapi.payload.response.MessageResponse;
import uno.csci4830.mavitapi.service.CommentService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BackEndTests {

    @Autowired
    private MockMvc mvc;
    @Test
    public void commentServiceTest() {

    }
}