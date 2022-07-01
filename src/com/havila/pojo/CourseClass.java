package com.havila.pojo;

import java.util.List;

public class CourseClass {
	private Professor prof;
	private Integer id;
	private Room room;
	private Integer slotForThisCourseClass;
	private Integer durationOfeachCourse;
	private Course course;
	private StudentsGroup studentGroup;
	private Integer noOfClassesPerWeek;
	private String requiredLabOrNot;
	
	public Integer getSlotForThisCourseClass() {
		return slotForThisCourseClass;
	}
	public void setSlotForThisCourseClass(Integer slotForThisCourseClass) {
		this.slotForThisCourseClass = slotForThisCourseClass;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Professor getProf() {
		return prof;
	}
	public void setProf(Professor prof) {
		this.prof = prof;
	}
	
	
	public Integer getNoOfClassesPerWeek() {
		return noOfClassesPerWeek;
	}
	public void setNoOfClassesPerWeek(Integer noOfClassesPerWeek) {
		this.noOfClassesPerWeek = noOfClassesPerWeek;
	}
	
	public Integer getDurationOfeachCourse() {
		return durationOfeachCourse;
	}
	public void setDurationOfeachCourse(Integer durationOfeachCourse) {
		this.durationOfeachCourse = durationOfeachCourse;
	}
	
	public StudentsGroup getStudentGroup() {
		return studentGroup;
	}
	public void setStudentGroup(StudentsGroup studentGroup) {
		this.studentGroup = studentGroup;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getRequiredLabOrNot() {
		return requiredLabOrNot;
	}
	public void setRequiredLabOrNot(String requiredLabOrNot) {
		this.requiredLabOrNot = requiredLabOrNot;
	}
	

	@Override
	public String toString() {
		return "CourseClass [prof=" + prof + ", id=" + id + ", room=" + room
				+ ", slotForThisCourseClass=" + slotForThisCourseClass
				+ ", course=" + course + ", studentGroup=" + studentGroup
				+ ", noOfClassesPerWeek=" + noOfClassesPerWeek
				+ ", requiredLabOrNot=" + requiredLabOrNot
				+ ", durationOfeachCourse=" + durationOfeachCourse + "]";
	}
	
	

	

}
