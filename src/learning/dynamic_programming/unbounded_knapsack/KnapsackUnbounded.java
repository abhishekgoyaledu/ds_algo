package learning.dynamic_programming.unbounded_knapsack;

//It is same as Knapsack problem however, only difference
//is the supply over here is unlimited.
public class KnapsackUnbounded {

    public static void main(String... args) {
        int []wt = {1, 3, 4, 6};
        int []value = {2, 3, 5, 10};
        int W = 21;
        System.out.println(new KnapsackUnbounded().knapsackUnboundedRecursive(wt, value, W, wt.length));
    }

    //Recursive
    public int knapsackUnboundedRecursive(int []wt, int []val, int W, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if(wt[n-1] <= W) {
            return Math.max(knapsackUnboundedRecursive(wt, val, W, n - 1),
                    val[n - 1] + knapsackUnboundedRecursive(wt, val, W - wt[n-1], n));
        } else {
            return knapsackUnboundedRecursive(wt, val, W, n - 1);
        }
    }
}
