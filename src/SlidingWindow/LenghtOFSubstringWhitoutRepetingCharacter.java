package SlidingWindow;

import java.util.HashSet;
import java.util.List;

public class LenghtOFSubstringWhitoutRepetingCharacter {


    public static void main(String[] args) {
        //tive dificuldade eme tender esse sliding window
    }

    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();


        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) { // pensa realmente na janela ou seja {}, aqui voce comeca com o left { no 0 e o right } no 0 tbm
            char c = s.charAt(right);

            while (set.contains(c)) {// se c ja estiver no set, achamo uma duplicata

                set.remove(s.charAt(left));//entao removemos o indice mais perto do left {

                left++;//para conseguirmos mover o left { para direita , e como tem while vai fazer isso ate achar uma
                //janela [] que nao tenha duplicados
            }

            set.add(c);

            max = Math.max(max, right - left + 1);// +1 é pq indice é inclusivo
        }

        return max;

}}
