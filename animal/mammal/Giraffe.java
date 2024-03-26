package animal.mammal;
import java.util.concurrent.ThreadLocalRandom;
public class Giraffe extends Mammal{
    private String sound;
    public String getSpecies(){
	return this.species;
    }
    
    public String speak(){
	return this.sound;
    }
    public boolean canFly(){
	return false;
    }
    public boolean canSwim(){
	return true;
    }
    public Giraffe(String name){
	super(name);
	this.species = "Giraffe";
	this.diet = Diet.HERBIVORE;
	this.legs = Legs.QUADRUPEDAL;
	this.weight = ThreadLocalRandom.current().nextInt(1800, 2600);
	this.sound = "HUUHUU";
    }
}
