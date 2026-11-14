package ArraysAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        // entendendo o enunciado, top k mais frequentes sao os que mais aparecem k vezes, ou seja se k é 2 , sao os 2 numeros que mais aparecem.
        test();
    }

    public static void test() {
        int[] nums = new int[]{1,1,1,2,3,3,5,5,5};
        int k = 2;


        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.merge(n, 1, (old,novo)-> old + novo);
        } // percorre o array colocando o numero como chave e o valor a quantidade de vezes que aparece

// buckets[i] = números que aparecem exatamente i vezes
        List<Integer>[] buckets = new List[nums.length + 1]; // array de lista, cada posicao do array tem uma lista
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            int freq = e.getValue();
            if (buckets[freq] == null)
                buckets[freq] = new ArrayList<>();
            buckets[freq].add(e.getKey());
        }
       // Iteração	número	freq	buckets[freq] é null?	resultado
       // 1	1	3	sim, cria a lista	buckets[3] = [1]
       // 2	2	1	sim, cria a lista	buckets[1] = [2]
       // 3	3	2	sim, cria a lista	buckets[2] = [3]
       // 4	5	3	não, já existe	buckets[3] = [1, 5]
        // o objetivo é ja criar um array onde o indice da array tem uma lista com os valores dos que aparecem , tipo na posicao 3 do array
        //voce grava uma lista com os numeros que aparecem 3 vezes

// percorre do fim(maior indice) (maior frequência) até juntar k elementos
        List<Integer> retorno = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && retorno.size() < k; i--) {
            if (buckets[i] != null)
                retorno.addAll(buckets[i]);
        }

        System.out.println(retorno); // [3, 2]
    }
}

