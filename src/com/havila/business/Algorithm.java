package com.havila.business;

import java.util.ArrayList;
import java.util.List;

import com.havila.pojo.Schedule;



public class Algorithm {
	
	public Algorithm(int numberOfChromosomes,int replaceByGeneration,int trackBest,Schedule prototype){
		
		this.numberOfChromosomes=numberOfChromosomes;
		this.currentBestSize=0;
		this.currentGeneration=0;
		this.replaceByGeneration=replaceByGeneration;
		this.prototype=prototype;
		this.state=AlgorithmState.AS_USER_STOPPED;
		if(numberOfChromosomes<2){
			numberOfChromosomes=2;			
		}
		if(trackBest<1){
			trackBest=1;
		}
		if(replaceByGeneration<1){
			this.replaceByGeneration=1;
		}else if(this.replaceByGeneration>numberOfChromosomes-trackBest){
			this.replaceByGeneration=numberOfChromosomes-trackBest;
		}
		
		bestChromosome=new Integer[trackBest];
		bestFlag=new ArrayList<Boolean>(numberOfChromosomes);
		chromosome=new ArrayList<Schedule>(numberOfChromosomes);
		
		
	//	for( int i = (int)chromosome.size() - 1; i >= 0; --i )
				
	}
	enum AlgorithmState{
		AS_USER_STOPPED,
		AS_CRITERIA_STOPPED,
		AS_RUNNING		
	}
		
private ArrayList<Schedule> chromosome;


public ArrayList<Schedule> getChromosome() {
	return chromosome;
}
public void setChromosome(ArrayList<Schedule> chromosome) {
	this.chromosome = chromosome;
}
public Integer getCurrentBestSize() {
	return currentBestSize;
}
public void setCurrentBestSize(Integer currentBestSize) {
	this.currentBestSize = currentBestSize;
}
public Integer getReplaceByGeneration() {
	return replaceByGeneration;
}
public void setReplaceByGeneration(Integer replaceByGeneration) {
	this.replaceByGeneration = replaceByGeneration;
}
public Schedule getPrototype() {
	return prototype;
}
public void setPrototype(Schedule prototype) {
	this.prototype = prototype;
}
public Integer getCurrentGeneration() {
	return currentGeneration;
}
public void setCurrentGeneration(Integer currentGeneration) {
	this.currentGeneration = currentGeneration;
}
//chromosomeIndex,bestChromosome,
private ArrayList<Boolean> bestFlag;

public ArrayList<Boolean> getBestFlag() {
	return bestFlag;
}
public void setBestFlag(ArrayList<Boolean> bestFlag) {
	this.bestFlag = bestFlag;
}
private Integer[] bestChromosome;


public Integer[] getBestChromosome() {
	return bestChromosome;
}
public void setBestChromosome(Integer[] bestChromosome) {
	this.bestChromosome = bestChromosome;
}
private Integer currentBestSize;
private Integer replaceByGeneration;
private Schedule prototype;
private Integer currentGeneration;
private Integer numberOfChromosomes;
private ArrayList<Schedule> offspring;
private ArrayList<Schedule>	mutatedOffspring;
public ArrayList<Schedule> getMutatedOffspring() {
	return mutatedOffspring;
}
public void setMutatedOffspring(ArrayList<Schedule> mutatedOffspring) {
	this.mutatedOffspring = mutatedOffspring;
}
public ArrayList<Schedule> getOffspring() {
	return offspring;
}
public void setOffspring(ArrayList<Schedule> offspring) {
	this.offspring = offspring;
}
public Integer getNumberOfChromosomes() {
	return numberOfChromosomes;
}
public void setNumberOfChromosomes(Integer numberOfChromosomes) {
	this.numberOfChromosomes = numberOfChromosomes;
}
AlgorithmState state;

//private ArrayList<Integer> offSpringId;


/*public ArrayList<Integer> getOffSpringId() {
	return offSpringId;
}
public void setOffSpringId(ArrayList<Integer> offSpringId) {
	this.offSpringId = offSpringId;
}*/



}
