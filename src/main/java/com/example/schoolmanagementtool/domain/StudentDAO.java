package com.example.schoolmanagementtool.domain;

import java.util.List;

public interface StudentDAO {
	public void save(Student student);

	public Student findOne(long id); 

	public List<Student> findAll();
	
	public void delete(long id);
	
	public void update(Student student);
}
