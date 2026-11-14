package ArraysAndHashing;

import java.util.*;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 4, 6})));
    }

    public class Solution {
        public int[] productExceptSelf(int[] nums) { // forca bruta, problema é que percorre todo o array toda vez
            int n = nums.length;
            int[] res = new int[n];

            for (int i = 0; i < n; i++) {
                int prod = 1;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        prod *= nums[j];
                    }
                }
                res[i] = prod;
            }
            return res;
        }
    }

    public int[] productExceptSelf(int[] nums) {

        Map<Integer,Integer> product = new HashMap<>();
        int total = 0;
        for (int n : nums){
            if(total == 0)
                total = n;
            else{
                total = total * n;
            }
        }
        // usar operador *= , e fazer as valiadcoes de 0,

        for (int n : nums)
            product.put(n,total / n);

        System.out.println(product.values());
return null;
    }

    public int[] productExceptSelfOptimal(int[] nums) {
        //envolve fazer 2 arrays, um percorre do i pra esquerda e o outro do i pra direta
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }
}
