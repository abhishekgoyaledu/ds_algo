package dynamic_programming.longest_common_subsequence;

import java.util.HashMap;

// x :- abcdgh
// y :- abjdoh
// o/p :- 4 (why? ~ abdh are common)
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String x = "ezupkr";
        String y = "ubmrapg";
        System.out.println(new LongestCommonSubsequence().longestIncrSubsequenceRecursive(x, y, x.length(), y.length()));
        System.out.println(new LongestCommonSubsequence().longestIncrSubsequenceTopDown(x, y));
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(x, y));
    }

    //Recursive
    public int longestIncrSubsequenceRecursive(String x, String y, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if(x.charAt(n-1) == y.charAt(m-1)) {
            return 1 + longestIncrSubsequenceRecursive(x, y, n - 1, m - 1);
        } else {
            return Math.max(longestIncrSubsequenceRecursive(x, y, n - 1, m), longestIncrSubsequenceRecursive(x, y, n, m - 1));
        }
    }

    //TopDown Approach
    public int longestIncrSubsequenceTopDown(String x, String y) {
        int n = x.length();
        int m = y.length();
        int [][]t = new int[n + 1][m + 1];
        for(int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[n][m];
    }
}
