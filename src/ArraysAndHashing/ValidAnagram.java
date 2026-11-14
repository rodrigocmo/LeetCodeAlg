package ArraysAndHashing;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {

    }

        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            char[] sSort = s.toCharArray();//ordena e compara
            char[] tSort = t.toCharArray();
            Arrays.sort(sSort);
            Arrays.sort(tSort);
            return Arrays.equals(sSort, tSort);
        }

}
