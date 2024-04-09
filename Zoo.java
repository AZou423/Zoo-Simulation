import animal.*;
import animal.mammal.*;
import animal.reptile.*;
import linkedlist.LinkedList;
import animal.bird.*;
import animal.fish.*;

import java.io.BufferedReader;
// import java.io.FileNotFoundException;
// import java.io.IOException;
import java.io.FileReader;
import java.lang.Thread;

public class Zoo{
    public static int numThreads = 1; //Useful for getting easy access to the number of threads
    private LinkedList<Animal> animalLedger;
    private volatile int animalIndex = 0;
    public static enum SortType{
	NAME, WEIGHT
    }

    private class Handler extends Thread{
	int id;
	LinkedList<Animal> animals;
	public void run(){
    //TODO Handlers and make sure no animal is fed twice
        for(int i = 0; i < animals.size(); i++){
            Animal a = null;
            synchronized(Zoo.this){
                a = animals.get(animalIndex);
                animalIndex++;
            }
            if(a != null){
                System.out.println("Handler " + id + " is feeding " + a.eat() + " to " + a.getName() + " the " + a.getSpecies());
                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){}
            }
        }
    }
	
	public Handler(int id, LinkedList<Animal> animals){
	    this.id = id;
	    this.animals = animals;
	}
    }

    public void feedingTime(int numHandlers){
        //Create numHandlers number of Handlers, start() them, and join() on all of them
        Handler[] handlers = new Handler[numHandlers];
        for(int i = 0; i < numHandlers; i ++){
            handlers[i] = new Handler(i, this.animalLedger);
            handlers[i].start();
        }
        for (int i = 0; i < numHandlers; i++) {
            try {
                handlers[i].join();
            } 
            catch (Exception e) {}
        }
    }  

    
    /**
     *Wrapper for the LinkedList sort
     */
    public void sort(SortType s){
	switch(s){
	case NAME:
	    animalLedger.sort(new AnimalNameComparator());
	case WEIGHT:
	    animalLedger.sort(new AnimalWeightComparator());
	}
    }
    
    /**
     * Returns a copy of the underlying LinkedList
     * @return copy of the animals LinkedList
     */
    public LinkedList<Animal> getLedgerCopy(){
        return new LinkedList<Animal>(this.animalLedger);
    }

    
    /**
     * Adds an Animal to the animals list (All animals must have unique names (i.e., I can't have two Animals named Jim at the same time))
     *@param givenAnimal Animal to be added to the animals list
     *@return whether the animal was added to the list or not
     */
    public boolean addAnimal(Animal givenAnimal){
	return animalLedger.append(givenAnimal);
    }

    /**
     * Takes an array of Animals and adds each one to the animals list
     *@param animalArr a simple Array of type Animal containing Animals to be added to the animals list 
     *@return whether all of the animals were added to the list or not
     * 
     */
    public boolean addAnimal(Animal[] animalArr){
	boolean missedAdd = false;
	for(int i = 0; i < animalArr.length; i++){
	    missedAdd =  ( missedAdd | !animalLedger.append(animalArr[i]) );
	}
	return !missedAdd;
    }

    /**
     * Adds the total weight of the Zoo 
     *@return the weight of the animals in the Zoo
     * 
     */
    public int totalWeight(){
	int total = 0;
	for(Animal a : animalLedger){
	    total += a.getWeight();
	}
	return total;
    }

    /**
     * Adds the total number of legs in the Zoo 
     *@return the number of legs in the Zoo
     * 
     */
    public int totalLegs(){
	int total = 0;
	for(Animal a : animalLedger){
	    total += a.numLegs();
	}
	return total;	
    }
    
    
    /**
     * Constructs a Zoo object with a given LinkedList of Animals
     *@param givenAnimals an LinkedList of Animal types
     */
    public Zoo(LinkedList<Animal> givenAnimals){
	this.animalLedger = new LinkedList<Animal>(givenAnimals);
    }
    /**
     *Constructs a Zoo object with an initial Animal
     *@param singleAnimal an initial Animal to put in the Zoo
     */
    public Zoo(Animal singleAnimal){
	this.animalLedger = new LinkedList<Animal>();
	this.animalLedger.append(singleAnimal);
    }
    /**
     *Constructs an empty Zoo object with an empty ArrayList of Animals
     */
    public Zoo(){
	this.animalLedger = new LinkedList<Animal>();
    }

    public Zoo(String fileName){
	this.animalLedger = new LinkedList<Animal>();
    String line = "";
	//TODO: Build a Zoo from an input csv
    try{
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while((line = br.readLine()) != null){
            String[] values = line.split(",");
            String animalType = values[0];
            String animalName = values[1];
            
             switch(animalType){
                case "Lion":
                    Lion newLion = new Lion(animalName);
                    this.animalLedger.append(newLion);
                    break;
                case "Giraffe":
                    Giraffe newGiraffe = new Giraffe(animalName);
                    this.animalLedger.append(newGiraffe);
                    break;
                case "Parrot":
                    Parrot newParrot = new Parrot(animalName);
                    this.animalLedger.append(newParrot);
                    break;
                case "Penguin":
                    Penguin newPenguin = new Penguin(animalName);
                    this.animalLedger.append(newPenguin);
                    break;
                case "Clownfish":
                    Clownfish newClownfish = new Clownfish(animalName);
                    this.animalLedger.append(newClownfish);
                    break;
                case "Eel":
                    Eel newEel = new Eel(animalName);
                    this.animalLedger.append(newEel);
                    break;
                case "Iguana":
                    Iguana newIguana = new Iguana(animalName);
                    this.animalLedger.append(newIguana);
                    break;
                case "Snake":
                    Snake newSnake = new Snake(animalName);
                    this.animalLedger.append(newSnake);
                    break;
             }
        }
        br.close();
    }
    catch(Exception e){
        System.out.println(e);
    }
    }
    
}
