package com.example.schoolmanagementtool.domain;

import java.util.List;

public interface CourseDAO {
	public void save(Course course);

	public Course findOne(long id); 

	public List<Course> findAll();
	
	public void delete(long id);
	
	public void update(Course course);
}
