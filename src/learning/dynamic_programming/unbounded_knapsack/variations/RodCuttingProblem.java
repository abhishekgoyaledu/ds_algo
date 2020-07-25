package learning.dynamic_programming.unbounded_knapsack.variations;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int []length ={1, 2, 3, 4, 5, 6, 7, 8, 9};
        int []price = {1, 5, 8, 9, 12, 2, 14, 1, 23};
        int N = 15;
        System.out.println(new RodCuttingProblem().maxProfitRecursive(length, price, N, length.length));
        System.out.println(new RodCuttingProblem().maxProfitTopDown(length, price, N));
    }

    //Recursive
    public int maxProfitRecursive(int[] length, int []price, int N, int n) {
        if (N == 0 || n == 0) {
            return 0;
        }
        if (length[n - 1] <= N) {
            return Math.max(price[n-1] + maxProfitRecursive(length, price, N - length[n-1], n),
                                maxProfitRecursive(length, price, N, n - 1));
        } else {
            return maxProfitRecursive(length, price, N, n - 1);
        }
    }

    //TopDown Solution
    public int maxProfitTopDown(int[] length, int []price, int N){
        int n = length.length;
        int [][]t = new int[n + 1][N+1];
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < N + 1; j++) {
                if (length[i - 1] <= j) {
                    t[i][j] = Math.max(price[i-1] + t[i][j - length[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][N];
    }
}
