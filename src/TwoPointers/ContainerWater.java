package TwoPointers;

import java.util.*;

public class ContainerWater {
    public static void main(String[] args) {
    }
    public class Solution {
        public int maxArea(int[] heights) {
            int l = 0;
            int r = heights.length - 1;
            int res = 0;

            while (l < r) {
                int area = Math.min(heights[l], heights[r]) * (r - l);
                res = Math.max(res, area);
                if (heights[l] <= heights[r]) {//segredo ta aqui, voce so movimenta o ponteiro da parede menor, o <= é por que se as duas forem iguais tanto faz qual movimentar
                    l++;
                } else {
                    r--;
                }
            }
            return res;
        }
    }

}
