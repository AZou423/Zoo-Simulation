package animal.bird;
import animal.Animal;
public abstract class Bird implements Animal{
    protected Diet diet;
    protected Legs legs;
    protected String name;
    protected int weight;
    protected String species;
    
    public Bird(String n){
	this.name = n;
    }

    public String getAnimalClass(){
	return "Bird";
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
	return 2;
    }

    public boolean canFly(){
	return true;
    }
}
