package animal.fish;
import animal.Animal;
public abstract class Fish implements Animal{
    protected Diet diet;
    protected Legs legs;
    protected String name;
    protected int weight;
    protected String species;
    
    public Fish(String n){
	this.name = n;
    }

    public String getAnimalClass(){
	return "Fish";
    }
    
    public String getName(){
	return this.name;
    }

    public int getWeight(){
	return this.weight;
    }
    
    public String breathe(){
	return "water";
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
        return 0;
    }
    public boolean canFly(){
	return false;
    }
    public boolean canSwim(){
	return true;
    }
}
