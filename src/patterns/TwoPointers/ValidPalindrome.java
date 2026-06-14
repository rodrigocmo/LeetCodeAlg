package patterns.TwoPointers;
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("rar"));

    }

    public static void withStringBuilder(){
        StringBuilder sb = new StringBuilder("rar");
        System.out.println(sb.toString().contentEquals(sb.reverse()));
    }

    public static boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;

            while (left < right) {
                while (left < right && !Character.isLetterOrDigit(s.charAt(left)))//pula o ponteiro em caso de nao ser letra
                    left++;
                while (left < right && !Character.isLetterOrDigit(s.charAt(right)))// mesma coisa
                    right--;

                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))// faz a comparacao verdadeira
                    return false;

                left++;
                right--;
            }

            return true;
        }

}
