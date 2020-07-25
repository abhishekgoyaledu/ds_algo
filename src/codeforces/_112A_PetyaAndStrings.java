package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _112A_PetyaAndStrings {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstString = br.readLine().toLowerCase();
        String secondString = br.readLine().toLowerCase();
        for(int i = 0; i < firstString.length(); i++) {
            if(firstString.charAt(i) < secondString.charAt(i)) {
                System.out.println("-1");
                return;
            } else if(firstString.charAt(i) > secondString.charAt(i)) {
                System.out.println("1");
                return;
            }
        }
        System.out.println(0);
    }
}
