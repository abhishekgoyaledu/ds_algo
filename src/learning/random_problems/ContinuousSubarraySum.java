package learning.random_problems;

public class ContinuousSubarraySum {

    static int sum = 0;
    public static void main(String[] args) {
        int nums[] = {23, 2, 4, 6, 7};
        int k = 6;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++){
                if((nums[i] + nums[j]) % k == 0) {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }
}
