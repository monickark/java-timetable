package com.havila.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.havila.pojo.CourseClass;
import com.havila.pojo.Schedule;

public interface IGenerateTimeTable {
	public ArrayList<Schedule> start();
	public Schedule makeNewFromPrototype(Boolean setupOnly);
	//public void calculateFitness(Schedule sch);
	public void insertChromosomes(Algorithm al);
}
