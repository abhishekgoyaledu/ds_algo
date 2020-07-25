package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _158A_NextRound {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int benchMarkIndex = Integer.parseInt(inputs[1]);
        String[] str = br.readLine().split(" ");
        int benchMark = Integer.parseInt(str[benchMarkIndex-1]);
        int nextRoundQualifiersCount = 0;
        for(int i = 0; i < str.length; i++) {
            int score = Integer.parseInt(str[i]);
            if (score >= benchMark && score != 0) {
                nextRoundQualifiersCount++;
            }
        }
        System.out.println(nextRoundQualifiersCount);
    }
}
