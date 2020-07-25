package learning.dynamic_programming.longest_common_subsequence.variation;

public class LengthLongestCommonSubstring {
    public static void main(String[] args) {
        String x = "abcdge";
        String y = "abdcje";
        System.out.println(new LengthLongestCommonSubstring().longestCommonSubstringTopDown(x, y));
    }

    //TopDown Approach
    public int longestCommonSubstringTopDown(String x, String y) {
        int n = x.length();
        int m = y.length();
        int max = Integer.MIN_VALUE;
        int [][]t = new int[n + 1][m + 1];
        for(int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                    max = Math.max(max, t[i][j]);
                } else {
                    t[i][j] = 0;
                }
            }
        }
        return max;
    }
}
