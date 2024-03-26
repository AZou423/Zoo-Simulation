package animal.reptile;
import animal.Animal;
public abstract class Reptile implements Animal{
    protected Diet diet;
    protected Legs legs;
    protected String name;
    protected int weight;
    protected String species;
    
    public Reptile(String n){
	this.name = n;
    }

    public String getAnimalClass(){
	return "Reptile";
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

    public boolean canFly(){
	return false;
    }
    public boolean canSwim(){
	return true;
    }
}
