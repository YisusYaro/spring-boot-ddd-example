package com.ebitware.ehub.resources.port;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ebitware.ehub.resources.domain.Resource;
import com.ebitware.ehub.resources.helpers.ResourcesHelper;

@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest
class CreateResourceTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ResourcesHelper resourcesHelper;

    @Test
    void createResource() throws Exception {
        Resource resource = this.resourcesHelper.getUser();

        JSONObject json = new JSONObject();

        json.put("id", resource.getProperties().getId());

        MvcResult result = this.mvc.perform(MockMvcRequestBuilders
                .post("/resources")
                .content(json.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        assertEquals(result.getResponse().getStatus(), 200);
    }

}
