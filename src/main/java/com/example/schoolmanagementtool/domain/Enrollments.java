package com.example.schoolmanagementtool.domain;

public class Enrollments {
	
	private long student_id;
	private long course_id;
	private int grade;
	
	public Enrollments(long student_id, long course_id,int grade) {
		this.student_id = student_id;
		this.course_id = course_id;
		this.grade = grade;
	}

	public Enrollments() {
	}

	public long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}

	public long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
    public String toString() {
        return String.format(
                "Enrollments[=student_id='%s', course_id='%s', grade='%s']",
                student_id, course_id, grade);
    }

}
