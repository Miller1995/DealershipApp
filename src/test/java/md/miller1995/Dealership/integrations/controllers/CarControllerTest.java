package md.miller1995.Dealership.integrations.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
@Transactional
@AutoConfigureTestDatabase
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    @Disabled
    void testShouldGetCarById() throws Exception {
        // initial is need  to create a car, after that getById -> need post request;
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/cars/{id}", 2)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andReturn();
    }

    @Test
    void testShouldFindAllCarsByModel() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/cars")
                .param("model", "A class")
                .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().is(200));
    }

    private String convertObjectToJsonString(Object response){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.findAndRegisterModules();
            String json = objectMapper.writeValueAsString(response);
            if (json.contains("logo")){
                log.info("Resulting JSON string: " + json);
            }
            return json;
        } catch (JsonProcessingException e) {
            log.error("Error processing input ", e.getMessage());
        }
        return null;
    }
}