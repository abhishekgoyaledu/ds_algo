package learning.dynamic_programming.knapsack01;

public class Knapsack01 {

    public static void main(String... args) {
        int []wt = {1, 4, 6, 5, 8, 12, 2, 21};
        int []value = {10, 5, 91, 13, 24, 51, 2, 12};
        int W = 24;
        System.out.println(new Knapsack01().maxProfit(wt, value, W, wt.length));
        int [][]t = new int[wt.length + 1][W+1];
        System.out.println(new Knapsack01().maxProfitMemoization(wt, value, W, wt.length, t));
        System.out.println(new Knapsack01().maxProfitTopDown(wt, value, W, wt.length));
    }

    //Recursion
    public int maxProfit(int []wt, int []value, int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (wt[n-1] <= W) {
            return Math.max(value[n-1] + maxProfit(wt, value, W - wt[n-1], n-1), maxProfit(wt, value, W, n-1));
        } else {
            return maxProfit(wt, value, W, n-1);
        }
    }

    //Memoization
    public int maxProfitMemoization(int []wt, int []val, int W, int n, int [][]t) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (t[n-1][W] != 0) {
            return t[n-1][W];
        }
        if (wt[n-1] <= W) {
            t[n-1][W] = Math.max(val[n-1] + maxProfitMemoization(wt, val, W - wt[n-1], n-1, t), maxProfitMemoization(wt, val, W, n-1, t));
        } else {
            t[n-1][W] = maxProfitMemoization(wt, val, W, n-1, t);
        }
        return t[n-1][W];
    }

    //TopDown Approach
    public int maxProfitTopDown(int []wt, int []val, int W, int n) {
        int [][]t = new int[n+1][W+1];
        for (int i = 1; i < n+1; i++) {
            for(int j = 1; j < W+1; j++) {
                if (wt[i-1] <= j){
                    t[i][j] = Math.max(val[i-1] + t[i-1][j - wt[i - 1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][W];
    }
}
