package ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {


    }

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>(); //guarda apenas unicos,comeca vazio
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);//vai adicionando na lista, ja que so tem unicos, na primeira vez ele so adiciona, e ai quando bate no contains denovo ele acha
        }
        return false;
    }
}


