package dynamic_programming.knapsack01.variation;

public class CountNumberOfSubsetSum {
    static int count = 0;
    public static void main(String... args) {
        int []arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        new CountNumberOfSubsetSum().countNumberOfSubsetRecursive(arr, sum, arr.length);
        System.out.println(count);
        int [][]t = new int[arr.length + 1][sum + 1];
        for (int i = 0; i < t.length; i++) {
            t[i][0] = 1;
        }
        System.out.println(new CountNumberOfSubsetSum().countNumberOfSubsetMemoization(arr, sum, arr.length, t));
    }

    //Recursive
    public void countNumberOfSubsetRecursive(int []arr, int sum, int n) {
        if(n == 0) {
            if (sum == 0){
                ++count;
            }
            return;
        }
        if (arr[n-1] <= sum) {
            countNumberOfSubsetRecursive(arr, sum - arr[n-1], n - 1);
        }
        countNumberOfSubsetRecursive(arr, sum, n - 1);
    }

    //TopDown
    public int countNumberOfSubsetMemoization(int []arr, int sum, int n, int [][]t) {
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < sum + 1; j++) {
                if (arr[i-1] <= j) {
                    t[i][j] = t[i-1][j - arr[i-1]] + t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
