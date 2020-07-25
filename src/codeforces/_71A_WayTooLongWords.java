package codeforces;

import java.util.Scanner;

public class _71A_WayTooLongWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            String word = sc.next();
            int lengthOfWord = word.length();
            if (lengthOfWord > 10) {
                System.out.println(word.charAt(0) + "" + (word.length() - 2) + "" + word.charAt(word.length()-1));
            } else {
                System.out.println(word);
            }
        }
    }
}
