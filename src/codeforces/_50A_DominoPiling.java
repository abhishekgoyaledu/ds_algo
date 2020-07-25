package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _50A_DominoPiling {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int benchMarkIndex = Integer.parseInt(inputs[1]) * Integer.parseInt(inputs[0]);
        System.out.println(benchMarkIndex/2);
    }
}
