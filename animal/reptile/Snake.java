package animal.reptile;
import java.util.concurrent.ThreadLocalRandom;
public class Snake extends Reptile{
    private String sound;
    public String getSpecies(){
	return this.species;
    }
    
    public String speak(){
	return this.sound;
    }
    public Snake(String name){
	super(name);
	this.species = "Snake";
	this.diet = Diet.CARNIVORE;
	this.legs = Legs.LEGLESS;
	this.weight = ThreadLocalRandom.current().nextInt(1, 500);
	this.sound = "sssss";
    }
}
