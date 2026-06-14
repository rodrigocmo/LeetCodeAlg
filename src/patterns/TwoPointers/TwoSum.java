package patterns.TwoPointers;

public class TwoSum {

    public static void main(String[] args) {

    }
        public static int[] twoSumOtimizada(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;

            while (left < right) {
                int sum = numbers[left] + numbers[right];

                if (sum == target) {
                    return new int[]{left + 1, right + 1}; // 1-based
                } else if (sum < target) {
                    left++;   // precisa de valor maior
                } else {
                    right--;  // precisa de valor menor
                }
            }
            return new int[]{};
        }


    public static int[] twoSumOk(int[] nums, int target) {
        int aux = 0;
        int[] fim= new int[2];

            for (int i = 0; i < nums.length; i++){
                for (int j = nums.length-1; j >= 0 ; j--) {
                    aux = nums[i] + nums[j];
                    if(aux == target && i != j)
                       return fim = new int[]{i,j};
                }
            }
        return fim;

    }
}

