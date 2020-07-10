package dynamic_programming.random_problems;

//https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
public class MaxArraySum {

    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int []arr = {2 ,1 ,5 ,8 ,4};
//        new MaxArraySum().maxSubsetSum(arr, 0, 0);
        int[]t = new int[arr.length + 1];
        System.out.println(new MaxArraySum().maxSubsetSumMemo(arr, 0, 0, t));
    }

    //Recursive
    public void maxSubsetSum(int []arr, int n, int sum) {
        if (n >= arr.length) {
            if (sum > max) {
                max = sum;
            }
            return;
        }
        maxSubsetSum(arr, n + 2, sum + arr[n]);
        maxSubsetSum(arr, n + 1, sum);
    }

    //Memoization
    public int maxSubsetSumMemo(int []arr, int n, int sum, int []t) {
        if (n >= arr.length) {
            if (sum > max) {
                t[n] = sum;
                max = sum;
            }
            return max;
        }
        if (t[n] != 0) {
            return t[n];
        }
        t[n+2] = Math.max(maxSubsetSumMemo(arr, n + 2, sum + arr[n], t),
        t[n+1] = maxSubsetSumMemo(arr, n + 1, sum, t));
        return 0;
    }
}
