package animal.bird;
import java.util.concurrent.ThreadLocalRandom;
public class Parrot extends Bird{
    private String sound;
    public String getSpecies(){
	return this.species;
    }
    
    public String speak(){
	return this.sound;
    }
    public boolean canSwim(){
	return false;
    }
    public Parrot(String name){
	super(name);
	this.species = "Parrot";
	this.diet = Diet.HERBIVORE;
	this.legs = Legs.BIPEDAL;
	this.weight = ThreadLocalRandom.current().nextInt(1, 9);
	this.sound = name + " wants a cracker";
    }
}
