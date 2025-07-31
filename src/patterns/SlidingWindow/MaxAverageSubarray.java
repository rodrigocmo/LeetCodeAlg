package patterns.SlidingWindow;

public class MaxAverageSubarray {

    public static double findMaxAverage(int[] nums, int k) {
        //k é o numero maximo de elementos continuos

        // Armazena a soma da janela atual de tamanho k
        double currentSum = 0;

        // Armazena a maior soma encontrada entre todas as janelas
        double maxSum = 0;

        // Passo 1: Calcula a soma dos k primeiros elementos (primeira janela)
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        // Inicializa maxSum com a soma da primeira janela
        maxSum = currentSum;

        // Passo 2: Move a janela da esquerda para a direita, uma posição por vez
        for (int i = k; i < nums.length; i++) {
            // Subtrai o valor que saiu da janela (à esquerda)
            // Adiciona o valor que entrou na janela (à direita)
            currentSum = currentSum - nums[i - k] + nums[i];

            // Atualiza a maior soma, se necessário
            maxSum = Math.max(maxSum, currentSum);
        }

        // Passo 3: Retorna a média máxima (soma máxima dividida pelo tamanho da janela)
        return maxSum / k;
    }

    // Método principal para testar
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int k = 4;

        // Chama a função e imprime a média máxima
        double resultado = findMaxAverage(nums, k);
        System.out.println("Maior média de subarray de tamanho " + k + " é: " + resultado);
    }
}