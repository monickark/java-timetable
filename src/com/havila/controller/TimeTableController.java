package com.havila.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.havila.business.IAlgorithmService;
import com.havila.business.IGenerateTimeTable;
import com.havila.pojo.Course;
import com.havila.pojo.CourseClass;
import com.havila.pojo.Schedule;
import com.havila.pojo.Professor;
import com.havila.pojo.StudentsGroup;
import com.havila.service.ITimeService;

@Controller
public class TimeTableController {

	@Autowired
	private ITimeService timeService;
	@Autowired
	private IAlgorithmService algo;
	@Autowired
	private IGenerateTimeTable generate;

		@RequestMapping(value = "/timeTableInput.htm", method = RequestMethod.GET)
	public ModelAndView timeTableInput(
			@ModelAttribute("inputTT") CourseClass courseCombined,
			HttpServletRequest request, ModelMap model) throws SQLException {
		System.out.println("application started");
		request.getServletContext().setAttribute("group",
				timeService.allList().getGroupList());
		request.getServletContext().setAttribute("prof",
				timeService.allList().getProfList());
		request.getServletContext().setAttribute("course",
				timeService.allList().getCourseList());
		ModelAndView mav = new ModelAndView("input");
		return mav;

	}
		@RequestMapping(value = "/generate.htm", method = RequestMethod.GET)
		public ModelAndView generate(
				@ModelAttribute("inputTT") CourseClass courseCombined,
				HttpServletRequest request, ModelMap model) throws SQLException {
		CourseClass cc = new CourseClass();
		StudentsGroup s = new StudentsGroup();
		s.setId(1);
		cc.setStudentGroup(s);
		int noOfStudentGroup = 2;
		 List<Schedule> schedule=generate.start();
		
		
		 //for ArraySlots Display
		
		  for(int singlechromosome=0;singlechromosome<schedule.size();singlechromosome
		  ++){ ArrayList<CourseClass>
		  slots[]=schedule.get(singlechromosome).get_slots(); for(int
		  slotArray=0;slotArray<slots.length;slotArray++){
		  ArrayList<CourseClass> courseSlot=slots[slotArray];
		  //.get(slotArray); //System.out.println("C id "+courseSlot.getId());
		  System.out.println("Serial No "+slotArray);
		  System.out.println("C Student id "
		  +courseSlot.get(slotArray).getStudentGroup().getId());
		  System.out.println("C Course id "+courseSlot.get(slotArray).getCourse().getId());
		  System
		  .out.println("C Professor id "+courseSlot.get(slotArray).getProf
		  ().getId());
		  System.out.println("C Duration "+courseSlot.get(slotArray
		  ).getDurationOfeachCourse());
		  System.out.println("C Required lab "+courseSlot
		  .get(slotArray).getRequiredLabOrNot());
		  System.out.println("C No of classes per week "
		  +courseSlot.get(slotArray).getCourse().getId());
		  System.out.println("************************"); }
		  
		  }
		 

		// for HashMap display

		
		 for(int
		  singlechromosome1=0;singlechromosome1<schedule.size();singlechromosome1
		 ++){ Map<Integer,CourseClass>
		  classes=schedule.get(singlechromosome1).get_classes(); for
		  (Map.Entry<Integer, CourseClass> entry : classes.entrySet()) {
		  
		  System.out.println("Key = " + entry.getKey() + ", " +
		  " H Student id = " + entry.getValue().getStudentGroup().getId()+
		  " H Course id = "+entry.getValue().getCourse().getId()+
		  " H Professor id = "+entry.getValue().getProf().getId()+
		  " H Duration = "+entry.getValue().getDurationOfeachCourse()+
		  " H Requried Lab = "+entry.getValue().getRequiredLabOrNot()+
		  " H No Of Classes Per Week = "
		  +entry.getValue().getNoOfClassesPerWeek());
		  
		  } }
		

			ModelAndView mav = new ModelAndView("input");
			return mav;

		}

	@RequestMapping(value = "/dispTTPage.htm", method = RequestMethod.GET)
	public ModelAndView displayTimeTablePage(
			@ModelAttribute("courseClass") CourseClass course,
			HttpServletRequest request) throws SQLException {
		ModelAndView model = new ModelAndView("viewTT");
		request.getServletContext().setAttribute("group",
				timeService.allList().getGroupList());
		request.getServletContext().setAttribute("prof",
				timeService.allList().getProfList());
		request.getServletContext().setAttribute("course",
				timeService.allList().getCourseList());
		return model;

	}

	@RequestMapping(value = "/displayTT.htm", method = RequestMethod.POST)
	public ModelAndView displayTimeTable(
			@ModelAttribute("courseClass") CourseClass course, ModelMap model,
			HttpServletRequest request) throws SQLException {
		System.out.println("Inside displayTimeTable Post method");
		List<CourseClass> courseClassList = timeService
				.generatedTimeTableDatas(course);
		System.out.println("Returned from Timeservice.generatedTimeTableDatas Method to timeTableController.displayTimeTable");
		System.out.println("NetResult:"+courseClassList.toString());
		List<CourseClass> secondaryTimeTableList=timeService.optionalSubjectTimeTable(course);
		
		try{
		model.addAttribute("courseClassList", courseClassList);
		model.addAttribute("secondaryDetails", secondaryTimeTableList);
		}catch(NullPointerException ne){			
		}
		ModelAndView mv = new ModelAndView("viewTT");
		return mv;

	}

	@RequestMapping(value = "/displayProfessorTT.htm", method = RequestMethod.POST)
	public ModelAndView displayProfessorTimeTable(
			@ModelAttribute("courseClass") CourseClass course, ModelMap model) throws SQLException {

		List<CourseClass> professorTTCourseClass = timeService.generateProfessorTimeTable(course);
		System.out.println("professor list :"+professorTTCourseClass);
		model.addAttribute("profCCList", professorTTCourseClass);
		ModelAndView modelAndView = new ModelAndView("viewTT");
		return modelAndView;

		
	}

	@RequestMapping(value = "/addDetails.htm", method = RequestMethod.POST)
	public ModelAndView addDetails(
			@ModelAttribute("inputTT") CourseClass courseCombined,
			ModelMap model) {
		ModelAndView mv = new ModelAndView("input");
		timeService.addCombinationDetails(courseCombined);
		model.addAttribute("display", "Your data stored successfully");
		StudentsGroup sg = new StudentsGroup();
		sg.setId(1);

		courseCombined.setStudentGroup(sg);
		Course course = new Course();
		course.setId(1);
		courseCombined.setCourse(course);
		Professor pro = new Professor();
		pro.setId(1);
		courseCombined.setProf(pro);
		courseCombined.setDurationOfeachCourse(1);
		courseCombined.setRequiredLabOrNot("N");
		courseCombined.setNoOfClassesPerWeek(1);

		return mv;
	}
}
