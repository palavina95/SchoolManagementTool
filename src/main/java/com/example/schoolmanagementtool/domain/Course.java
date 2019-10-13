package com.example.schoolmanagementtool.domain;

public class Course {
	private long id;
	private String name;
	private String startTime;
	private String endTime;
	private String classRoom;
	private Boolean enrolled = false;
	private int grade;
	
	public Course() {
		this.id = 0;
		this.name = null;
		this.startTime = null;
		this.endTime = null;
		this.classRoom = null;
		this.grade = 0;
	}
	
	public Course(long id, String name, String startTime, String endTime, String classRoom) {
		this.id = id;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.classRoom = classRoom;
	}
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Boolean getEnrolled() {
		return enrolled;
	}

	public void setEnrolled(Boolean enrolled) {
		this.enrolled = enrolled;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	@Override
    public String toString() {
        return String.format(
                "Course[id=%d, name='%s', startTime='%s', endTime='%s', classRoom='%s']",
                id, name, startTime, endTime, classRoom);
    }
	

}
