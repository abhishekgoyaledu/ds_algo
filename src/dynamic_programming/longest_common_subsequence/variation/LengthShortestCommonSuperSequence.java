package dynamic_programming.longest_common_subsequence.variation;

public class LengthShortestCommonSuperSequence {
    public static void main(String[] args) {
        String a = "AGGTAB";
        String b = "GXTXAYB";
        int lengthOfLongestCommonSeq = new LengthShortestCommonSuperSequence().lengthOfLongestCommonSequence(a, b);
        System.out.println(lengthOfLongestCommonSeq);
        System.out.println("Length of shortest common super sequence : " + ((a.length() + b.length()) - lengthOfLongestCommonSeq));
    }

    public int lengthOfLongestCommonSequence(String a, String b){
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
        return t[a.length()][b.length()];
    }
}
