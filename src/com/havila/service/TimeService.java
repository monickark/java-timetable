package com.havila.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.havila.business.GenerateTimeTable;
import com.havila.dao.ITimeTable;
import com.havila.pojo.Course;
import com.havila.pojo.CourseClass;

import com.havila.pojo.DropListItems;
import com.havila.pojo.Professor;
import com.havila.pojo.Schedule;
import com.havila.pojo.StudentsGroup;
@Service
public class TimeService implements ITimeService {
	@Autowired
	private ITimeTable timeTable;
	GenerateTimeTable generate=new GenerateTimeTable();
	int noOfStudentGroup=28;	
	
	
	
	
	
	
	
	@Override
	public DropListItems allList() throws SQLException {
		// TODO Auto-generated method stub
		List<Course> courseList=new ArrayList<Course>();
		List<StudentsGroup> sgList=new ArrayList<StudentsGroup>();
		List<Professor> profList=new ArrayList<Professor>();
		DropListItems dropList = new DropListItems();
		HashMap<Integer,Course> courseMap=timeTable.getCourses();
		for(int counter=0;counter<courseMap.size();counter++){
			courseList.add(courseMap.get(counter));			
		}
		
		
	
		HashMap<Integer,StudentsGroup> sgMap=timeTable.getStudentGroup();
		for(int counter=0;counter<sgMap.size();counter++){
			sgList.add(sgMap.get(counter));			
		}
		
		HashMap<Integer,Professor> profMap=timeTable.getProfessor();
		for(int counter=0;counter<profMap.size();counter++){
			 profList.add(profMap.get(counter));						
		}
	
		dropList.setCourseList(courseList);
		dropList.setGroupList(sgList);
		dropList.setProfList( profList);
		return dropList;
	}

	
	@Override
	public void addCombinationDetails(CourseClass combination) {
		timeTable.insertDetails(combination);		
	}

	@Override
	public List<CourseClass> getWholeList() {
		// TODO Auto-generated method stub
		return timeTable.getAllList();
		
	}

	public ArrayList<Schedule> createChromosome(){
		return generate.start();
	}

	@Override
	public List<CourseClass> generatedTimeTableDatas(CourseClass cc) throws SQLException {
		System.out.println("Inisde Timeservice.generatedTimeTableDatas Method");
		List<CourseClass> courseClassList=timeTable.displayTimeTable(cc);
		System.out.println("Returned to Timeservice.generatedTimeTableDatas Method from timeTable.displayTimeTable");
		return addDescriptionIntoTimeTableList(courseClassList);
		/*List<StudentsGroup> studentGroup = allList().getGroupList();
		List<Professor> professorGroup = allList().getProfList();
		List<Course> courseGroup = allList().getCourseList();
		for (CourseClass courseC : courseClassList) {
			int profId = courseC.getProf().getId();
			int studId = courseC.getStudentGroup().getId();
			int courseId = courseC.getCourse().get_id();
			StudentsGroup sg = studentGroup.get(studId);
			courseC.setStudentGroup(sg);
			Professor pro = professorGroup.get(profId);
			courseC.setProf(pro);
			Course c = courseGroup.get(courseId);
			System.out.println("course name :"+c.getSubject_name());
			courseC.setCourse(c);
		}*/
	
	
	}

	public List<CourseClass> addDescriptionIntoTimeTableList(List<CourseClass> courseClassList) throws SQLException{
		System.out.println("Inside addDescriptionIntoTimeTableList method from Timeservice class");
		System.out.println("Gwtting list of student group professor group course group");
		List<StudentsGroup> studentGroup = allList().getGroupList();
		List<Professor> professorGroup = allList().getProfList();
		List<Course> courseGroup = allList().getCourseList();
		System.out.println("courseGroup size :"+courseGroup.size());
		System.out.println("Iterating input course class list");
		for (CourseClass courseC : courseClassList) {
			int profId = courseC.getProf().getId();
			int studId = courseC.getStudentGroup().getId();
			int courseId = courseC.getCourse().getId();
			System.out.println("Setting student group, course , professor desription to iterating object ");
			StudentsGroup sg = studentGroup.get(studId);
			courseC.setStudentGroup(sg);
			Professor pro;
			if(profId!=1000){
				 pro = professorGroup.get(profId);
				
			}else{
				pro=null;
			}
			
			courseC.setProf(pro);
			Course c = courseGroup.get(courseId);			
			courseC.setCourse(c);
			System.out.println("State of courseclass object after looping and setting description"+courseC.toString());
		
		}
		
		return courseClassList;
		
	}
	
	

	@Override
	public List<CourseClass> generateProfessorTimeTable(CourseClass cc) throws SQLException {
		// TODO Auto-generated method stub		
		 ArrayList<CourseClass> course=new ArrayList<CourseClass>();
		int daySize=Schedule.DAY_HOURS*noOfStudentGroup;
		List<CourseClass> courseClassList=timeTable.getProfessorTimeTable(cc);
		List<CourseClass> listOfCourseClass=addDescriptionIntoTimeTableList(courseClassList);
		/*List<StudentsGroup> studentGroup = allList().getGroupList();
		List<Professor> professorGroup = allList().getProfList();
		List<Course> courseGroup = allList().getCourseList();
		for (CourseClass courseC : courseClassList) {
			int profId = courseC.getProf().getId();
			int studId = courseC.getStudentGroup().getId();
			int courseId = courseC.getCourse().get_id();
			StudentsGroup sg = studentGroup.get(studId);
			courseC.setStudentGroup(sg);
			Professor pro = professorGroup.get(profId);
			courseC.setProf(pro);
			Course c = courseGroup.get(courseId);
			System.out.println("course name :"+c.getSubject_name());
			courseC.setCourse(c);
		}
		*/
		
		
//		System.out.println("professor course class list size from database :"+courseClassList.size());
		//Initialize course list
		for(int counter=0;counter<45;counter++){
			course.add(null);	
		}
	//	System.out.println("professor course class list size from service layer :"+course.size());
		for(int index=0;index<listOfCourseClass.size();index++){
			CourseClass courseClass=listOfCourseClass.get(index);
			int slot=courseClass.getSlotForThisCourseClass();
		//	System.out.println("slot in course class :"+slot);
			int day=slot/daySize;
			int time=slot%daySize;
			int period=time%Schedule.DAY_HOURS;
			int positionInList=(day*Schedule.DAY_HOURS)+(period);			
			/*System.out.println("day :"+(day));
			System.out.println("period :"+(period));
			System.out.println("position in list : "+positionInList);*/
			System.out.println("position in list for each courseclass : "+positionInList);
			course.set(positionInList, courseClass);		
		}
		/*System.out.println("professor course class list size from service layer final :"+course.size());
		System.out.println("list from data base :"+courseClassList);
		System.out.println("list from service :"+course);*/
		return course;
		
	}


	@Override
	public List<CourseClass> optionalSubjectTimeTable(CourseClass cc) {
		System.out.println("Inside OptionalSubjectTimeTable Method");
		return timeTable.secondaryDataForTimeTable(cc);		
	}


}
