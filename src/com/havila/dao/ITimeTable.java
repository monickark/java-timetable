package com.havila.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.havila.business.Algorithm;
import com.havila.pojo.Course;
import com.havila.pojo.CourseClass;

import com.havila.pojo.Professor;
import com.havila.pojo.StudentsGroup;

public interface ITimeTable {
	public HashMap<Integer,Professor> getProfessor() throws SQLException;
	public HashMap<Integer,StudentsGroup> getStudentGroup() throws SQLException;
	public HashMap<Integer,Course> getCourses() throws SQLException;
	public void insertDetails(CourseClass cc);
	public List<CourseClass> getAllList();
	//public void insChromosome(final Algorithm a,List<CourseClass> course);
	public void insChromosome(final Algorithm a);
	public void insertCrossoverOffspringChromosome(final Algorithm a);
	public void insertMutationOffspringChromosome(final Algorithm a);
	public void deleteChromosomes();
	public void deleteCrossoverOffspring();
	public void deleteMutationOffspring();
	public List<CourseClass> displayTimeTable(CourseClass cc);
	public List<CourseClass> getProfessorTimeTable(CourseClass cc);
	public List<CourseClass> secondaryDataForTimeTable(CourseClass cc);
}
