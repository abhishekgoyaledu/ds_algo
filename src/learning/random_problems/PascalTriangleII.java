package learning.random_problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public static void main(String[] args) {
        System.out.println(new PascalTriangleII().getRow(23).toArray().toString());
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        long N = 11L;
        if(rowIndex == 1) {
            String str = new String(N + "");
            char[] ch = str.toCharArray();
            for(int i = 0; i < ch.length; i++){
                result.add(Integer.parseInt(ch[i]+""));
            }
            return result;
        }
        BigInteger product = new BigInteger(String.valueOf(1L));
        for(int i = 1; i <= rowIndex; ++i) {
            product = product.multiply(new BigInteger(String.valueOf(N)));
        }
        String str = new String(product + "");
        char[] ch = str.toCharArray();
        for(int i = 0; i < ch.length; i++){
            result.add(Integer.parseInt(ch[i]+""));
        }
        return result;
    }
}
