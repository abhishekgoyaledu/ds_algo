package learning.dynamic_programming.matrix_chain_multiplication.variations;

public class PalindromicPartitioning {

    public static void main(String[] args) {
        String s = "niti";
        int [][]t = new int[s.length()+1][s.length()+1];
        System.out.println(new PalindromicPartitioning().palindromicPartitioning(s, 0, s.length()-1));
        System.out.println(new PalindromicPartitioning().palindromicPartitioningMemoization(s, 0, s.length()-1, t));
    }

    //Recursive
    public int palindromicPartitioning(String s, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (isPalindromeString(s, i, j))
            return 0;
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j - 1; k++) {
            int tempAns = palindromicPartitioning(s, i, k) +
                                palindromicPartitioning(s, k+1, j) + 1;
            min = Math.min(tempAns, min);
        }
        return min;
    }

    //Memoization
    public int palindromicPartitioningMemoization(String s, int i, int j, int [][]t) {
        if (i >= j) {
            return 0;
        }
        if (isPalindromeString(s, i, j))
            return 0;
        if (t[i][j] != 0) {
            return t[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j - 1; k++) {
            int tempAns = palindromicPartitioningMemoization(s, i, k, t) +
                    palindromicPartitioningMemoization(s, k+1, j, t) + 1;
            min = Math.min(tempAns, min);
            t[i][j] = min;
        }
        return t[i][j];
    }

    public boolean isPalindromeString(String str, int i, int j) {
        if (i == j)
            return true;
        String subString = str.substring(i, j+1);
        if(subString.equals(new StringBuilder(subString).reverse().toString())){
            return true;
        }
        return false;
    }
}
