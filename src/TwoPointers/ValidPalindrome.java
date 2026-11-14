package TwoPointers;

public class ValidPalindrome {
    public static void main(String[] args) {
       System.out.println(isPalindrome("saas"));

    }

    public static boolean isPalindrome(String s) {
        if (s == null) return false;

        int beg = 0;
        int end = s.length() - 1;

        while (beg < end) {
            if (s.charAt(beg) != s.charAt(end)) {
                return false;
            }
            beg++;
            end--;
        }
        return true;
    }

    public static boolean withsb(String s){
        StringBuilder sb = new StringBuilder(s);

        return s.contentEquals(sb.reverse());
    }

}
