package learning.random_problems;

import java.util.Stack;

public class NextGreatestElement {

    public static void main(String[] args) {
        int []arr = new NextGreatestElement().replaceElements(new int[]{17,18,5,4,6,1});
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
    public int[] replaceElements(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        stk.push(arr[arr.length-1]);
        arr[arr.length-1] = -1;
        for(int i = arr.length-2; i >= 0; i--) {
            if(!stk.isEmpty()) {
                if(stk.peek() > arr[i]) {
                    arr[i] = stk.peek();
                } else {
                    int topElement = arr[i];
                    arr[i] = stk.peek();
                    stk.push(topElement);
                }
            } else {
                stk.push(arr[i]);
                arr[i] = -1;
            }
        }
        return arr;
    }
}
