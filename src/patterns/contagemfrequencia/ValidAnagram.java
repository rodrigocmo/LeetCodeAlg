package patterns.contagemfrequencia;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram{
    public static void main(String[] args) {
        var c = new ValidAnagram();
        System.out.println(c.isAnagramSimples("car","rac"));
    }

    public boolean isAnagramSimples(String s, String t) {

        char [] a =  s.toCharArray();
        char [] b =  t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a,b);
    }

    public boolean contagemDeFrequencia(String s, String t) {

            if (s.length() != t.length()) {
                return false;
            } // ja discarta se nao tiver mesmo tamanho

            int[] count = new int[26]; // 26 letras do alfabeto , nao funciona bem com outros caracteres

            for (int i = 0; i < s.length(); i++) { //
                count[s.charAt(i) - 'a']++;
                count[t.charAt(i) - 'a']--;
            }

            for (int c : count) {
                if (c != 0) {
                    return false;
                }
            }

            return true;
        }

        //solucao com map funciona para qualquer caracter

    public boolean frequenciaComMap(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> count = new HashMap<>();

        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);// adiciona com default + 1 se nao existir, se nao so add +!
        }

        for (char c : t.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) - 1); // tem que ser negativo pq o objetivo é chegar a 0 para validar
        }

        for (int value : count.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
}
