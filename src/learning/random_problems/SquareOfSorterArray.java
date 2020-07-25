package learning.random_problems;

import java.util.Collection;

public class SquareOfSorterArray {

    public static void main(String[] args) {
        int []array = {-7,-3,2,3,11};
        int [] arr = new SquareOfSorterArray().sortedSquares(array);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
    public int[] sortedSquares(int[] A) {
        int []sortedArray = new int[A.length];
        int kIndex = A.length-1;
        int i = 0;
        int j = A.length-1;
        while(i < j) {
            if((A[i]*A[i]) > (A[j] * A[j])){
                sortedArray[kIndex--] = A[i] * A[i];
                i++;
            } else if((A[i]*A[i]) <= (A[j] * A[j])){
                sortedArray[kIndex--] = A[j] * A[j];
                j--;
            } else {

            }
        }
        sortedArray[kIndex] = A[i] * A[i];
        return sortedArray;
    }
}
