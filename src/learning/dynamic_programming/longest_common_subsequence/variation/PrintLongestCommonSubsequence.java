package learning.dynamic_programming.longest_common_subsequence.variation;

public class PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        String x = "ezupkrpg";
        String y = "ubmrapg";
        new PrintLongestCommonSubsequence().printLongestCommonSubsequenceTopDown(x, y);
    }
    //TopDown Approach
    public void printLongestCommonSubsequenceTopDown(String x, String y) {
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
        //abc = 0, 1, 2, 3 --> 4
        //bcf = 0, 1, 2, 3
        String sequence = "";
        int i = n;
        for(int j = m; j != 0;) {
            if(x.charAt(i-1) == y.charAt(j-1)) {
                sequence += x.charAt(i-1);
                i--; j--;
            } else {
                if(t[i-1][j] > t[i][j-1]){
                    i--;
                } else {
                    j--;
                }
            }
        }
        System.out.println(new StringBuilder(sequence).reverse().toString());
    }
}
