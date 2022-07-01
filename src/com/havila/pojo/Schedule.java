package com.havila.pojo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Schedule {

	public Schedule(){
		
	}
	
	public Schedule(int _numberOfCrossoverPoints,int mutationSize,int crossOverProbability,int mutationProbability){
		this._numberOfCrossoverPoints=_numberOfCrossoverPoints;
		this._mutationSize=mutationSize;
		this._crossoverProbability=crossOverProbability;
		this._mutationProbability=mutationProbability;
	}
		
	public final static Integer DAY_HOURS=9;
	public final static Integer DAYS_NUM=5;
	
	
	private int _numberOfCrossoverPoints;
	public int get_numberOfCrossoverPoints() {
		return _numberOfCrossoverPoints;
	}

	public void set_numberOfCrossoverPoints(int _numberOfCrossoverPoints) {
		this._numberOfCrossoverPoints = _numberOfCrossoverPoints;
	}

	public int get_mutationSize() {
		return _mutationSize;
	}

	public void set_mutationSize(int _mutationSize) {
		this._mutationSize = _mutationSize;
	}

	public int get_crossoverProbability() {
		return _crossoverProbability;
	}

	public void set_crossoverProbability(int _crossoverProbability) {
		this._crossoverProbability = _crossoverProbability;
	}

	public int get_mutationProbability() {
		return _mutationProbability;
	}

	public void set_mutationProbability(int _mutationProbability) {
		this._mutationProbability = _mutationProbability;
	}

	public float get_fitness() {
		return _fitness;
	}

	public void set_fitness(float _fitness) {
		this._fitness = _fitness;
	}

	public ArrayList<Boolean> get_criteria() {
		return _criteria;
	}

	public void set_criteria(ArrayList<Boolean> _criteria) {
		this._criteria = _criteria;
	}

	/*public ArrayList<List<CourseClass>> get_slots() {
		return _slots;
	}

	public void set_slots(ArrayList<List<CourseClass>> _slots) {
		this._slots = _slots;
	}*/

	

	// Number of classes that is moved randomly by single mutation operation
	private int _mutationSize;

	// Probability that crossover will occure
	private int _crossoverProbability;

	// Probability that mutation will occure
	private int _mutationProbability;

	// Fitness value of chromosome
	private float _fitness;

	// Flags of class requiroments satisfaction
	private ArrayList<Boolean> _criteria;
	
	
	public final static Integer NUMBEROFCONSTRAINTS=1;
	
	// Time-space slots, one entry represent one hour in one classroom
//private List<ArrayList<CourseClass>> _slots;
	private ArrayList<CourseClass> _slots[];
	

	


	

	public ArrayList<CourseClass>[] get_slots() {
		return _slots;
	}

	public void set_slots(ArrayList<CourseClass>[] _slots) {
		this._slots = _slots;
	}

	// Class table for chromosome
	// Used to determine first time-space slot used by class
	private Map<Integer,CourseClass> _classes;
	public Map<Integer, CourseClass> get_classes() {
		return _classes;
	}

	public void set_classes(Map<Integer, CourseClass> _classes) {
		this._classes = _classes;
	}
	private Integer chromosomeId;
	public Integer getChromosomeId() {
		return chromosomeId;
	}

	public void setChromosomeId(Integer chromosomeId) {
		this.chromosomeId = chromosomeId;
	}
	
	private Integer offSpringId;
	public Integer getOffSpringId() {
		return offSpringId;
	}

	public void setOffSpringId(Integer offSpringId) {
		this.offSpringId = offSpringId;
	}

	@Override
	public String toString() {
		return "Schedule [_numberOfCrossoverPoints=" + _numberOfCrossoverPoints
				+ ", _mutationSize=" + _mutationSize
				+ ", _crossoverProbability=" + _crossoverProbability
				+ ", _mutationProbability=" + _mutationProbability
				+ ", _fitness=" + _fitness + ", _criteria=" + _criteria
				+ ", _slots=" + Arrays.toString(_slots) + ", _classes="
				+ _classes + ", chromosomeId=" + chromosomeId
				+ ", offSpringId=" + offSpringId + "]";
	}
	
	
	
	
}
/*@Override
public String toString() {
	// TODO Auto-generated method stub
	return _classes.get(0).getProf().getId().toString();
}
	
}
*/