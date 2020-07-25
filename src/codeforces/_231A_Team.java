package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _231A_Team {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int noOfProblems = 0;
        for(int i = 0; i < T; i++) {
            String[] str = br.readLine().split(" ");
            int indiCount = 0;
            for(int j = 0; j < str.length; j++) {
                if(str[j].equals("1")){
                    indiCount++;
                }
            }
            if (indiCount >= 2){
                noOfProblems++;
            }
        }
        System.out.println(noOfProblems);
    }
}
