package learning.dynamic_programming.matrix_chain_multiplication;

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int []arr = {4, 2, 1, 3, 23, 54, 1, 90, 54, 67, 89, 55, 32};
        int [][]t = new int[arr.length + 1][arr.length + 1];
        System.out.println(new MatrixChainMultiplication().getMinCostRecursive(arr, 1, arr.length-1));
        System.out.println(new MatrixChainMultiplication().getMinCostMemoization(arr, 1, arr.length-1, t));
    }

    //Recursive
    int getMinCostRecursive(int []arr, int i, int j){
        if (i >= j) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++) {
            int tempAns = getMinCostRecursive(arr, i, k) + getMinCostRecursive(arr, k+1, j) +
                    (arr[i-1] * arr[k] * arr[j]);
            minCost = Math.min(minCost, tempAns);
        }
        return minCost;
    }

    //Memoization
    int getMinCostMemoization(int []arr, int i, int j, int[][] t){
        if (i >= j) {
            return 0;
        }
        if (t[i][j] != 0) {
            return t[i][j];
        }
        int minCost = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++) {
            int tempAns = getMinCostMemoization(arr, i, k, t) + getMinCostMemoization(arr, k+1, j, t) +
                    (arr[i-1] * arr[k] * arr[j]);
            minCost = Math.min(minCost, tempAns);
            t[i][j] = minCost;
        }
        return t[i][j];
    }
}
