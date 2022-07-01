package com.havila.business;

import java.util.HashMap;
import java.util.List;

import com.havila.pojo.CourseClass;
import com.havila.pojo.Schedule;

public interface IAlgorithmService {

	public List<CourseClass>addCourseClassGroupByStudentGroup(CourseClass courseClass);
	public List<Schedule> formChromosomes();
	public HashMap<Integer,CourseClass> returnNextDayStart();
	//public void checkConstraint1();
	public void printTimeTable(List<Schedule> schedule);


}
