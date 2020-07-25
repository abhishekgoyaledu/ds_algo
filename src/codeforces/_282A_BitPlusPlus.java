package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _282A_BitPlusPlus {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int value = 0;
        for (int i = 0; i < T; i++) {
            String param = br.readLine();
            if (param.equals("X++") || param.equals("++X")) {
                value++;
            } else {
                value--;
            }
        }
        System.out.println(value);
    }
}
