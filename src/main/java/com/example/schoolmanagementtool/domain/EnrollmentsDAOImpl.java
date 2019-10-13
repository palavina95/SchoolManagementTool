package com.example.schoolmanagementtool.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EnrollmentsDAOImpl implements EnrollmentsDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Enrollments> findAllfromCourse(long course_id) {
		String sql = "select student_id, course_id, grade from enrollments where course_id = ?";
		Object[] parameters = new Object[] { course_id };
		RowMapper<Enrollments> mapper = new EnrollmentsRowMapper();
		List<Enrollments> enrolledCourses = jdbcTemplate.query(sql,parameters,mapper);

		return enrolledCourses;
	}

	@Override
	public List<Enrollments> findAllfromStudent(long student_id) {
		String sql = "select student_id, course_id, grade from enrollments where student_id = ?";
		Object[] parameters = new Object[] { student_id };
		RowMapper<Enrollments> mapper = new EnrollmentsRowMapper();
		List<Enrollments> enrolledCourses = jdbcTemplate.query(sql,parameters,mapper);

		return enrolledCourses;
	}

	@Override
	public void save(Enrollments enrollements) {
		String sql = "insert into enrollments(student_id,course_id,grade) values(?,?,?)";
		Object[] parameters = new Object[] { enrollements.getStudent_id(),
				enrollements.getCourse_id(), enrollements.getGrade() };

		jdbcTemplate.update(sql, parameters);
	}

	@Override
	public void deleteFromCourse(long course_id) {
		String sql = "delete from enrollments where course_id = ?";
		Object[] parameters = new Object[] { course_id };
		
		jdbcTemplate.update(sql, parameters);
		
	}

	@Override
	public void deleteFromStudent(long student_id) {
		String sql = "delete from enrollments where student_id = ?";
		Object[] parameters = new Object[] { student_id };
		
		jdbcTemplate.update(sql, parameters);
	}
	
	@Override
	public void deleteFromDetails(long course_id, long student_id) {
		String sql = "delete from enrollments where course_id = ? and student_id = ?";
		Object[] parameters = new Object[] { course_id, student_id };
		
		jdbcTemplate.update(sql, parameters);
	}
	
	@Override
	public void deleteNoGrades(long student_id) {
		String sql = "delete from enrollments where grade = 0 and student_id = ?";
		Object[] parameters = new Object[] { student_id };
		
		jdbcTemplate.update(sql, parameters);
	}
}
