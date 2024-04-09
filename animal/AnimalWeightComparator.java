package animal;
import java.util.Comparator;
public class AnimalWeightComparator implements Comparator<Animal>{
    public int compare(Animal a1, Animal a2){
        if(a1.getWeight() > a2.getWeight()){
	    return 1;
	}else if(a1.getWeight() == a2.getWeight()){
	    return 0;
	}
	return -1;
    }
}
