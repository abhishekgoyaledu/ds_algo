package dynamic_programming.longest_common_subsequence.variation;

import dynamic_programming.longest_common_subsequence.LengthLongestCommonSubsequence;

public class MinDeletionRequiredToMakeStringPalindromic {

    public static void main(String[] args) {
        String a = "agbcbga";
        StringBuilder sb = new StringBuilder(a);
        sb = sb.reverse();
        String b = sb.toString();
        int length = new LengthLongestCommonSubsequence().longestCommonSubsequenceTopDown(a, b);
        System.out.println("minimum deletion required is : " + (a.length() - length));
    }
}
