package animal;
import java.util.Comparator;
public class AnimalNameComparator implements Comparator<Animal>{
    //We'll sort animals by their name
    public int compare(Animal a1, Animal a2){
	return a1.getName().compareTo(a2.getName());
    }
}
