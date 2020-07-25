package learning.dynamic_programming.knapsack01.variation;

public class EqualSumPartitionProblem {

    public static void main(String... args) {
        int []arr = {1, 5, 5, 11, 6, 19, 13};
        System.out.println(new EqualSumPartitionProblem().isEqualSumPartitionSetPresent(arr));
    }

    public boolean isEqualSumPartitionSetPresent(int []arr) {
        int sumOfArray = 0;
        for (int i = 0; i < arr.length; ++i) {
            sumOfArray += arr[i];
        }
        if (sumOfArray % 2 != 0) {
            return false;
        }
        return new SubsetSumProblem().isSubsetPresentTopDown(arr, sumOfArray / 2, arr.length);
    }
}
