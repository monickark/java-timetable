package com.havila.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
//import java.util.List;

import com.havila.business.Algorithm;
import com.havila.pojo.Course;
import com.havila.pojo.CourseClass;
import com.havila.pojo.Room;
import com.havila.pojo.Schedule;
import com.havila.pojo.Professor;
import com.havila.pojo.StudentsGroup;

@Repository
public class TimeTableDao implements ITimeTable {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public HashMap<Integer, Professor> getProfessor() throws SQLException {
		HashMap<Integer, Professor> prof = new HashMap<Integer, Professor>();
		String SELECT_ALL = "SELECT profId, name FROM professor p ;";

		List<Professor> profList = jdbcTemplate.query(SELECT_ALL,
				new ProfessorMapper());
		for (Professor p : profList) {
			prof.put(p.getId(), p);
		}

		return prof;
	}

	public HashMap<Integer, StudentsGroup> getStudentGroup()
			throws SQLException {
		HashMap<Integer, StudentsGroup> student = new HashMap<Integer, StudentsGroup>();
		String SELECT_ALL = "SELECT studentId, standard, section, combination FROM studentgroup s where delFlag!='Y';";

		List<StudentsGroup> groups = jdbcTemplate.query(SELECT_ALL,
				new StudentGroupMapper());
		for (StudentsGroup sg : groups) {
			student.put(sg.getId(), sg);
		}

		return student;
	}

	public HashMap<Integer, Course> getCourses() throws SQLException {
		HashMap<Integer, Course> course = new HashMap<Integer, Course>();
		String SELECT_ALL = "SELECT courseId, standard ,subjects FROM course c where delFlag!='Y' ;";

		List<Course> courses = jdbcTemplate.query(SELECT_ALL, new CourseMap());
		for (Course p : courses) {
			course.put(p.getId(), p);
		}
		return course;
	}

	public void insertDetails(CourseClass cc) {
		System.out.println("Course Classes:"+cc.toString());
		StringBuffer sb = new StringBuffer(
				"insert into combination(studentId," + "courseId,profId,"
						+ "duration,requiredLab,delFlag," + "noOfClasses)" + "values(");
		sb.append(cc.getStudentGroup().getId() + ",");
		sb.append(cc.getCourse().getId() + ",");
		sb.append(cc.getProf().getId() + ",");
		sb.append(cc.getDurationOfeachCourse() + ",'");
		sb.append(cc.getRequiredLabOrNot() + "',");
		sb.append("'N',");
		sb.append(cc.getNoOfClassesPerWeek() + ");");
		jdbcTemplate.update(sb.toString());

	}

	@Override
	public List<CourseClass> getAllList() {
		// (2-4-2013) String SELECT_ALL =
		// "select id, studentId, courseId, profId, duration, requiredLab, noOfClasses from combination where delFlag!='Y';";
		String SELECT_ALL = "select id, studentId, courseId, profId, duration, requiredLab, noOfClasses,roomId from combination where delFlag!='Y' order by duration DESC;";
		List<CourseClass> courses = jdbcTemplate.query(SELECT_ALL,
				new WholeListRowMapper());
		return courses;
	}

	/*
	 * @Override public void insChromosome(final Algorithm a) {
	 * deleteChromosomes(); String query=null; int countForChromosome=0;
	 * 
	 * 
	 * // System.out.println("chromosome size "+a.getChromosome().size());
	 * 
	 * for(final Schedule s:a.getChromosome()){
	 * 
	 * 
	 * 
	 * 
	 * query=
	 * "insert into chromosomes(chromosomeId, studentId, courseId, profId, duration, requiredLab, noOfClasses, fitnessValue,slot) values (?,?,?,?,?,?,?,?,?);"
	 * ; // System.out.println("After insert query");
	 * jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter(){ int
	 * count=0; int size=0;
	 * 
	 * @Override public int getBatchSize() {
	 * 
	 * // TODO Auto-generated method stub
	 * 
	 * for(Schedule sch:a.getOffspring()){
	 * 
	 * size=sch.get_slots().length; }
	 * 
	 * return size; }
	 * 
	 * @Override public void setValues(PreparedStatement ps, int index) throws
	 * SQLException {
	 * 
	 * 
	 * ArrayList<CourseClass>[] slot=s.get_slots();
	 * 
	 * 
	 * //System.out.println("index : "+index+","+slot[index].get(0).getCourse().
	 * getId());
	 * 
	 * ps.setInt(1,s.getChromosomeId());
	 * System.out.println("chromosome Id "+s.getChromosomeId());
	 * ps.setInt(2,slot[index].get(0).getStudentGroup().getId());
	 * 
	 * ps.setInt(3,slot[index].get(0).getCourse().getId());
	 * 
	 * ps.setInt(4, slot[index].get(0).getProf().getId());
	 * 
	 * ps.setInt(5,slot[index].get(0).getDurationOfeachCourse());
	 * 
	 * ps.setString(6,slot[index].get(0).getRequiredLabOrNot());
	 * 
	 * ps.setInt(7,slot[index].get(0).getNoOfClassesPerWeek());
	 * 
	 * ps.setFloat(8, s.get_fitness());
	 * 
	 * ps.setInt(9, index);
	 * 
	 * 
	 * // } } });
	 * 
	 * }
	 * 
	 * 
	 * @Override public void insChromosome(Algorithm a, List<CourseClass>
	 * course) { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * @Override public void deleteChromosomes() { String
	 * query="truncate chromosomes;"; jdbcTemplate.execute(query);
	 * 
	 * }
	 */

	@Override
	public void insertCrossoverOffspringChromosome(final Algorithm a) {

		deleteCrossoverOffspring();

		String query = null;
		int countForChromosome = 0;

		// System.out.println("chromosome size "+a.getChromosome().size());

		for (final Schedule s : a.getChromosome()) {

			countForChromosome = countForChromosome + 1;
			// final ArrayList<CourseClass>[] slot=s.get_slots();
			// Map<Integer,CourseClass> forKey=s.get_classes();
			/*
			 * final List<Integer> keyList=new ArrayList<Integer>();
			 * for(Map.Entry<Integer,CourseClass> map:forKey.entrySet()){
			 * keyList.add(map.getKey());
			 * 
			 * }
			 */

			// query="insert into offspring(chromosomeId, studentId, courseId, profId, duration, requiredLab, noOfClasses, fitnessValue,slot) values (?,?,?,?,?,?,?,?,?);";
			query = "insert into offspring(chromosomeId,studentId, courseId, profId, duration, requiredLab, noOfClasses, fitnessValue,slot,roomId) values (?,?,?,?,?,?,?,?,?,?);";
			// System.out.println("After insert query");
			jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
				int count = 0;
				int size = 0;

				@Override
				public int getBatchSize() {

					// TODO Auto-generated method stub

					for (Schedule sch : a.getChromosome()) {

						size = sch.get_slots().length;
					}
					// System.out.println("size "+size);
					return size;
				}

				@Override
				public void setValues(PreparedStatement ps, int index)
						throws SQLException {

					// System.out.println("index value :"+index);
					// Map<Integer,CourseClass> map=s.get_classes();
					ArrayList<CourseClass>[] slot = s.get_slots();

					// for(int
					// inner=keyList.get(index);inner==keyList.get(index);inner++){
					// for(int inner=0;inner<slot.length;inner++){
					// System.out.println("index : "+index);
					// System.out.println("index : "+index+","+slot[index].get(0).getCourse().getId());
					// ps.setInt(1,s.getOffSpringId());
					ps.setInt(1, s.getChromosomeId());

					ps.setInt(2, slot[index].get(0).getStudentGroup().getId());

					ps.setInt(3, slot[index].get(0).getCourse().getId());

					ps.setInt(4, slot[index].get(0).getProf().getId());

					ps.setInt(5, slot[index].get(0).getDurationOfeachCourse());

					ps.setString(6, slot[index].get(0).getRequiredLabOrNot());

					ps.setInt(7, slot[index].get(0).getNoOfClassesPerWeek());

					ps.setFloat(8, s.get_fitness());

					ps.setInt(9, index);

					ps.setInt(10, slot[index].get(0).getRoom().getId());

					// }
				}
			});
		}

	}

	@Override
	public void deleteCrossoverOffspring() {
		// TODO Auto-generated method stub
		String query = "truncate offspring;";
		jdbcTemplate.execute(query);

	}

	@Override
	public void insChromosome(final Algorithm a) {

		deleteChromosomes();

		String query = null;
		int countForChromosome = 0;

		// System.out.println("chromosome size "+a.getChromosome().size());

		for (final Schedule s : a.getChromosome()) {

			countForChromosome = countForChromosome + 1;
			// final ArrayList<CourseClass>[] slot=s.get_slots();
			// Map<Integer,CourseClass> forKey=s.get_classes();
			/*
			 * final List<Integer> keyList=new ArrayList<Integer>();
			 * for(Map.Entry<Integer,CourseClass> map:forKey.entrySet()){
			 * keyList.add(map.getKey());
			 * 
			 * }
			 */

			// query="insert into offspring(chromosomeId, studentId, courseId, profId, duration, requiredLab, noOfClasses, fitnessValue,slot) values (?,?,?,?,?,?,?,?,?);";
			query = "insert into chromosomes(chromosomeId,studentId, courseId, profId, duration, requiredLab, noOfClasses, fitnessValue,slot,roomId) values (?,?,?,?,?,?,?,?,?,?);";
			// System.out.println("After insert query");
			jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
				int count = 0;
				int size = 0;

				@Override
				public int getBatchSize() {

					// TODO Auto-generated method stub

					for (Schedule sch : a.getChromosome()) {

						size = sch.get_slots().length;
					}
					// System.out.println("size "+size);
					return size;
				}

				@Override
				public void setValues(PreparedStatement ps, int index)
						throws SQLException {

					// System.out.println("index value :"+index);
					// Map<Integer,CourseClass> map=s.get_classes();
					ArrayList<CourseClass>[] slot = s.get_slots();

					// for(int
					// inner=keyList.get(index);inner==keyList.get(index);inner++){
					// for(int inner=0;inner<slot.length;inner++){
					// System.out.println("index : "+index);
					// System.out.println("index : "+index+","+slot[index].get(0).getCourse().getId());
					// ps.setInt(1,s.getOffSpringId());
					ps.setInt(1, s.getChromosomeId());

					ps.setInt(2, slot[index].get(0).getStudentGroup().getId());

					ps.setInt(3, slot[index].get(0).getCourse().getId());

					ps.setInt(4, slot[index].get(0).getProf().getId());

					ps.setInt(5, slot[index].get(0).getDurationOfeachCourse());

					ps.setString(6, slot[index].get(0).getRequiredLabOrNot());

					ps.setInt(7, slot[index].get(0).getNoOfClassesPerWeek());

					ps.setFloat(8, s.get_fitness());

					ps.setInt(9, index);

					ps.setInt(10, slot[index].get(0).getRoom().getId());

					// }
				}
			});
		}

	}

	@Override
	public void deleteChromosomes() {
		// TODO Auto-generated method stub
		String query = "truncate chromosomes;";
		jdbcTemplate.execute(query);

	}

	@Override
	public void insertMutationOffspringChromosome(final Algorithm a) {
		// TODO Auto-generated method stub
		deleteMutationOffspring();

		String query = null;
		int countForChromosome = 0;

		// System.out.println("chromosome size "+a.getChromosome().size());

		for (final Schedule s : a.getMutatedOffspring()) {

			countForChromosome = countForChromosome + 1;
			// final ArrayList<CourseClass>[] slot=s.get_slots();
			// Map<Integer,CourseClass> forKey=s.get_classes();
			/*
			 * final List<Integer> keyList=new ArrayList<Integer>();
			 * for(Map.Entry<Integer,CourseClass> map:forKey.entrySet()){
			 * keyList.add(map.getKey());
			 * 
			 * }
			 */

			// query="insert into offspring(chromosomeId, studentId, courseId, profId, duration, requiredLab, noOfClasses, fitnessValue,slot) values (?,?,?,?,?,?,?,?,?);";
			query = "insert into mutatedoffspring(chromosomeId,studentId, courseId, profId, duration, requiredLab, noOfClasses, fitnessValue,slot,roomId) values (?,?,?,?,?,?,?,?,?,?);";
			// System.out.println("After insert query");
			jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
				int count = 0;
				int size = 0;

				@Override
				public int getBatchSize() {

					// TODO Auto-generated method stub

					for (Schedule sch : a.getMutatedOffspring()) {

						size = sch.get_slots().length;
					}
					// System.out.println("size "+size);
					return size;
				}

				@Override
				public void setValues(PreparedStatement ps, int index)
						throws SQLException {

					// System.out.println("index value :"+index);
					// Map<Integer,CourseClass> map=s.get_classes();
					ArrayList<CourseClass>[] slot = s.get_slots();

					// for(int
					// inner=keyList.get(index);inner==keyList.get(index);inner++){
					// for(int inner=0;inner<slot.length;inner++){
					// System.out.println("index : "+index);
					// System.out.println("index : "+index+","+slot[index].get(0).getCourse().getId());
					// ps.setInt(1,s.getOffSpringId());
					ps.setInt(1, s.getChromosomeId());

					ps.setInt(2, slot[index].get(0).getStudentGroup().getId());

					ps.setInt(3, slot[index].get(0).getCourse().getId());

					ps.setInt(4, slot[index].get(0).getProf().getId());

					ps.setInt(5, slot[index].get(0).getDurationOfeachCourse());

					ps.setString(6, slot[index].get(0).getRequiredLabOrNot());

					ps.setInt(7, slot[index].get(0).getNoOfClassesPerWeek());

					ps.setFloat(8, s.get_fitness());

					ps.setInt(9, index);

					ps.setInt(10, slot[index].get(0).getRoom().getId());

					// }
				}
			});
		}
	}

	@Override
	public void deleteMutationOffspring() {
		// TODO Auto-generated method stub
		String query = "truncate mutatedoffspring;";
		jdbcTemplate.execute(query);

	}

	@Override
	public List<CourseClass> displayTimeTable(CourseClass cc) {
		System.out.println("Inisde TimetableDAO.displayTimeTable Method");

		String query = "SELECT * FROM chromosomes where studentId='"
				+ cc.getStudentGroup().getId()
				+ "' and chromosomeId=0 order by slot asc;";

		System.out.println("Query executed is :" + query);
		return jdbcTemplate.query(query, new TimeTableDatas());

	}

	@Override
	public List<CourseClass> getProfessorTimeTable(CourseClass cc) {
		// TODO Auto-generated method stub
		System.out.println("professor id :" + cc.getProf().getId());
		/*
		 * String
		 * query="SELECT * FROM chromosomes where profId='"+cc.getProf().getId
		 * ()+"' and chromosomeId=0 ;";
		 */

		/*
		 * String query=
		 * "select id, chromosomeId, studentId, courseId, profId, duration, requiredLab, noOfClasses, fitnessValue, slot, roomId, subjectType, optionalCourseId from optionalsubchromosome"
		 * + " where profId ='"+cc.getProf().getId()+"' and chromosomeid=0"+
		 * " where profId =28 and chromosomeid=0"+ " union"+
		 * " select id, chromosomeId, studentId, courseId, profId, duration, requiredLab, noOfClasses, fitnessValue, slot, roomId, subjectType, null from chromosomes"
		 * + " where profId='"+cc.getProf().getId()+
		 * "' and chromosomeid=0 order by slot";
		 * " where profId=28 and chromosomeid=0 order by slot";
		 */

		String query = "select id, chromosomeId, studentId, courseId, profId, duration, requiredLab, noOfClasses, fitnessValue, slot, roomId, subjectType, optionalCourseId from optionalsubchromosome"
				+ " where profId='"
				+ cc.getProf().getId()
				+ "' and chromosomeid=0 "
				+ " union "
				+ " select id, chromosomeId, studentId, courseId, profId, duration, requiredLab, noOfClasses, fitnessValue, slot, roomId, subjectType, null from chromosomes "
				+ " where profId='"
				+ cc.getProf().getId()
				+ "' and chromosomeid=0 order by  slot;";
		return jdbcTemplate.query(query, new ProfessorTimeTableDatas());

	}

	@Override
	public List<CourseClass> secondaryDataForTimeTable(CourseClass cc) {
		System.out.println("Inside secondaryDataForTimeTable in TimetableDao");
		System.out.println("");
		String query = "SELECT * FROM optionalsubchromosome o where studentId='"
				+ cc.getStudentGroup() + "' and chromosomeId=0 ;";
		return jdbcTemplate.query(query, new SecondaryTimeTableDatas());
	}

}

class SecondaryTimeTableDatas implements RowMapper<CourseClass> {
	@Override
	public CourseClass mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		CourseClass cc = new CourseClass();
		cc.setId(rs.getInt("id"));

		StudentsGroup sg = new StudentsGroup();
		sg.setId(rs.getInt("studentId"));
		cc.setStudentGroup(sg);

		Course course = new Course();
		course.setId(rs.getInt("courseId"));
		course.setOptionalCourseId(rs.getInt("optionalCourseId"));
		cc.setCourse(course);

		Professor prof = new Professor();
		prof.setId(rs.getInt("profId"));
		cc.setProf(prof);

		cc.setDurationOfeachCourse(rs.getInt("duration"));
		cc.setRequiredLabOrNot(rs.getString("requiredLab"));
		cc.setNoOfClassesPerWeek(rs.getInt("noOfClasses"));
		cc.setSlotForThisCourseClass(rs.getInt("slot"));
		Room room = new Room();
		room.setId(rs.getInt("roomId"));
		cc.setRoom(room);

		return cc;
	}

}

class ProfessorTimeTableDatas implements RowMapper<CourseClass> {

	@Override
	public CourseClass mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		CourseClass cc = new CourseClass();
		cc.setId(rs.getInt("id"));

		StudentsGroup sg = new StudentsGroup();
		sg.setId(rs.getInt("studentId"));
		cc.setStudentGroup(sg);

		Course course = new Course();
		String optionalCourseId = rs.getString("optionalCourseId");
		System.out.println("course class id :" + cc.getId());
		System.out.println("optional course id :" + optionalCourseId);

		if (optionalCourseId == null) {
			course.setId(rs.getInt("courseId"));
		} else {
			course.setId(Integer.valueOf(optionalCourseId));
		}

		cc.setCourse(course);

		Professor prof = new Professor();
		prof.setId(rs.getInt("profId"));
		cc.setProf(prof);

		cc.setDurationOfeachCourse(rs.getInt("duration"));
		cc.setRequiredLabOrNot(rs.getString("requiredLab"));
		cc.setNoOfClassesPerWeek(rs.getInt("noOfClasses"));
		System.out.println("");
		cc.setSlotForThisCourseClass(rs.getInt("slot"));
		Room room = new Room();
		room.setId(rs.getInt("roomId"));
		cc.setRoom(room);

		return cc;
	}

}

class TimeTableDatas implements RowMapper<CourseClass> {

	@Override
	public CourseClass mapRow(ResultSet rs, int arg1) throws SQLException {
		System.out.println("Inside Result set Extractor for Chromosomes table");
		System.out
				.println("Creating object for CourseClass,StudentsGroup,course,prof,room");
		System.out
				.println("Getting details of id, chromosomeId, studentId, courseId, profId, duration, "
						+ "requiredLab, noOfClasses, fitnessValue, slot, roomId");
		CourseClass cc = new CourseClass();
		// id, chromosomeId, studentId, courseId, profId, duration, requiredLab,
		// noOfClasses, fitnessValue, slot, roomId
		cc.setId(rs.getInt("id"));

		StudentsGroup sg = new StudentsGroup();
		sg.setId(rs.getInt("studentId"));
		cc.setStudentGroup(sg);

		Course course = new Course();
		course.setId(rs.getInt("courseId"));
		cc.setCourse(course);

		Professor prof = new Professor();
		prof.setId(rs.getInt("profId"));
		cc.setProf(prof);

		cc.setDurationOfeachCourse(rs.getInt("duration"));
		cc.setRequiredLabOrNot(rs.getString("requiredLab"));
		cc.setNoOfClassesPerWeek(rs.getInt("noOfClasses"));
		cc.setSlotForThisCourseClass(rs.getInt("slot"));
		Room room = new Room();
		room.setId(rs.getInt("roomId"));
		cc.setRoom(room);
		System.out.println("Returning Object from TimeTableDatas result set:"+ cc.toString());
		return cc;
	}

}

class ProfessorMapper implements RowMapper<Professor> {

	@Override
	public Professor mapRow(ResultSet rs, int index) throws SQLException {
		// TODO Auto-generated method stub
		Professor pf = new Professor();

		pf.setId(rs.getInt(1));
		pf.setProf_name(rs.getString(2));
		return pf;
	}

}

class StudentGroupMapper implements RowMapper<StudentsGroup> {

	@Override
	public StudentsGroup mapRow(ResultSet rs, int index) throws SQLException {
		// TODO Auto-generated method stub
		StudentsGroup sg = new StudentsGroup();

		Integer column1 = rs.getInt(1);
		String column2 = rs.getString(2);
		String column3 = rs.getString(3);
		String column4 = rs.getString(4);
		sg.setId(column1);
		sg.setStd(column2);
		sg.setSec(column3);
		sg.setCombination(column4);

		return sg;
	}

}

class CourseMap implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs, int index) throws SQLException {
		// TODO Auto-generated method stub
		Course c = new Course();
		c.setId(rs.getInt(1));
		c.setStandard(rs.getString(2));
		c.setSubject_name(rs.getString(3));
		return c;
	}

}

class WholeListRowMapper implements RowMapper<CourseClass> {

	@Override
	public CourseClass mapRow(ResultSet rs, int index) throws SQLException {
		// TODO Auto-generated method stub
		CourseClass c = new CourseClass();
		c.setId(rs.getInt("id"));
		StudentsGroup student = new StudentsGroup();
		student.setId(rs.getInt("studentId"));
		c.setStudentGroup(student);
		Course course = new Course();
		course.setId(rs.getInt("courseId"));
		c.setCourse(course);
		Professor pro = new Professor();
		pro.setId(rs.getInt("profId"));
		c.setProf(pro);
		c.setDurationOfeachCourse(rs.getInt("duration"));
		c.setRequiredLabOrNot(rs.getString("requiredLab"));
		c.setNoOfClassesPerWeek(rs.getInt("noOfClasses"));
		Room room = new Room();
		room.setId(rs.getInt("roomId"));
		c.setRoom(room);
		return c;
	}

}
