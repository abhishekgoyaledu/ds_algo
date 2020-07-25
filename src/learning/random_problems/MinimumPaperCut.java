package learning.random_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumPaperCut {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        System.out.println(new MinimumPaperCut().minimumPaperCut(A, B));
    }

    public int minimumPaperCut(int i, int j) {
        if (i == j) {
            return 1;
        }
        int minimumCut = 0;
        while (i > 0 && j > 0 && i != j) {
            if (i < j) {
                j = j - i;
            } else {
                i = i - j;
            }
            minimumCut++;
        }
        if (i == j) {
            minimumCut++;
        }
        return minimumCut;
    }
}
