package stack_ds;

import java.util.Stack;

public class NextLargestElementToRight {

    public static void main(String... args) {
        int []arr = {73, 74, 75, 71, 69, 72, 76, 73};
        for(int element : new NextLargestElementToRight().nextLargestElement(arr)){
            System.out.print(element + " ");
        }
        System.out.println();
        for(int element : new NextLargestElementToRight().nextLargestElementUsingStack(arr)){
            System.out.print(element + " ");
        }
    }

    //Brute force
    public int[] nextLargestElement(int []arr) {
        int[] largestElementArray = new int[arr.length];
        largestElementArray[arr.length - 1] = -1;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j]>arr[i]){
                    largestElementArray[i] = arr[j];
                    break;
                } else {
                    largestElementArray[i] = -1;
                }
            }
        }
        return largestElementArray;
    }

    //Using Stack
    public int[] nextLargestElementUsingStack(int []arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int []largestElementArray = new int[arr.length];
        int k = arr.length - 1;
        for(int i = arr.length - 1; i >= 0; i--) {
            while(!stack.isEmpty()) {
                int element = stack.peek();
                if (element > arr[i]) {
                    largestElementArray[k] = element;
                    k--;
                    stack.push(arr[i]);
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()){
                largestElementArray[k] = -1;
                k--;
                stack.push(arr[i]);
            }
        }
        return largestElementArray;
    }
}
