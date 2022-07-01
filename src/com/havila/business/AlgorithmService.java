package com.havila.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.havila.pojo.CourseClass;
import com.havila.pojo.Schedule;
import com.havila.pojo.StudentsGroup;
import com.havila.service.ITimeService;


@Service
public class AlgorithmService implements IAlgorithmService{
	@Autowired
	ITimeService timeService;
    ArrayList<CourseClass> slots=new ArrayList<CourseClass>();
	List<Integer> dayCount=new ArrayList<Integer>();
	ArrayList<CourseClass> randomElement=new ArrayList<CourseClass>();
	HashMap<Integer,CourseClass> nextDayStarting=new HashMap<Integer,CourseClass>();	
	
	public List<CourseClass> addCourseClassGroupByStudentGroup(CourseClass courseClass){
		List<CourseClass> courses=  timeService.getWholeList();
		List<CourseClass> studentGroupAndCourse=new ArrayList<CourseClass>();
		//courseClass.getStudentGroup();
		for(CourseClass c:courses){
			if((c.getStudentGroup().getId())==(courseClass.getStudentGroup().getId())){
				studentGroupAndCourse.add(c);
			}
		}	
		return studentGroupAndCourse; 
	}
	
	
	//Formation of chromosome
	public List<Schedule> formChromosomes(){		
		
		CourseClass randomlySelectedCourseClass=null;
		int randomDay=5;
		int randomPeriod=9;
		int randomStudentGroup=1;
		int randomSlot=0;
		List<Schedule> listSchedule=new ArrayList<Schedule>();		
		int periodCounter=1;
		for(int chromosome=0;chromosome<1;chromosome++){
			System.out.println("chromosome"+chromosome);
		Schedule s=new Schedule();
		Random random=new Random();
		CourseClass course=new CourseClass();
		for(int day=1;day<=5;day++){			
			System.out.println("Dayyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"+day);
			for(int studentGroup=1;studentGroup<=1;studentGroup++){	
				System.out.println("*********");
				System.out.println("studentgroupppppppppppppppppp"+studentGroup);
				StudentsGroup sg=new StudentsGroup();
				sg.setId(studentGroup);
				course.setStudentGroup(sg);
				
				//for(int period=periodCounter;period<periodCounter+9;period++){
					for(int period=1;period<=9;period++){
				System.out.println("period+++++++++++++++");
					List<CourseClass> courseClassForEachSlot=addCourseClassGroupByStudentGroup(course);
					for(int count=0;count<courseClassForEachSlot.size();count++){
						
						CourseClass singleCourseClass=courseClassForEachSlot.get(count);
						System.out.println("singleCourseClass"+singleCourseClass.getNoOfClassesPerWeek());
						for(int counter=singleCourseClass.getNoOfClassesPerWeek();counter<=0;counter--){
							System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
							randomDay=random.nextInt(randomDay);
							randomPeriod=random.nextInt(randomPeriod);
							 randomStudentGroup=random.nextInt(randomStudentGroup);
							 randomSlot=randomDay*randomPeriod*randomStudentGroup;
							 randomElement.add(randomSlot, singleCourseClass);		
							 nextDayStarting.put(randomSlot, singleCourseClass);
							// singleCourseClass.setNoOfClassesPerWeek(singleCourseClass.getNoOfClassesPerWeek()-1);
							 System.out.println("Period "+period+";Course "+singleCourseClass.getCourse().getId()+
										";Teacher "+singleCourseClass.getProf().getId()+
										";StudentGroup "+singleCourseClass.getStudentGroup().getId()+";Class per week Remaining"+counter);	
					
						}
						
					}
					
					
					/*List<CourseClass> copyOfCourseClassForEachSlot=courseClassForEachSlot;				
					randomlySelectedCourseClass=courseClassForEachSlot.get(random.nextInt(courseClassForEachSlot.size()));
					System.out.println(randomlySelectedCourseClass.getNoOfClassesPerWeek());
					while((randomlySelectedCourseClass.getNoOfClassesPerWeek() == 0)){						
						randomlySelectedCourseClass=courseClassForEachSlot.get(random.nextInt(courseClassForEachSlot.size()));
						System.out.println("second number"+randomlySelectedCourseClass.getNoOfClassesPerWeek());
					}
						randomlySelectedCourseClass=courseClassForEachSlot.get(random.nextInt(courseClassForEachSlot.size()));
								courseClassForEachSlot.get(courseClassForEachSlot.indexOf((randomlySelectedCourseClass))).setNoOfClassesPerWeek(courseClassForEachSlot.get(courseClassForEachSlot.indexOf((randomlySelectedCourseClass))).getNoOfClassesPerWeek()-1);
								
										
							randomElement.add(randomlySelectedCourseClass);
							if((randomElement.size()>1)){
								if(randomElement.get(randomElement.size()-2)==randomElement.get(randomElement.size()-1)){
									nextDayStarting.put(randomElement.size()-2,randomElement.get(randomElement.size()-2));
								}else{
									nextDayStarting.put(randomElement.size()-2,randomElement.get(randomElement.size()-2));
									nextDayStarting.put(randomElement.size()-2,randomElement.get(randomElement.size()-1));
								}
									
							}else{
								nextDayStarting.put(randomElement.size()-1,randomElement.get(randomElement.size()-1));								
							}
				
							}*/
				periodCounter=periodCounter+9;
				   // slots.add(randomElement);						  			 
				  
				    
				   
			}
			
		//	dayCount.add(e);
			
			
			//nextDayStarting.put(randomElement.size(), randomElement.get(randomElement.size()-1));
			//System.out.println("NextDayStarting"+nextDayStarting.get(randomElement.size()));
		}
	//	s.set_slots(slots);
		listSchedule.add(s);
		// printTimeTable(listSchedule);
		}
		}
		return listSchedule;
		
	}
	
	public HashMap<Integer,CourseClass> returnNextDayStart(){
		return nextDayStarting;
	}
	
	
	
	
/*	
	//Check Fitness For Chromosomes-Constraint 1:One teacher should have one class at a timeb
	//   							Constraint 2:One studentGroup should not attend more than one subject at a time
	public void checkConstraint1(){
		System.out.println("inside check constraint");
		List<Schedule> listOfChromosomes=formChromosomes();
		List<Schedule> passedChromosome=new ArrayList<Schedule>();
		List<ArrayList<CourseClass>> listOfDayWithPeriodFromOneCh=new ArrayList<ArrayList<CourseClass>>();
		int singleChromosome=0;
		int forOneday=0;
		int score=0;
		int period=0;
		int count=0;
		int counter=0;
		int professorConstraint=0;
		int studentGroupConstraint=0;
		int innercountforPeriodComparison;
		for(singleChromosome=0;singleChromosome<listOfChromosomes.size();singleChromosome++){
		Schedule oneChromosomeFromList=listOfChromosomes.get(singleChromosome);
		 listOfDayWithPeriodFromOneCh=oneChromosomeFromList.get_slots();	
		// System.out.println("dayAndPeriod"+listOfDayWithPeriodFromOneCh.size());
			for(forOneday=0;forOneday<listOfDayWithPeriodFromOneCh.size();forOneday++){
			//	System.out.println("dayValue is"+forOneday);
				ArrayList<CourseClass> forSingleSlot=listOfDayWithPeriodFromOneCh.get(forOneday);
				//System.out.println("courseC"+courseC);
			//	System.out.println("size of courseC"+forSingleSlot.size());
				for(period=counter;period<(counter+8);period++){
					CourseClass course=forSingleSlot.get(period);
					for(innercountforPeriodComparison=0;innercountforPeriodComparison<=(counter+8);innercountforPeriodComparison++){
						CourseClass courseCompare= forSingleSlot.get(innercountforPeriodComparison);
						//for professor constraint
						if(course.getProf().getId()==courseCompare.getProf().getId()){
							professorConstraint=professorConstraint+1;
						}else{
							professorConstraint=professorConstraint-1;
						}
						//for student constraint
						if(course.getStudentGroup().getId()==courseCompare.getStudentGroup().getId()){
							studentGroupConstraint=studentGroupConstraint+1;
						}else{
							studentGroupConstraint=studentGroupConstraint-1;
						}
						
					}
					count=count+1;
					System.out.println("Count"+count);
					System.out.println("Course"+course.getCourse().get_id());
					System.out.println("Teacher"+course.getProf().getId());
					System.out.println("studentGroup"+course.getStudentGroup().getId());
					System.out.println("******************");
				}
				if(nextDayStarting.containsKey(period+1)){
					counter =period+1;
				}
				//counter=counter+9;
				
								
			}
			
			
			if((professorConstraint!=-1)&&(studentGroupConstraint!=-1)){
				score=score+1;
				passedChromosome.add(listOfChromosomes.get(singleChromosome));
				printTimeTable(passedChromosome);
			}
			
		}
		System.out.println("passedChromosome1"+passedChromosome.get(0));
		System.out.println("passedChromosome2"+passedChromosome.get(1));		
		
	
		
			}
	
*/	public void printTimeTable(List<Schedule> schedule){
		System.out.println("Inside print timetable"+schedule.size());
		int count=0;
		List<ArrayList<CourseClass>> dayAndPeriod=new ArrayList<ArrayList<CourseClass>>();
		int chromosome=0;
		int day=0;
		int period=0;
		int counter=0;
		int dayCount=0;
		for(chromosome=0;chromosome<schedule.size();chromosome++){	
			System.out.println("Chromosome"+schedule.size());
		Schedule sch=schedule.get(chromosome);
		/* dayAndPeriod=sch.get_slots();	
		 System.out.println("sch"+schedule.get(0).get_slots().get(0).size());
*/			//for(day=0;day<dayAndPeriod.size();day++){
		 //hfghg
		 for(day=dayCount;day<=dayCount+10;day++){
				System.out.println("day"+dayAndPeriod.size());
				ArrayList<CourseClass> courseC=dayAndPeriod.get(day);
				for(period=counter;period<=(counter+8);period++){
					System.out.println("period"+period);
					CourseClass course=courseC.get(period);
					count=count+1;
					/*System.out.println("Count:"+count);
					System.out.print(" Course:"+course.getCourse().get_id());
					System.out.print(" Teacher:"+course.getProf().getId());
					System.out.print(" studentGroup:"+course.getStudentGroup().getId());
					System.out.println("******************");*/
					
				}
				counter=counter+9;
											
			}
		 dayCount=dayCount+11;
		 
		}
		
		//return null;
	}



	

}
