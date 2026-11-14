package TwoPointers;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums)); // [[-1, -1, 2], [-1, 0, 1]]
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // PASSO 1: ordenar o array.
        // Sem a ordenação, a técnica de dois ponteiros não funciona, porque ela
        // depende de saber que mover 'left' para a direita AUMENTA a soma e
        // mover 'right' para a esquerda DIMINUI a soma.
        // Ordenar também deixa valores iguais lado a lado, o que facilita
        // pular duplicatas mais adiante.
        // Exemplo: [-1, 0, 1, 2, -1, -4] vira [-4, -1, -1, 0, 1, 2]
        Arrays.sort(nums);

        // PASSO 2: fixar o primeiro número do triplet (nums[i]).
        // O problema vira: "dentro do resto do array, existem dois números
        // que somados dão -nums[i]?" (um 2Sum com array ordenado).
        // O limite é nums.length - 2 porque precisamos de espaço para
        // 'left' e 'right' depois de 'i'.
        for (int i = 0; i < nums.length - 2; i++) {

            // OTIMIZAÇÃO (opcional): early exit.
            // Como o array está ordenado, nums[i] é o MENOR dos três números
            // do triplet atual (left e right sempre vêm depois de i).
            // Se nums[i] já é maior que 0, os três números são positivos e a
            // soma nunca poderá ser 0. Como os próximos i só aumentam, podemos
            // parar o loop inteiro.
            // Isso NÃO assume que o menor valor do array é 0: a condição só
            // dispara quando o valor ATUAL já passou de 0, o que funciona para
            // qualquer entrada.
            // Obs: a condição é '> 0' e não '>= 0', porque [0, 0, 0] é um
            // triplet válido.
            if (nums[i] > 0) break;

            // PULAR DUPLICATAS DO ELEMENTO FIXO.
            // Se nums[i] for igual ao anterior, já exploramos todos os triplets
            // que começam com esse valor na iteração passada. Repetir geraria
            // triplets duplicados na resposta.
            // Exemplo: em [-4, -1, -1, 0, 1, 2], quando i = 2 (segundo -1),
            // pulamos, pois o primeiro -1 (i = 1) já encontrou
            // [-1, -1, 2] e [-1, 0, 1].
            // Usamos 'i > 0' para não acessar nums[-1].
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // PASSO 3: configurar os dois ponteiros.
            // 'left' começa logo depois de i; 'right' começa no fim do array.
            // Os dois vão se aproximando até se cruzarem.
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Achamos um triplet válido: guardamos no resultado.
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Depois de achar uma solução, movemos AMBOS os ponteiros.
                    // Mover só um não adiantaria: com i fixo e um dos outros
                    // dois inalterado, o terceiro valor necessário seria o
                    // mesmo, então só encontraríamos a mesma solução de novo.
                    left++;
                    right--;

                    // PULAR DUPLICATAS DOS PONTEIROS.
                    // Se o novo 'left' tem o mesmo valor do anterior, ele
                    // formaria o mesmo triplet. Avançamos até um valor novo.
                    // Exemplo: [-2, 0, 0, 2, 2] com i em -2: depois de achar
                    // [-2, 0, 2], sem esse pulo acharíamos [-2, 0, 2] de novo
                    // com o segundo 0 e o segundo 2.
                    // A checagem 'left < right' evita que os ponteiros se
                    // cruzem durante o pulo.
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (sum < 0) {
                    // Soma muito PEQUENA: precisamos de um valor maior.
                    // Como o array é ordenado, mover 'left' para a direita
                    // pega um número maior ou igual, aumentando a soma.
                    left++;

                } else {
                    // Soma muito GRANDE: precisamos de um valor menor.
                    // Mover 'right' para a esquerda pega um número menor ou
                    // igual, diminuindo a soma.
                    right--;
                }
            }
        }

        // Se nenhum triplet foi encontrado, retorna lista vazia (não null).
        return result;
    }
}