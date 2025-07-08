package patterns.PrefixSum;

class NumArray {
    int[] aux;

    public NumArray(int[] nums) {
        aux = new int[nums.length];
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            aux[i] = nums[i]+ s;
            s = aux[i];
        }

    }
    public int sumRange(int left, int right) {
        if(left == 0) return aux[right];
        else return aux[right] - aux[left-1];
    }
    //LeetCode-303. Range Sum Query - Immutable
    public static void main(String[] args) {
        // Array de entrada
        int[] nums = {1,2,3,4,5,6};

        // Inicializa a estrutura de dados
        NumArray numArray = new NumArray(nums);

        // Exemplos de chamadas sumRange
        System.out.println(numArray.sumRange(1, 2));  // Deve imprimir 1  (-2 + 0 + 3)

    }
}