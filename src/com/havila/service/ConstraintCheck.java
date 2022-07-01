package com.havila.service;

import java.util.Random;

import com.havila.pojo.CourseClass;

public class ConstraintCheck {
	
	
	
	
	// Returns TRUE if another class has one or overlapping student groups.
	public boolean GroupsOverlap(CourseClass c ){
		return false;
	}
	
	// Returns TRUE if another class has same professor.
	public boolean ProfessorOverlaps(CourseClass c ){
		//{ return *_professor == *c._professor; }
		return false;
	}
	
	// Returns TRUE if class requires computers in room.
	public boolean IsLabRequired() {
		Random r=new Random();
		
		return false;
	}



	

}
