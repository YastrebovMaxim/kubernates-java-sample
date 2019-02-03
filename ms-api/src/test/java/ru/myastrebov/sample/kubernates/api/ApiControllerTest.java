package ru.myastrebov.sample.kubernates.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author m.yastrebov
 */
class ApiControllerTest {

    private MockMvc mvc = MockMvcBuilders
            .standaloneSetup(ApiController.class)
            .build();

    @Mock
    private RandomService randomService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldSuccessPing() throws Exception {
        String randomString = UUID.randomUUID().toString();
        mvc.perform(get("/api/ping/" + randomString))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, " + randomString + "! I am test-ms-api"));
    }


    @Test
    void shouldCallCoreMsForRandomGeneration() throws Exception {
        String randomStringValue = "randomStringValue";
        int randomLongValue = 111;

        when(randomService.generateFromString(anyString()))
                .thenReturn(new RandomDto(randomStringValue, randomLongValue));

        String parameter = "parameter";

        mvc.perform(get("/api/random/generate/" + parameter))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.randomString", is(randomStringValue)))
                .andExpect(jsonPath("$.randomInt", is(randomLongValue)));
    }
}