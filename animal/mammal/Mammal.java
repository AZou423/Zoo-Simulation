package animal.mammal;
import animal.Animal;
public abstract class Mammal implements Animal{
    protected Diet diet;
    protected Legs legs;
    protected String name;
    protected int weight;
    protected String species;
    
    public Mammal(String n){
	this.name = n;
    }

    public String getAnimalClass(){
	return "Mammal";
    }
    
    public String getName(){
	return this.name;
    }

    public int getWeight(){
	return this.weight;
    }
    
    public String breathe(){
	return "air";
    }
    public String eat(){
	switch(diet){
	case HERBIVORE:
	    return "plants";
	case CARNIVORE:
	    return "meat";
	case OMNIVORE:
	}
	return "plants and meat";
    }
    public int numLegs(){
        switch(legs){
	case LEGLESS:
	    return 0;
	case BIPEDAL:
	    return 2;
	case QUADRUPEDAL:
	}
	return 4;
    }
        
}
