package dynamic_programming.longest_common_subsequence.variation;

public class MinInsertionRequiredToMakeStringPalindrome {

    public static void main(String[] args) {
        System.out.println(new MinInsertionRequiredToMakeStringPalindrome().minInsertions("abccded"));
    }

    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        String b = sb.toString();
        int length = longestCommonSubsequenceTopDown(s, b);
        //This is equivalent to number of deletions
        return (s.length() - length);
    }

    //TopDown Approach
    public int longestCommonSubsequenceTopDown(String x, String y) {
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
