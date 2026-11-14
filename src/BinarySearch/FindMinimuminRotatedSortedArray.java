package BinarySearch;

public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {

        //ideia principal de binary search : Imagine que você está procurando uma palavra no dicionário.
        // //Você não começa na página 1 e lê tudo. Você abre no meio, olha onde está e
        // //decide: “a palavra está antes ou depois daqui?”.
        // //Aí joga fora metade do dicionário e repete com a metade que sobrou.

    //OBS : rotated NAOOOOO é o mesmo que ordenado/organizado/misturado, apenas foi movido de posicao pra direita ou esquerda




    }

    class Solution {
        public int findMin(int[] nums) {

            int left = 0;

            int right = nums.length - 1;

            while (left < right) {

                int mid = left + (right - left) / 2; // entender melhor

                if (nums[mid] > nums[right]) {

                    left = mid + 1;
                }

                else {

                    right = mid;
                }
            }
            return nums[left];
        } // falta ver melhor os erros comuns
    }
}
