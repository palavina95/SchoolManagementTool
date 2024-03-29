package com.example.schoolmanagementtool.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {  // Impl = Implementation class

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void save(Student student) {
		String sql = "insert into student(first_name, last_name) values(?,?)";
		Object[] parameters = new Object[] { student.getFirstName(),
				student.getLastName() };

		jdbcTemplate.update(sql, parameters);
	}

	public Student findOne(long id) {
		String sql = "select student_id, first_name, last_name from student where student_id = ?";
		Object[] parameters = new Object[] { id };
		RowMapper<Student> mapper = new StudentRowMapper();

		Student student = jdbcTemplate.queryForObject(sql, parameters, mapper);
		return student;

	}

	public List<Student> findAll() {

		String sql = "select student_id, first_name, last_name from student";
		RowMapper<Student> mapper = new StudentRowMapper();
		List<Student> students = jdbcTemplate.query(sql, mapper);

		return students;
	}

	@Override
	public void delete(long id) {
		String sql = "delete from student where student_id = ?";
		Object[] parameters = new Object[] { id };
		
		jdbcTemplate.update(sql, parameters);
		
	}
	
	public void update(Student student) {
		String sql = "update student SET first_name=?, last_name=? WHERE student_id = ?";
		Object[] parameters = new Object[] { student.getFirstName(),
				student.getLastName(),student.getId() };

		jdbcTemplate.update(sql, parameters);

	}
}

