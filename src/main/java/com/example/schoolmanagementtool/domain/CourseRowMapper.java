package com.example.schoolmanagementtool.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CourseRowMapper implements RowMapper<Course>{
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course course = new Course();
		course.setName(rs.getString("course_name"));
		course.setStartTime(rs.getString("startTime"));
		course.setEndTime(rs.getString("endTime"));
		course.setClassRoom(rs.getString("classRoom"));
		course.setId(rs.getLong("course_id"));
		
		return course;
	}
}
