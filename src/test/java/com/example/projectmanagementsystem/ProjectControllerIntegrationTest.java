package com.example.projectmanagementsystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ProjectControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateProject() throws Exception {
        String json = "{ \"name\": \"Test Project\", \"description\": \"Test Description\", \"startDate\": \"2024-04-28\", \"endDate\": \"2024-05-28\" }";

        mockMvc.perform(MockMvcRequestBuilders.post("/projects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testGetProjectById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/projects/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound()) // Expecting a 404 status
                .andExpect(MockMvcResultMatchers.content().string("Project not found")); // Assert the response body
    }

    @Test
    void testGetAllProjects() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/projects"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void testUpdateProject() throws Exception {
        String json = "{ \"name\": \"Updated Test Project\", \"description\": \"Updated Test Description\", \"startDate\": \"2024-04-28\", \"endDate\": \"2024-05-28\" }";

        mockMvc.perform(MockMvcRequestBuilders.put("/projects/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testDeleteProject() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/projects/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}