package learning.random_problems;

public class FrequencyOfElementInArray {

    public static void main(String[] args) {
        int []arr = {2, 3, 3, 2, 5};
        for(int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - 1;
        }

        for(int i = 0; i < arr.length; i++) {
            arr[arr[i]%arr.length] += arr.length;
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println(i+1 + "---->" + arr[i]/arr.length);
        }
    }
}
