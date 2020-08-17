import java.io.PrintWriter;

public class Robin_StockBot {
    static final PrintWriter pw = new PrintWriter(System.out);

    int maxRevenue(int[] prices, int[] algo, int k) {
        int res = 0;

        int originalR = 0;
        int max = 0;
        int cur = 0;
        int maxI = 0;
        for (int i = 0; i < prices.length; i ++) {
            if (algo[i] == 0) {
                originalR -= prices[i];
            } else {
                originalR += prices[i];
            }
            if (i < k) {
                cur += buyPrice(prices, algo, i);
            } else {
                cur += buyPrice(prices, algo, i) - buyPrice(prices, algo, i - k);
            }
            max = Math.max(max, cur);
        }

        return originalR + max;
    }

    int buyPrice(int[] prices, int[] algo, int i) {
        return algo[i] == 0 ? prices[i] * 2 : 0;
    }

    public static void main(String[] args) {
        int[] prices = {2, 4, 1, 5, 2, 6, 7};
        int[] algo = {0, 1, 0, 0, 1, 0, 0};
        Robin_StockBot t = new Robin_StockBot();

        pw.println(t.maxRevenue(prices, algo, 4));

        pw.flush();
        pw.close();
    }
}
