package SlidingWindow;

public class BestTimeToBuySell {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {
        return 0;
    }

    public int maxProfit(int[] prices) {
        int maxP = 0;
        int minBuy = prices[0];

        for (int sell : prices) {
            maxP = Math.max(maxP, sell - minBuy);
            minBuy = Math.min(minBuy, sell);
        }
        return maxP;
    }
}
