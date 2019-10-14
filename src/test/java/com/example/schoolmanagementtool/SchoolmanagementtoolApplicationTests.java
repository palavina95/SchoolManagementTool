package com.example.schoolmanagementtool;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.schoolmanagementtool.web.CourseController;
import com.example.schoolmanagementtool.web.StudentController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolmanagementtoolApplicationTests {

	@Autowired
	private StudentController controller1;
	
	@Autowired
	private CourseController controller2;
	
	@Test
	public void contextLoads() {
		assertThat(controller1).isNotNull();
		assertThat(controller2).isNotNull();
	}

}
