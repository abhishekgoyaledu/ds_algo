package dynamic_programming.longest_common_subsequence.variation;

import dynamic_programming.longest_common_subsequence.LengthLongestCommonSubsequence;

//Minimum number of insertion and deletion required to convert string A --> string B
public class ConvertStringAtoB {

    public static void main(String... args) {
        String a = "heap";
        String b = "pea";
        int longestCommonSubsequenceLength = new LengthLongestCommonSubsequence().longestCommonSubsequenceTopDown(a, b);
        System.out.println("Minimum number of deletion required : " + (a.length()-longestCommonSubsequenceLength));
        System.out.println("Minimum number of insertion required : " + (b.length() - longestCommonSubsequenceLength));
    }
}
