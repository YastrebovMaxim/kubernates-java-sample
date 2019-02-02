package ru.myastrebov.sample.kubernates.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author m.yastrebov
 */
@SpringBootTest
@AutoConfigureMockMvc
class ApiControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldSuccessPing() throws Exception {
        String randomString = UUID.randomUUID().toString();
        mvc.perform(MockMvcRequestBuilders.get("/api/ping/" + randomString))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, " + randomString + "! I am test-ms-api"));
    }
}