//"package" helps java link files together (recall import animal.*)  
package animal;
public interface Animal{
    public enum Diet{
	HERBIVORE, CARNIVORE, OMNIVORE 
    }
    public enum Legs{
	LEGLESS, BIPEDAL, QUADRUPEDAL
    }
    String getName(); //Return the animal's name
    String getAnimalClass(); //Return the animal's class
    String getSpecies(); //Return the animal's species
    int getWeight(); //Return the animal's weight
    String speak(); //Should return what the animal "says"  
    boolean canFly(); //Should return true if the animal can fly
    boolean canSwim(); //Should return true if the animal can swim
    String breathe(); //Should return what fluid the animal breathes
    String eat(); //Should return the type of food the animal likes to eat (plants, meat, plants and meat) 
    int numLegs(); //Shoudl return the number of legs that animal has
}
