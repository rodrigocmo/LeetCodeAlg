package ArraysAndHashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
    public static void main(String[] args) {

        List<String> normal = new ArrayList<>();
        normal.add("abacate");
        normal.add("peixe");
        normal.add("carne");

        new EncodeDecode().encode(normal);
        System.out.println(new EncodeDecode().decode(new EncodeDecode().encode(normal)));

    }

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j)); // aqui o substring esta retornando o numero concatenado antes da #
            i = j + 1;       // i = 2 (começo da palavra, logo depois do '#')
            j = i + length;  // j = 7 (fim da palavra)(afinal o numero do encode é a lenght da palavra)
            res.add(str.substring(i, j));  // substring(2, 7) = "hello"
            i = j;           // i = 7, começa a próxima palavra
        }
        return res;
    }
}
