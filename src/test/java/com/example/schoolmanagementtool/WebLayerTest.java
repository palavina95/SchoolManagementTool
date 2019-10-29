package com.example.schoolmanagementtool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebLayerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testCourses() throws Exception {
		 mockMvc.perform( MockMvcRequestBuilders
			      .get("/courses")
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").exists()); //We have courses in the restAPI
	}
	
	@Test
	public void testStudents() throws Exception {
		 mockMvc.perform( MockMvcRequestBuilders
			      .get("/students")
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").exists())
			      .andExpect(MockMvcResultMatchers.jsonPath("$[1].firstName").isString()); //We have a student with is 1
	}
	
}
