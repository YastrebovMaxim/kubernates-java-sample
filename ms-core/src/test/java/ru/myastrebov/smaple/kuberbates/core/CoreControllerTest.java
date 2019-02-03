package ru.myastrebov.smaple.kuberbates.core;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author m.yastrebov
 */
class CoreControllerTest {

    private MockMvc mvc = MockMvcBuilders
            .standaloneSetup(CoreController.class)
            .build();

    @Test
    void shouldSuccessPing() throws Exception {
        String randomString = UUID.randomUUID().toString();
        mvc.perform(get("/api/random/" + randomString))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.randomString", notNullValue()))
                .andExpect(jsonPath("$.randomInt", notNullValue()));
    }
}