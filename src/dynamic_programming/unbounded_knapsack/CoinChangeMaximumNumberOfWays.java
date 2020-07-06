package dynamic_programming.unbounded_knapsack;

public class CoinChangeMaximumNumberOfWays {

    static int count = 0;
    public static void main(String[] args) {
        int []coins = {1, 2, 3};
        int sum = 5;
        new CoinChangeMaximumNumberOfWays().maxNumberOfWaysRecursive(coins, sum, coins.length);
        System.out.println(count);
        System.out.println(new CoinChangeMaximumNumberOfWays().maxNumberOfWaysTopDown(coins, sum));
    }

    //Recursive code
    public void maxNumberOfWaysRecursive(int[] coins, int sum, int n) {
        if (n == 0) {
            if(sum == 0)
                ++count;
            return;
        }
        if(coins[n - 1] <= sum) {
            maxNumberOfWaysRecursive(coins, sum - coins[n-1], n);
        }
        maxNumberOfWaysRecursive(coins, sum, n - 1);
    }

    //TopDown
    public int maxNumberOfWaysTopDown(int []coins, int sum) {
        int n = coins.length;
        int [][]t = new int[n + 1][sum + 1];
        for(int i = 0; i < n + 1; i++) {
            t[i][0] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for(int j = 1; j < sum + 1; j++) {
                if(coins[i - 1] <= j) {
                    t[i][j] = t[i][j - coins[i - 1]] + t[i-1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }
}
