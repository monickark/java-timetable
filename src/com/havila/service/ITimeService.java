package com.havila.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.havila.pojo.Course;
import com.havila.pojo.CourseClass;
import com.havila.pojo.DropListItems;
import com.havila.pojo.Professor;
import com.havila.pojo.Schedule;
import com.havila.pojo.StudentsGroup;

public interface ITimeService {

	public DropListItems allList() throws SQLException;

	public void addCombinationDetails(CourseClass combination);

	public List<CourseClass> getWholeList();

	public ArrayList<Schedule> createChromosome();

	public List<CourseClass> generatedTimeTableDatas(CourseClass cc) throws SQLException;

	public List generateProfessorTimeTable(CourseClass cc) throws SQLException;
	
	
	public List<CourseClass> optionalSubjectTimeTable(CourseClass cc);

}
