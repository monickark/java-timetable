package com.havila.pojo;

import java.util.List;

public class DropListItems {
	List<Professor> profList;
	public List<Professor> getProfList() {
		return profList;
	}
	public void setProfList(List<Professor> profList) {
		this.profList = profList;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	public List<StudentsGroup> getGroupList() {
		return groupList;
	}
	public void setGroupList(List<StudentsGroup> groupList) {
		this.groupList = groupList;
	}
	List<Course> courseList;
	List<StudentsGroup> groupList;
	
	
	

}
