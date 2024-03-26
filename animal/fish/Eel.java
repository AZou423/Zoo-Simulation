package animal.fish;
import java.util.concurrent.ThreadLocalRandom;
public class Eel extends Fish{
    private String sound;
    public String getSpecies(){
	return this.species;
    }
    
    public String speak(){
	return this.sound;
    }
    public Eel(String name){
	super(name);
	this.species = "Eel";
	this.diet = Diet.OMNIVORE;
	this.legs = Legs.LEGLESS;
	this.weight = ThreadLocalRandom.current().nextInt(1, 55);
	this.sound = "bzzz";
    }
}
