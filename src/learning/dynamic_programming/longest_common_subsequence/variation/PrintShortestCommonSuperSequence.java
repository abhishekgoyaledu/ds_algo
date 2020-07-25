package learning.dynamic_programming.longest_common_subsequence.variation;

public class PrintShortestCommonSuperSequence {

    public static void main(String... agrs) {
        String a = "abcdef";
        String b = "acfghi";
        new PrintShortestCommonSuperSequence().lengthOfLongestCommonSequence(a, b);
    }

    public void lengthOfLongestCommonSequence(String a, String b){
        int n = a.length();
        int m = b.length();
        int [][]t = new int[a.length() + 1][b.length() + 1];
        for(int i = 1; i < a.length() + 1; i++) {
            for(int j = 1; j < b.length() + 1; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = t[i-1][j-1] + 1;
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        String shortestCommonSuperSeq = "";
        int i = n;
        for(int j = m; j > 0;) {
            if(a.charAt(i-1) == b.charAt(j-1)){
                shortestCommonSuperSeq += a.charAt(i-1);
                i--;
                j--;
            } else if (t[i-1][j] > t[j-1][i]) {
                shortestCommonSuperSeq += a.charAt(i-1);
                i--;
            } else {
                shortestCommonSuperSeq += b.charAt(j-1);
                j--;
            }
        }
        System.out.println("shortest super sequence : " + new StringBuilder(shortestCommonSuperSeq).reverse().toString());
    }
}
