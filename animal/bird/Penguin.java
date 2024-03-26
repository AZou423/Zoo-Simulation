package animal.bird;
import java.util.concurrent.ThreadLocalRandom;
public class Penguin extends Bird{
    private String sound;
    public String getSpecies(){
	return this.species;
    }
    
    public String speak(){
	return this.sound;
    }
    public boolean canSwim(){
	return true;
    }
    public Penguin(String name){
	super(name);
	this.species = "Penguin";
	this.diet = Diet.CARNIVORE;
	this.legs = Legs.BIPEDAL;
	this.weight = ThreadLocalRandom.current().nextInt(2, 88);
	this.sound = "HONK";
    }
}
