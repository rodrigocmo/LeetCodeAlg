package ArraysAndHashing;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveSequencia {
    public static void main(String[] args){

    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {// o contains so pergunta, ele existe no set? independente da ordem, nesse caso ele procura o primeiro numero da sequenncia
                int length = 1;
                while (numSet.contains(num + length)) {//achou o primeiro numero ele vai procurando a sequencia dele
                    length++;
                }
                longest = Math.max(longest, length);//aqui ele grava no logest a maior sequencia desse for(lenght), no proximo for ele compara o longest com o length desse for
            }
        }
        return longest;
    }
}

