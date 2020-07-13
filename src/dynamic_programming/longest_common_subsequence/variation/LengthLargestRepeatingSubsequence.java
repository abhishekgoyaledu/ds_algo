package dynamic_programming.longest_common_subsequence.variation;

public class LengthLargestRepeatingSubsequence {
    public static void main(String[] args) {
        String s = "aaiugkjbbkjbbbeejhrehrkwjeeeeerwerwrrrrkkkfcc";
        System.out.println(new LengthLargestRepeatingSubsequence().largestRepeatingSubSequenceTopDown(s, s));
    }

    //TopDown Approach
    public int largestRepeatingSubSequenceTopDown(String x, String y) {
        int n = x.length();
        int m = y.length();
        int [][]t = new int[n + 1][m + 1];
        for(int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if(x.charAt(i-1) == y.charAt(j-1) && i != j){
                    t[i][j] = 1 + t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[n][m];
    }
}
