package com.example.schoolmanagementtool.domain;

import java.util.List;

public interface EnrollmentsDAO {
	
	public List<Enrollments> findAllfromCourse(long course_id);
	
	public List<Enrollments> findAllfromStudent(long student_id);
	
	public void save (Enrollments enrollements);
	
	public void deleteFromCourse(long course_id);
	
	public void deleteFromStudent(long student_id);
	
	public void deleteFromDetails(long course_id, long student_id);
	
	public void deleteNoGrades(long student_id);
}
