package com.havila.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.havila.dao.ITimeTable;
import com.havila.pojo.CourseClass;
import com.havila.pojo.Schedule;
import com.havila.pojo.StudentsGroup;

@Service
public class GenerateTimeTable implements IGenerateTimeTable{
	
	
	@Autowired
	private ITimeTable timeTable;
	Schedule parent=new Schedule(2,2,80,99);
	Random random=new Random();
	static int noOfStudentGroup=28;
	int trackBest=3;
	Algorithm algorithm=new Algorithm(20,5,trackBest,parent);	
	//private static ArrayList<Integer>[] freeSlots=new ArrayList[noOfStudentGroup];
	  private  final static ArrayList<Integer>[] freeSlotArray=new ArrayList[noOfStudentGroup];
	//createFreeSlots();

	public ArrayList<Schedule> start(){
		createFreeSlot();
		
		ArrayList<Schedule> scheduleArray=new ArrayList<Schedule>();
		
		// clear population		
		for( int i = algorithm.getNumberOfChromosomes()-1; i >= 0; --i )
		{
			scheduleArray.add( null);
			algorithm.getBestFlag().add( false);
		}	
		algorithm.setChromosome(scheduleArray);	
		int i=0;
		ArrayList<Schedule> chromosome=new ArrayList<Schedule>(trackBest);			
		Algorithm.AlgorithmState state = null;
		//CSingleLock lock(stateSect,True)
		/*if(state==Algorithm.AlgorithmState.AS_RUNNING){
			return;
			
		}*/
		state=Algorithm.AlgorithmState.AS_RUNNING;
		int n=algorithm.getNumberOfChromosomes();	
		
		
		
		for(int index=0;index<n;index++,i++){	
			System.out.println("inside for loop...");			
			Schedule sch=makeNewFromPrototype(true);
			sch.setChromosomeId(index);			
	System.out.println("chromosome index : "+index);
	System.out.println("Hash Map size : "+sch.get_classes().size());
	System.out.println("Array List size : "+sch.get_slots().length);
			algorithm.setPrototype(sch);			
			algorithm.getPrototype().set_fitness(sch.get_fitness());	
			System.out.println("fitness while forming population :"+sch.get_fitness());
			algorithm.getChromosome().set(index,sch);
System.out.println("Chromosome Id: "+sch.getChromosomeId());
System.out.println("Best Chromosome size before adding : "+algorithm.getCurrentBestSize());
System.out.println("Best Chromosome size : "+algorithm.getBestChromosome().length);
			HashMap<Integer,CourseClass> tempHashMap=new HashMap<Integer,CourseClass>();
		//	System.out.println("Completion of "+index+"-th chromosome.....");
		    AddToBest( index );
	
		}
		System.out.println("Chromosome population completed.......");
		//Initial population to database
		insertChromosomes(algorithm);		
		algorithm.setCurrentGeneration(0);
		int countForAlgorithm=0;
		boolean bGotBestChromosome = false;
		
		while(!bGotBestChromosome && (countForAlgorithm<=5)){
		/*while(true){
			//lock.Lock();
			// user has stopped execution?
			if( state !=Algorithm.AlgorithmState.AS_RUNNING )
			{
			//	lock.Unlock();
				break;
			}*/						
				ArrayList<Schedule> offspring=new ArrayList<Schedule>();
				ArrayList<Schedule> mutatedOffSpring=new ArrayList<Schedule>();
				Schedule best = algorithm.getChromosome().get(algorithm.getBestChromosome()[0]);		
				// algorithm has reached criteria?
				if( best.get_fitness() >= 1 )
				{
					state = Algorithm.AlgorithmState.AS_CRITERIA_STOPPED;
					bGotBestChromosome = true;
				//	lock.Unlock();
					break;
				}
				//lock.Unlock();
				
				// produce offspring				
		System.out.println("replcae by generation : "+algorithm.getReplaceByGeneration());
				for(int j=0;j<algorithm.getReplaceByGeneration();j++){
					// selects parent randomly				
					Schedule p1=algorithm.getChromosome().get((random.nextInt(Integer.MAX_VALUE)+1)%algorithm.getChromosome().size());
					Schedule p2=algorithm.getChromosome().get((random.nextInt(Integer.MAX_VALUE)+1)%algorithm.getChromosome().size());
					System.out.println("parent 1 fitness value :"+p1.get_fitness());
					System.out.println("parent 2 fitness value :"+p2.get_fitness());
			System.out.println("parent 1-Chromosome Id : "+p1.getChromosomeId());
			System.out.println("parent 2-Chromosome Id : "+p2.getChromosomeId());
		System.out.println("offspring count : "+j);
					Schedule sch=crossover(p1,p2);	
					sch.setChromosomeId(j);
					Schedule crossover=new Schedule();
					crossover=sch;
					
					offspring.add(crossover);
					
					Schedule mutatedOffspring=mutation(sch);					
					
					mutatedOffSpring.add(mutatedOffspring);
					System.out.println("Off Spring List :");
					System.out.println("*****************Starting  offspring****************");
					System.out.println("offSpring Id :"+sch.getOffSpringId());
					System.out.println("offSpring HashMap Size :"+sch.get_classes().size());
					for(int key=0;key<sch.get_slots().length;key++){
						System.out.println("");
						System.out.println("Count "+key);
						System.out.println("offSpring Course Class Id :"+sch.get_slots()[key].get(0).getId());
						System.out.println("offSpring Student Group Id :"+sch.get_slots()[key].get(0).getStudentGroup().getId());
						System.out.println("offSpring Prof Id :"+sch.get_slots()[key].get(0).getProf().getId());
						System.out.println("offSpring Course Id :"+sch.get_slots()[key].get(0).getCourse().getId());
						System.out.println("offSpring No of Classes/week :"+sch.get_slots()[key].get(0).getNoOfClassesPerWeek());
						System.out.println("offSpring Duration of Each Course :"+sch.get_slots()[key].get(0).getDurationOfeachCourse());
						System.out.println("offSpring Lab (Y/N) :"+sch.get_slots()[key].get(0).getRequiredLabOrNot());
						System.out.println(" ");
					}
					System.out.println("*****************Finished offspring****************");
				//	System.out.println("Inside loop ,size of offspring : "+offspring.size());
			System.out.println("new offspring : "+sch);				
					
				}
				System.out.println("total offspring creation completed......");
				algorithm.setOffspring(offspring);
				algorithm.setMutatedOffspring(mutatedOffSpring);
				//Offspring to database
				
				insertMutationOffspring(algorithm);
				ArrayList<Schedule> off=algorithm.getOffspring();
				System.out.println("Off Spring List :");
				System.out.println("*****************Starting  offspring****************");
				for(int index=0;index<algorithm.getReplaceByGeneration();index++){
					System.out.println("offSpring Id :"+off.get(index).getOffSpringId());
					System.out.println("offSpring HashMap Size :"+off.get(index).get_classes().size());
					for(int key=0;key<off.get(index).get_classes().size();key++){
						System.out.println("");
						System.out.println("Count "+key);
						System.out.println("offSpring Course Class Id :"+off.get(index).get_classes().get(key).getId());
						System.out.println("offSpring Student Group Id :"+off.get(index).get_classes().get(key).getStudentGroup().getId());
						System.out.println("offSpring Prof Id :"+off.get(index).get_classes().get(key).getProf().getId());
						System.out.println("offSpring Course Id :"+off.get(index).get_classes().get(key).getCourse().getId());
						System.out.println("offSpring No of Classes/week :"+off.get(index).get_classes().get(key).getNoOfClassesPerWeek());
						System.out.println("offSpring Duration of Each Course :"+off.get(index).get_classes().get(key).getDurationOfeachCourse());
						System.out.println("offSpring Lab (Y/N) :"+off.get(index).get_classes().get(key).getRequiredLabOrNot());
						System.out.println(" ");
					}
					
					
				}
				System.out.println("*****************Finished offspring****************");
								
				// replace chromosomes of current operation with offspring
				for( int j = 0; j < algorithm.getReplaceByGeneration(); j++ ){
					int ci;
					boolean bInBest;
					do
					{
						bInBest = false;
						// select chromosome for replacement randomly
						ci = (random.nextInt(Integer.MAX_VALUE)+1) % (int)algorithm.getChromosome().size();	
						// protect best chromosomes from replacement
						bInBest = isInBest( ci );
					} while( bInBest );
		System.out.println("replacing in parent population"+ci);
					// replace chromosomes		
					
					algorithm.getOffspring().get(j).setChromosomeId(algorithm.getChromosome().get(ci).getChromosomeId());					
					algorithm.getChromosome().set(ci,algorithm.getOffspring().get(j));
					
		//System.out.println("replaced offspring in pos"+ci);
					// try to add new chromosomes in best chromosome group
					AddToBest( ci );
		System.out.println("Current Best Size : "+algorithm.getCurrentBestSize());
		System.out.println("Best Chromosome List after replacing one offspring:");									
					
				}
				
		System.out.println("Current Best Size : "+algorithm.getCurrentBestSize());
		System.out.println("Best Chromosome List after replacing offspring:");
			
				/*for(int index=0;index<algorithm.getCurrentBestSize();index++){
					System.out.println("Chromosome Id "+algorithm.getChromosome().get(algorithm.getBestChromosome()[index]).getChromosomeId());
					System.out.println("index of best chromosomes "+algorithm.getBestChromosome()[index]);
				}*/
				
					// algorithm has found new best chromosome
				//	if( best != GetBestChromosome() && _observer )...........................................
					//	if( best !=  && _observer )
						// notify observer
				//		_observer->NewBestChromosome( *GetBestChromosome() );

				//	countForAlgorithm++;
				//}
				/*if( _observer )
					// notify observer that execution of algorithm has changed it state
					_observer->EvolutionStateChanged( _state );
			*/
		
		
				countForAlgorithm=countForAlgorithm+1;
				
	}
	
		insertOffspring(algorithm);
	return chromosome;
}

	// Returns pointer to best chromosomes in population		
	private boolean isInBest(int ci) {		
		return algorithm.getBestFlag().get(ci);
	}


	public Schedule makeCopyOfChromosome(Schedule parent){
System.out.println("Copy from parent.........");
		Schedule newChromosome=new Schedule();
		
		newChromosome.set_slots(parent.get_slots());
		newChromosome.set_classes(parent.get_classes());
		newChromosome.set_criteria(parent.get_criteria());
		newChromosome.set_fitness(parent.get_fitness());
		
		newChromosome.set_numberOfCrossoverPoints(parent.get_numberOfCrossoverPoints());
		newChromosome.set_mutationSize(parent.get_mutationSize());
		newChromosome.set_crossoverProbability(parent.get_crossoverProbability());
		newChromosome.set_mutationProbability(parent.get_mutationProbability());

		return newChromosome;
	}
	
	private   ArrayList<Integer>[] createFreeSlot(){
		//free slot initialization	
		
				int iFreeSlotPos=0;
				for(int studentGroupCounter=0;studentGroupCounter<noOfStudentGroup;studentGroupCounter++)
				{
					System.out.println("No Of Student Group:"+noOfStudentGroup);
					ArrayList<Integer> slotList=new ArrayList<Integer>();
					for (int day=0; day < Schedule.DAYS_NUM; day++)
					{
						for (int classes=0; classes < Schedule.DAY_HOURS;classes++)
						{
							iFreeSlotPos = (day*noOfStudentGroup*Schedule.DAY_HOURS)+(studentGroupCounter*Schedule.DAY_HOURS)+classes;
							System.out.println("iFreeSlotPos value"+iFreeSlotPos);
							slotList.add(iFreeSlotPos);
							freeSlotArray[studentGroupCounter]=slotList;						
						}
					}
				}
				
	return freeSlotArray;
	}
	

	
	
	
	public Schedule makeNewFromPrototype(Boolean setupOnly){
System.out.println("new prtottype callled..................");		
		ArrayList<CourseClass> _slots[]=new ArrayList[Schedule.DAYS_NUM*Schedule.DAY_HOURS*noOfStudentGroup];
		Integer noOfSlots=Schedule.DAYS_NUM*Schedule.DAY_HOURS;
		
		ArrayList<Integer>[] freeSlots=new ArrayList[noOfStudentGroup];
		
		for(int index=0;index<noOfStudentGroup;index++){
			freeSlots[index] = new ArrayList<Integer>(freeSlotArray[index]);
		
		}
		
		

		//free slot initialization				
		int iFreeSlotPos=0;
		for(int studentGroupCounter=0;studentGroupCounter<noOfStudentGroup;studentGroupCounter++)
		{
			ArrayList<Integer> slotList=new ArrayList<Integer>();
			for (int day=0; day < Schedule.DAYS_NUM; day++)
			{
				for (int classes=0; classes < Schedule.DAY_HOURS;classes++)
				{
					iFreeSlotPos = (day*noOfStudentGroup*Schedule.DAY_HOURS)+(studentGroupCounter*Schedule.DAY_HOURS)+classes;
				//	System.out.println("iFreeSlotPos value "+iFreeSlotPos);
					slotList.add(iFreeSlotPos);
					freeSlots[studentGroupCounter]=slotList;						
				}
			}
		}
		
		System.out.println("free slots formed.............");
		//To print free slots
		for(int index=0;index<noOfStudentGroup;index++){
			System.out.println("for sg :"+index);
			for(int innerIndex=0;innerIndex<freeSlots[index].size();innerIndex++){
				System.out.println("free slot "+freeSlots[index].get(innerIndex));
			}
			
		}
		
						
		Map<Integer, CourseClass> _classes=new HashMap<Integer,CourseClass>();
	//	System.out.println("making new prototype.......");
		Schedule newChromosome=new Schedule();
		if(!setupOnly){		
		newChromosome.set_slots(parent.get_slots());
		newChromosome.set_classes(parent.get_classes());
		newChromosome.set_criteria(parent.get_criteria());
		newChromosome.set_fitness(parent.get_fitness());		
		}
		newChromosome.set_numberOfCrossoverPoints(parent.get_numberOfCrossoverPoints());
		newChromosome.set_mutationSize(parent.get_mutationSize());
		newChromosome.set_crossoverProbability(parent.get_crossoverProbability());
		newChromosome.set_mutationProbability(parent.get_mutationProbability());
		
		ArrayList<CourseClass> courseClassList=(ArrayList<CourseClass>) timeTable.getAllList();				
		System.out.println("Slots size :"+_slots.length);
		System.out.println("Hash map size "+_classes.size());
		System.out.println("size of course class "+courseClassList.size());
System.out.println("started to fill the Chromosome...............");										
		
		for(int counter=0;counter<courseClassList.size();counter++){
							
				int workLoad=courseClassList.get(counter).getNoOfClassesPerWeek();
				int duration=0;	
				duration=courseClassList.get(counter).getDurationOfeachCourse();	
				for(int workLoadCount=workLoad;workLoadCount>0;workLoadCount--){
							
					int pos=0;													
					boolean getNextPos=false;														
					int classes=courseClassList.get(counter).getStudentGroup().getId();
					int tempClasses=classes;
					int iGetNextPosCounter=0;
		//	for block period checking		        System.out.println("student Group :"+classes);
//					for block period checking		System.out.println("CourseClass id :"+courseClassList.get(counter).getId());
//					for block period checking		System.out.println("size of free slots arrayList :"+freeSlots[classes].size());
										 
				 do{				
					
									
						int randomIndex = random.nextInt(freeSlots[classes].size());
						iGetNextPosCounter++;
						pos=freeSlots[classes].get(randomIndex);
					    getNextPos=true;
										
						if ( duration > 1){
							for(int i=1;i<duration;i++){																									 
								if (freeSlots[classes].contains(pos+i)){
//													for block period checking	System.out.println("value of getNextPos :"+getNextPos);
										getNextPos=true;
								 }										 
								 else{
										getNextPos=false;

	System.out.println("value of getNextPos :"+getNextPos);
										break;											
									 }
										 	
							}
						}
																			
					}while(!getNextPos);	
					//	for block period checking					
				 System.out.println("Get Next Pos counter"+iGetNextPosCounter);	
						
					for(int i=0;i<=duration-1;i++){						
							//	for block period checking				
						System.out.println("position :"+pos);						  		
						  ArrayList<CourseClass> course=new ArrayList<CourseClass>();		
						  course.add(courseClassList.get(counter));		
					
						  _slots[pos+i]= course;
						  freeSlots[courseClassList.get(counter).getStudentGroup().getId()].remove(new Integer(pos+i));														
						//For testing ...............................................
						System.out.println("position/slot : "+(pos+i));
						System.out.println(" Student Id "+courseClassList.get(counter).getStudentGroup().getId());
						System.out.println("***********");
						
						System.out.println("c Id : "+courseClassList.get(counter).getId());					
						System.out.println(" c Course : "+courseClassList.get(counter).getCourse().getId());
						System.out.println(" c Prof Id : "+courseClassList.get(counter).getProf().getId());
						System.out.println(" c Student group Id : "+courseClassList.get(counter).getStudentGroup().getId());
						System.out.println(" c No of Classes/week : "+courseClassList.get(counter).getNoOfClassesPerWeek());
						System.out.println(" c Duration : "+courseClassList.get(counter).getDurationOfeachCourse());
						System.out.println("*******************");
						
						
					 }
						
				_classes.put( pos,courseClassList.get(counter));
				System.out.println("Hash map size after put "+_classes.size());
									
			}
				
						
		}
	
		newChromosome.set_slots(_slots);		
		newChromosome.set_classes(_classes);
		System.out.println("Size of slots"+_slots.length);
		System.out.println("Size of Hashmap"+_classes.size());
					
		for(int i=0;i<algorithm.getNumberOfChromosomes();i++){
			System.out.println("Starting of chromosome..........................");
		//	System.out.println("Chromosome Id : "+i);
			
			int index=0;
			System.out.println("value of Schedule.DAYS_NUM :"+Schedule.DAYS_NUM);
			System.out.println("value of Schedule.DAY_HOURS :"+Schedule.DAY_HOURS);
			System.out.println("value of noOfStudentGroup :"+noOfStudentGroup);
			System.out.println("Slot details :"+_slots);
			for(index=0;index<Schedule.DAYS_NUM*Schedule.DAY_HOURS*noOfStudentGroup;index++){
				int count=0;
				System.out.println("value of index :"+index);
				System.out.println("value of count :"+count);
				System.out.println("Slot index :"+_slots[index]);
				System.out.println("value of _slots[index].size() :"+_slots[index].size());
				
				
			//int duration=courseClassList.get(index).getDurationOfeachCourse();	
							for(count=0;count<_slots[index].size();count++){
				System.out.println("Slot No : "+index+" CourseClass Id : "+_slots[index].get(count).getId()+" "+"Student Group Id : "+_slots[index].get(count).getStudentGroup().getId()+
						" "+"Prof Id : "+_slots[index].get(count).getProf().getId()+
						" "+"Course Id : "+_slots[index].get(count).getCourse().getId()+
						" "+"No. of classes per week : "+_slots[index].get(count).getNoOfClassesPerWeek()+
						" "+"Duration of each course : "+_slots[index].get(count).getDurationOfeachCourse()+
						" "+"Lab : "+_slots[index].get(count).getRequiredLabOrNot());

		}
			}
		//	System.out.println("Ending of chromosome...............................");
		}
		//	for block period checking	System.out.println("before calculating fitness");
		newChromosome.set_fitness(calculateFitness(newChromosome));
		//	for block period checking		System.out.println(" chromosome creation completed and id is :");
		
		
		return newChromosome; 		
	}
	
	// Tries to add chromosomes in best chromosome group
	private void AddToBest(int chromosomeIndex) {
System.out.println("Adding into best.......");
		// don't add if new chromosome hasn't fitness big enough for best chromosome group
		// or it is already in the group?
		System.out.println("Inside AddToBest......");
		System.out.println("chromosomeIndex : "+chromosomeIndex);
		System.out.println("Current Best Size :"+algorithm.getCurrentBestSize());
		System.out.println("size of Chromosome List : "+algorithm.getChromosome().size());
		System.out.println("size of  best flag : "+algorithm.getBestFlag().size());
		System.out.println("************************");
		//System.out.println("size of Best Chromosome List "+algorithm.getBestChromosome().size());
		
		int iCurrentBestSize = algorithm.getCurrentBestSize();		
		boolean bChromosomeBestFlag = algorithm.getBestFlag().get(chromosomeIndex);
		float fLastBestChromosomeFitness = 0;
		if ( iCurrentBestSize != 0){	
			fLastBestChromosomeFitness = algorithm.getChromosome().get(algorithm.getBestChromosome()[iCurrentBestSize-1]).get_fitness();
		}
		
		float fChromosomeFitness = algorithm.getChromosome().get(chromosomeIndex).get_fitness();
	//	System.out.println("iCurrentbestSize : "+iCurrentBestSize);
		//System.out.println("iBestChromosomeSize : "+iBestChromosomeSize);
	//	System.out.println("bChromosomeBestFlag : "+bChromosomeBestFlag);
	//	System.out.println("fLastBestChromosomeFitness : "+fLastBestChromosomeFitness);
	//	System.out.println("fChromosomeFitness : "+fChromosomeFitness);
	
		if (((iCurrentBestSize == algorithm.getBestChromosome().length) && (( iCurrentBestSize != 0) && (fLastBestChromosomeFitness >= fChromosomeFitness))) 
				|| bChromosomeBestFlag )
					return;
													
		// find place for new chromosome
		int i = algorithm.getCurrentBestSize();
		for(; i > 0; i--){
			
			// group is not full?	
			if( i <	algorithm.getBestChromosome().length)
			{			
				// position of new chromosomes is found?						
				if(algorithm.getChromosome().get(algorithm.getBestChromosome()[i-1]).get_fitness()>
					algorithm.getChromosome().get(chromosomeIndex).get_fitness())					
				
				    break;
																			    
				// move chromosomes to make room for new				
				    algorithm.getBestChromosome()[i]= algorithm.getBestChromosome()[i-1];
				 //   System.out.println("best chromosome size : "+algorithm);
				 				    				   
			}
			else				
			// group is full remove worst chromosomes in the group																		
				algorithm.getBestFlag().set(algorithm.getBestChromosome()[(i-1)],false);
			
		}		
	
			// store chromosome in best chromosome group				
			algorithm.getBestChromosome()[i]= chromosomeIndex;
			algorithm.getBestFlag().set(chromosomeIndex, true);													
			
			// increase current size if it has not reached the limit yet						
			if(algorithm.getCurrentBestSize()<algorithm.getBestChromosome().length){
				Integer currentBestSize=algorithm.getCurrentBestSize()+1;
				algorithm.setCurrentBestSize(currentBestSize);		
				
			}
			/*//Printing Best Chromosome list
			System.out.println("Best Chromosome List :");		
			for(int index=0;index<algorithm.getCurrentBestSize();index++){
				System.out.println("Chromosome Id "+algorithm.getChromosome().get(algorithm.getBestChromosome()[index]).getChromosomeId()+" & fitness value :"+algorithm.getChromosome().get(algorithm.getBestChromosome()[index]).get_fitness());
			}*/
								
	}
	

	public float calculateFitness(Schedule sch){
System.out.println("inside calculate fitness");
		ArrayList<Boolean> _criteria=new ArrayList<Boolean>();
		int time=0;		
		int day=0;
		int score=0;		
		int daySize=Schedule.DAY_HOURS*noOfStudentGroup;
		int ci=0;
		int dur=0;		 
		ArrayList<CourseClass>[] slot= sch.get_slots();		
		Map<Integer,CourseClass> map=sch.get_classes();
		float fitness=sch.get_fitness();		
		for (Map.Entry<Integer, CourseClass> entry : map.entrySet()) {  								
			  int p=entry.getKey();
			  day=p/daySize;
			  time=p%daySize;
			  int studentGroupNo=time/ Schedule.DAY_HOURS;
			  time=time%Schedule.DAY_HOURS;
			  dur=entry.getValue().getDurationOfeachCourse();			 				  			  			  
			// check overlapping of classes for professors and student groups
			  boolean po = false;
			  boolean go = false;	
			  boolean ro=false;
			  boolean poandgo=false;
	
			for(int i = noOfStudentGroup, t =(day * daySize + time) ;( (i > 0)&& (!poandgo)); i--, t +=Schedule.DAY_HOURS )								
			{					
				// for each hour of class		
			/*	System.out.println("value of No.Of StudentGroup :"+noOfStudentGroup);
				System.out.println("value of Day :"+day);
				System.out.println("value of time :"+time);
				System.out.println("value of t :"+t);*/
			
				for(int ii=0;((ii<=dur-1) && (!poandgo));ii++)	
				{
					// check for overlapping with other classes at same time		
					 System.out.println("slot :"+sch.get_slots()[t+ii].size()+" "+"counting..."+i);
					System.out.println("value of ii :"+ii);
					System.out.println("value of Duaration :"+dur);
					 System.out.println("value in slot :"+slot[t+ii].get(0).getStudentGroup().getId());
					ArrayList<CourseClass> cl = slot[ t + ii ];	
			//	System.out.println("t+ii size is "+(t+ii));
	//				System.out.println("cl size is :"+cl.size());
				//	System.out.println("value of t+ii : "+(t+ii));
				//	System.out.println("ArrayList slot entry -Student Group Id : "+(t+ii)+","+slot[t+ii].get(0).getStudentGroup().getId());
				//	System.out.println("Cl size : "+cl.size());
				//	System.out.println("poandgo :"+poandgo);
					for(int counter=0;((counter<slot[ t + ii ].size())&&(!poandgo));counter++){
		//				System.out.println("counter value "+counter);				
					
						if(entry.getValue()!=cl.get(counter)){
							// professor overlaps?				
																	
							//	System.out.println("entry.getValue()!=cl.get(counter) "+(entry.getValue()!=cl.get(counter)));
							//	System.out.println("student id-HM "+entry.getValue().getStudentGroup().getId()+","+"student id-Slot "+cl.get(counter).getStudentGroup().getId());
								
								if(!po && entry.getValue().getProf().getId()==cl.get(counter).getProf().getId() ){
								/*	System.out.println("professor overlapping");				
									System.out.println("Hash Map position : "+entry.getKey());
									System.out.println("ArrayList position :"+( t + ii));
									System.out.println("student Group in Hash Map: "+entry.getValue().getStudentGroup().getId()+","+"student Group in ArrayList: "+cl.get(counter).getStudentGroup().getId());									
									System.out.println("professor id in Hash Map : "+entry.getValue().getProf().getId()+","+"professor id in slot : "+cl.get(counter).getProf().getId());	*/
							System.out.println("Hash map slot :"+entry.getKey()+" "+"Comparing slot Array :"+(t+ii));
									
								po = true;
						System.out.println("professor overlapping :"+po);
								}		
								/*//Student Group comparsion is not required,since the slots are placed based on student group
								if(!go&&entry.getValue().getStudentGroup().getId()==cl.get(counter).getStudentGroup().getId()){								
									go = true;
								}*/
								if(!ro&&(entry.getValue().getRoom().getId()!=0)&&(cl.get(counter).getRoom().getId()!=0)&&(entry.getValue().getRoom().getId())==(cl.get(counter).getRoom().getId())){
							System.out.println("slot :"+entry.getKey()+" "+"student Group in Hash Map:"+entry.getValue().getStudentGroup().getId()+" student Group in Slot Array :"+cl.get(counter).getStudentGroup().getId()+" Room id in HM :"+entry.getValue().getRoom().getId()+" Room id in Slot Array : "+cl.get(counter).getRoom().getId());
									ro=true;
								//	System.out.println("room overlapping :"+ro);
								}
								if( po && go ){						
									poandgo=true;
								}																		
											
						}
						/*else{
						System.out.println("entry.getValue()!=cl.get(counter) false");
						System.out.println("student id-HM "+entry.getValue().getStudentGroup().getId()+","+"student id-Slot "+cl.get(counter).getStudentGroup().getId());
					//	System.out.println("outside the condition-else part");
						}*/
					
					}
				
				}
			
			}
		
			if(!po){
				score=score+1;				
				}
			/*if(!ro){
				score=score+1;				
				}*/
			/*if(!go){
				score=score+1;
				
			}*/
			
			ci=ci+1;
	
		}
		fitness=((float)score)/((map.size() * Schedule.NUMBEROFCONSTRAINTS ));	
			return fitness;
	}

	
	
	
	// Performes crossover operation using to chromosomes and returns pointer to offspring
		public Schedule crossover(Schedule parent1,Schedule parent2){		
//System.out.println("inside crossover........");
			int _crossoverProbability=parent1.get_crossoverProbability();
			int _numberOfCrossoverPoints=parent1.get_numberOfCrossoverPoints();
			Map<Integer,CourseClass> _classes=parent1.get_classes();
			Map<Integer,CourseClass> _classes1=parent2.get_classes();
			ArrayList<CourseClass>[] _slots=parent1.get_slots();
			ArrayList<CourseClass>[] _slots1=parent2.get_slots();
			Map<Integer,CourseClass> _newClasses=new HashMap<Integer,CourseClass>();
			ArrayList<CourseClass>[] _newSlots=new ArrayList[Schedule.DAYS_NUM*Schedule.DAY_HOURS*noOfStudentGroup];
			HashMap<Integer,CourseClass> changeHashMap1=new HashMap<Integer,CourseClass>();
			HashMap<Integer,CourseClass> changeHashMap2=new HashMap<Integer,CourseClass>();
			
			System.out.println("starting Parent 1............");
			System.out.println("Size of parent 1(Hash Map) :"+_classes.size());
			for(int i=0;i<parent1.get_classes().size();i++){		
				if(_classes.get(i)!=null){
		System.out.println("Parent 1-Hash Map Key(slots) and value : "+i+","+_classes.get(i));	
		}
		System.out.println("Parent 1-Array(slots) and value : "+i+","+_slots[i]);
		//	System.out.println("Temp Parent 1-Hash Map Key(slots) and value : "+i+","+tempPHashMap1.get(i));
		//	System.out.println("Temp Parent 1-Array(slots) and value : "+i+","+tempParent1.get_slots()[i]);
			}
			System.out.println("Ending parent 1............");
			System.out.println(" ");
			System.out.println("starting parent 2............");
			System.out.println("Size of parent 2(Hash Map) :"+_classes1.size());
			for(int i=0;i<parent2.get_classes().size();i++){		
				if(_classes1.get(i)!=null){
		System.out.println("Parent 2-Hash Map Key(slots) and value : "+i+","+_classes1.get(i));	
		}
		System.out.println("Parent 2-Array(slots) and value : "+i+","+_slots1[i]);
			//System.out.println("Temp Parent 1-Hash Map Key(slots) and value : "+i+","+tempPHashMap1.get(i));
		//	System.out.println("Temp Parent 1-Array(slots) and value : "+i+","+tempParent1.get_slots()[i]);
			}
			System.out.println("Ending parent 2............");
			
				
			
			// check probability of crossover operation
			Boolean flag=(random.nextInt(Integer.MAX_VALUE)+1) % 100 > _crossoverProbability;
	System.out.println("flag : "+flag);
			
			if( flag ){
				// no crossover, just copy first parent				
				Schedule newCopy=makeCopyOfChromosome(parent1);				
				return newCopy;
			}						
			
			// new chromosome object, copy chromosome setup			
			Schedule n=makeNewFromPrototype(true);
			// number of classes
			
			int size = _slots.length;	
	System.out.println("value of size :"+size);
			ArrayList<Boolean> cp=new ArrayList<Boolean>(size);
			for(int i=0;i<size;i++){
				cp.add(false);
			}
			
			Boolean first=(random.nextInt(Integer.MAX_VALUE)+1)%2==0;	
	System.out.println("value of first :"+first);
			// determine crossover point (randomly)			
			for( int i = _numberOfCrossoverPoints; i > 0; i-- ){
				boolean bgetNextCrossoverPoint = true;
				while(bgetNextCrossoverPoint){
					int p=random.nextInt(Integer.MAX_VALUE)%size;					
					if(((_classes.get(p)!=null)&&(_classes.get(p).getDurationOfeachCourse()==1)) && (((_classes1.get(p)!=null)&&(_classes1.get(p).getDurationOfeachCourse()==1)) && (!cp.get(p)))){
						cp.set(p, true);
						bgetNextCrossoverPoint = false;		
			System.out.println("value of crossover point :"+p);
						break;
						
						}
					}
				
				}
				
			// make new code by combining parent codes			
			int i=0;
			
			for( int j = 0; i<size && j < size;  ){									
				if( first )
				{
					CourseClass value1=_classes.get(j);					
					// insert class from first parent into new chromosome's class table
					if(value1!=null){
						_newClasses.put(j,value1 );	
						n.set_classes(_newClasses);									
					
					// all time-space slots of class are copied					
						for(int ii=0;ii<value1.getDurationOfeachCourse();ii++){																													//			
							ArrayList<CourseClass> courseclass=new ArrayList<CourseClass>();			
							courseclass.add(value1);
							_newSlots[j+ii]=courseclass;							
							n.set_slots(_newSlots);		
							
			//				System.out.println("From "+parent1.getChromosomeId()+","+"slot :"+(j+ii)+","+"offspring slots :"+n.get_slots()[j+ii].get(0));
						}
						j=j+ value1.getDurationOfeachCourse();
					}					
				}																
				else{
					CourseClass value2=_classes1.get(j);
					// insert class from second parent into new chromosome's class table				
						if(value2!=null){
							_newClasses.put(j, value2);	
							n.set_classes(_newClasses);						
					// all time-space slots of class are copied				
							for(int ii=0;ii<value2.getDurationOfeachCourse();ii++){					
									ArrayList<CourseClass> courseclass=new ArrayList<CourseClass>();						
									courseclass.add(value2);
									_newSlots[j+ii]=courseclass;						
									n.set_slots(_newSlots);
			//						System.out.println("From "+parent1.getChromosomeId()+","+"slot :"+(j+ii)+","+"offspring slots :"+n.get_slots()[j+ii].get(0));
								}
							j=j+value2.getDurationOfeachCourse();
						}								
				}
				
	System.out.println("value of j :"+j);
	System.out.println("value of cp.get(i) :"+cp.get(i));
				// crossover point
				if( cp.get(i) ){
					// change soruce chromosome
	//				System.out.println("value of first :"+first);
					first = !first;
	//				System.out.println("crossover point-j :"+i);
	//				System.out.println("value of first :"+first);
				}
				i=j;				
			}
			/*for(int index=0;index<parent1.get_classes().size();index++){		
				if(_classes.get(i)!=null){
		System.out.println("Offspring-Hash Map Key(slots) and value : "+index+","+n.get_classes().get(index));	
		}
		System.out.println("Offspring-Array(slots) and value : "+index+","+n.get_slots()[index]);
			
			}*/
			
			/*//Offspring to database
			ArrayList<Schedule> offspring=new ArrayList<Schedule>();
			n.setChromosomeId(jj);
			System.out.println("chromosome id :"+jj);
			System.out.println("student group id :"+n.get_slots()[0].get(0).getStudentGroup().getId());
			offspring.add(n);
			algorithm.setOffspring(offspring);
			timeTable.insOffspringChromosome(algorithm);
			//insertOffspring(algorithm);			 
*/			float fitness=calculateFitness(n);
			System.out.println("fitness of chromosome in crossover:"+fitness);			
			// return smart pointer to offspring
		return n;														
	}

		//Performs Mutation on chromosome
		public Schedule mutation(Schedule sch){			
		//	System.out.println("Inside Mutation.......");			
			// check probability of mutation operation
			if(random.nextInt(Integer.MAX_VALUE)%100>sch.get_mutationProbability()){
				System.out.println("mutation not occuring................");
				return sch;
			}
			
			// number of time-space slots
			int size = (int)sch.get_slots().length;
			int hashMapSize=sch.get_classes().size();
			
			// move selected number of classes at random position
			for( int i = sch.get_mutationSize(); i > 0; i-- ){
				// select random chromosome for movement
			
				int mpos = (random.nextInt(Integer.MAX_VALUE)+1) % hashMapSize;
				
				int pos1=0;
				int pos2=0;
				if(sch.get_classes().containsKey(mpos)){
					pos1=mpos;
				}
				
				CourseClass swapCourseClass1=sch.get_classes().get(pos1);
				int studentGroupNum=swapCourseClass1.getStudentGroup().getId();
				boolean durationEqualFlag=false;
				int counter=1;
				while((!durationEqualFlag)&&(counter<=3)){
					counter=counter+1;
					int getRandomPos=freeSlotArray[studentGroupNum].size();
		System.out.println("value of freeSlots :"+getRandomPos);
					int randomIndexForSlot = random.nextInt(getRandomPos);
					pos2=freeSlotArray[studentGroupNum].get(randomIndexForSlot);
				
					if((sch.get_classes().containsKey(pos2))&&(swapCourseClass1.getDurationOfeachCourse()==sch.get_classes().get(pos2).getDurationOfeachCourse())&&(pos1!=pos2))
						durationEqualFlag=true;
				}	
				
				if (durationEqualFlag){
					System.out.println("value of pos1 :"+pos1);
					System.out.println("value of pos2 :"+pos2);
					CourseClass swapCourseClass2=sch.get_classes().get(pos2);
					
					/*//Before Swapping
					System.out.println("Before Swapping.....In Hash Map pos1 :"+pos1+" and pos2 :"+pos2);
					System.out.println("pos 1 :"+sch.get_classes().get(pos1));
					System.out.println("pos 2 :"+sch.get_classes().get(pos2));
					System.out.println("Before Swapping.....In Array-slot in pos1 :"+pos1+" and pos2 :"+pos2);
					System.out.println("pos 1 :"+sch.get_slots()[pos1]);
					System.out.println("pos 2 :"+sch.get_slots()[pos2]);
					*/
					
					//Hash map swapping
					sch.get_classes().remove(pos1);				
					sch.get_classes().remove(pos2);
					sch.get_classes().put(pos1, swapCourseClass2);
					sch.get_classes().put(pos2, swapCourseClass1);
					
					//Array slots swapping
					for(int index=0;index<swapCourseClass1.getDurationOfeachCourse();index++){
						sch.get_slots()[pos1+index].set(0, swapCourseClass2);
						sch.get_slots()[pos2+index].set(0, swapCourseClass1);
					}
					System.out.println("Mutation has occured...............");

					/*//After Swapping
					System.out.println("After Swapping.....In Hash Map pos1 :"+pos1+" and pos2 :"+pos2);
					System.out.println("pos 1 :"+sch.get_classes().get(pos1));
					System.out.println("pos 2 :"+sch.get_classes().get(pos2));
					System.out.println("After Swapping.....In Array-slot in pos1 :"+pos1+" and pos2 :"+pos2);
					System.out.println("pos 1 :"+sch.get_slots()[pos1]);
					System.out.println("pos 2 :"+sch.get_slots()[pos2]);*/
					
				}
				else{
					System.out.println("Mutation has not occurred............");
					//return sch;			
				}
																		

			}
			calculateFitness(sch);
			System.out.println("fitness of the chromosome in Mutation :"+sch.get_fitness());
			return sch;
	
		}
	
	
	

	@Override
	public void insertChromosomes(Algorithm al) {
		timeTable.insChromosome(al);	
	}
	
	public void insertOffspring(Algorithm al){
		timeTable.insertCrossoverOffspringChromosome(al);
	}
	
	public void insertMutationOffspring(Algorithm al){
		timeTable.insertMutationOffspringChromosome(al);
	}

}
