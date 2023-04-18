package com.ebitware.ehub.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest
class HealthCheckTest {
    @Autowired
    MockMvc mvc;

    @Test
    void getHealthCheck() throws Exception {
        MvcResult result = this.mvc.perform(MockMvcRequestBuilders
				.get("/")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andReturn();

		assertEquals(result.getResponse().getContentAsString(), "Server is working");
    }

}
