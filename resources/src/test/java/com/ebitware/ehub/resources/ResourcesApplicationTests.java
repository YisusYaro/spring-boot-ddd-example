package com.ebitware.ehub.resources;

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
class ResourcesApplicationTests {
    @Autowired
    MockMvc mvc;

    @Test
    void contextLoads() throws Exception {
        MvcResult result = this.mvc.perform(MockMvcRequestBuilders
                .get("/resources")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        System.out.println("〽️: " + result.getResponse().getContentAsString());
        System.out.println("〽️: " + result.getResponse().getStatus());
    }

}
