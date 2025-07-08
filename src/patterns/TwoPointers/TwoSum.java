package patterns.TwoPointers;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
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
