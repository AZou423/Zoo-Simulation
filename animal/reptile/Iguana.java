package animal.reptile;
import java.util.concurrent.ThreadLocalRandom;
public class Iguana extends Reptile{
    private String sound;
    public String getSpecies(){
	return this.species;
    }
    
    public String speak(){
	return this.sound;
    }
    public Iguana(String name){
	super(name);
	this.species = "Iguana";
	this.diet = Diet.HERBIVORE;
	this.legs = Legs.QUADRUPEDAL;
	this.weight = ThreadLocalRandom.current().nextInt(1, 17);
	this.sound = "eheheheh";
    }
}
