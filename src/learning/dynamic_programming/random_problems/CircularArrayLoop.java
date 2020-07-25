package learning.dynamic_programming.random_problems;

public class CircularArrayLoop {

    public static void main(String[] args) {
                    // 0,1, 2, 3, 4
        int []nums = {-1,-2,-3,-4,-5};
        System.out.println(new CircularArrayLoop().circularArrayLoop(nums));
    }
    public boolean circularArrayLoop(int[] nums) {
        int countZeros = 0;
        int n = nums.length;
        boolean backward = false;
        boolean forward = false;
        for(int i = 0; i < nums.length;) {
            if(nums[i] == 0) {
                break;
            }
            int temp = i;
            //use this value for new index
            int value = nums[i];
            while (nums[i] < 0) {
                if(forward)
                    return backward;
                backward = true;
                if (i - Math.abs(nums[i]) < 0) {
                    i = n - Math.abs((i - Math.abs(nums[i])));
                } else {
                    i = Math.abs(i - Math.abs(nums[i]));
                }
            }
            while (nums[i] > 0){
                if(backward)
                    return forward;
                forward = true;
                if(i + nums[i] > nums.length - 1) {
                    i = Math.abs(n - Math.abs(i + nums[i]));
                } else {
                    i = i + nums[i];
                }
            }
            nums[temp] = 0;
            countZeros++;
        }
        if(countZeros == nums.length) {
            return false;
        }
        return true;
    }
}
