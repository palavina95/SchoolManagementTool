package com.example.schoolmanagementtool.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDAOImpl implements CourseDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void save(Course course) {
		String sql = "insert into course(course_name, startTime, endTime, classRoom) values(?,?,?,?)";
		Object[] parameters = new Object[] { course.getName(),
				course.getStartTime(), course.getEndTime(), course.getClassRoom() };

		jdbcTemplate.update(sql, parameters);

	}

	public Course findOne(long id) {
		String sql = "select course_id, course_name, startTime, endTime, classRoom from course where course_id = ?";
		Object[] parameters = new Object[] { id };
		RowMapper<Course> mapper = new CourseRowMapper();
		Course course = jdbcTemplate.queryForObject(sql, parameters, mapper);
		return course;

	}

	public List<Course> findAll() {

		String sql = "select course_id, course_name, startTime, endTime, classRoom from course";
		RowMapper<Course> mapper = new CourseRowMapper();
		List<Course> courses = jdbcTemplate.query(sql, mapper);

		return courses;
	}

	@Override
	public void delete(long id) {
		String sql = "delete from course where course_id = ?";
		Object[] parameters = new Object[] { id };
		
		jdbcTemplate.update(sql, parameters);
		
	}
	
	public void update(Course course) {
		String sql = "update course SET course_name=?, startTime=?, endTime=?, classRoom=? WHERE course_id = ?";
		Object[] parameters = new Object[] { course.getName(), course.getStartTime(), course.getEndTime(), course.getClassRoom(), course.getId() };

		jdbcTemplate.update(sql, parameters);

	}
}
