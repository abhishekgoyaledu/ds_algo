package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _263A_BeautifulMatrix {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rows = 5;
        int cols = 5;
        int indexOfJ = -1;
        int indexOfI = -1;
        int i;
        for(i = 1; i <= rows; i++) {
            String[] row = br.readLine().split(" ");
            if(indexOfJ == -1) {
                for(int j = 0; j < row.length; j++) {
                    if(row[j].equals("1")) {
                        indexOfJ = j + 1;
                        indexOfI = i;
                        break;
                    }
                }
            }
        }
        System.out.println(Math.abs(3-indexOfJ)+Math.abs(3-indexOfI));
    }
}
