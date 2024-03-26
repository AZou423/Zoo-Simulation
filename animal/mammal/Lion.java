package animal.mammal;
import java.util.concurrent.ThreadLocalRandom;
public class Lion extends Mammal{
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
    public Lion(String name){
	super(name);
	this.species = "Lion";
	this.diet = Diet.CARNIVORE;
	this.legs = Legs.QUADRUPEDAL;
	this.weight = ThreadLocalRandom.current().nextInt(250, 500);
	this.sound = "ROAR";
    }
}
