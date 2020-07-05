package dynamic_programming.knapsack01.variation;

public class SubsetSumProblem {

    public static void main(String... args) {
        int []arr = {1, 2, 7, 9, 5, 3};
        int sum  = 1;
        System.out.println(new SubsetSumProblem().isSubsetSumPresent(arr, sum, arr.length));
        boolean [][]t = new boolean[arr.length + 1][sum + 1];
        System.out.println(new SubsetSumProblem().isSubsetPresentMemoization(arr, sum, arr.length, t));
        System.out.println(new SubsetSumProblem().isSubsetPresentTopDown(arr, sum, arr.length));
    }

    //Recursive code
    public boolean isSubsetSumPresent(int []arr, int sum, int n) {
        if (n == 0 || sum == 0) {
            return false;
        }
        if (arr[n-1] < sum) {
            return isSubsetSumPresent(arr, sum - arr[n-1], n-1) || isSubsetSumPresent(arr, sum, n-1);
        } else if (arr[n-1] > sum){
            return isSubsetSumPresent(arr, sum, n-1);
        } else {
            return true;
        }
    }

    //Memoization
    public boolean isSubsetPresentMemoization(int []arr, int sum, int n, boolean [][]t) {
        if (n == 0 || sum == 0) {
            return false;
        }
        if (t[n-1][sum] != false){
            return t[n-1][sum];
        }
        if(arr[n-1] < sum) {
            t[n][sum] = isSubsetPresentMemoization(arr, sum - arr[n-1], n-1, t) || isSubsetPresentMemoization(arr, sum, n-1, t);
        } else if(arr[n-1] > sum) {
            t[n][sum] = isSubsetPresentMemoization(arr, sum, n-1, t);
        } else {
            t[n][sum] = true;
        }
        return t[n][sum];
    }

    public boolean isSubsetPresentTopDown(int []arr, int sum, int n) {
        boolean [][]t = new boolean[n + 1][sum + 1];
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < sum+1; j++) {
                if (arr[i-1] < j) {
                    t[i][j] = t[i-1][j - arr[i-1]] || t[n-1][j];
                } else if (arr[i-1] > j) {
                    t[i][j] = t[i-1][j];
                } else {
                    t[i][j] = true;
                }
            }
        }
        return t[n][sum];
    }
}
