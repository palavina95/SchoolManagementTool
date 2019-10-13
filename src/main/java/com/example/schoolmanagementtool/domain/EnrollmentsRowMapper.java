package com.example.schoolmanagementtool.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EnrollmentsRowMapper implements RowMapper<Enrollments>{
	public Enrollments mapRow(ResultSet rs, int rowNum) throws SQLException {
		Enrollments enrollments = new Enrollments();
		enrollments.setStudent_id(rs.getLong("student_id"));
		enrollments.setCourse_id(rs.getLong("course_id"));
		enrollments.setGrade(rs.getInt("grade"));
		
		return enrollments;
	}
}
