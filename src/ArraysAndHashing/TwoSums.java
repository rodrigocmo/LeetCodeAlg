package ArraysAndHashing;

import java.util.HashMap;

public class TwoSums {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int valorAtual = nums[i];
            int diff = target - valorAtual; // calcula o que falta para dar o target

            if (prevMap.containsKey(diff)) {//o diff é o que falta, se algu  numero antes ja adicionou o diff no map voce so busca ele e o indice dele
                return new int[] { prevMap.get(diff), i };//usa a chave (que ta o valor daquele i) para pegar o i
            }

            prevMap.put(valorAtual, i); // adiciona o valor atual e qual indice ele ta no map,
        }

        //OBS: ficaria menos confuso se guardasse o indice como chave e buscasse se o valor ja passou , mas voce perde toda vantagem do desempenho, o hashmap procura rapido
        //justamente pela chave
        return new int[] {};
    }
}
