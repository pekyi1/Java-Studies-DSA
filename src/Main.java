import java.util.Arrays;

public class Main {
    //Finding the max value
//    public static int findMax(int[] arr){
//        int max = arr[0];
//
//        for(int i = 1; i < arr.length; i++){
//            if(arr[i] > max){
//                max = arr[i];
//            }
//        }
//        return max;
//    }
    //Doing a binary search using the array class in java
//    public static String reverseString(String input){
//        StringBuilder builder = new StringBuilder();
//        for(int i = input.length() -1; i>=0; i--){
//            builder.append(input.charAt(i));
//        }
//        return  builder.toString();
//    }


    public static void main(String[] args) {
       int[] arr = {1, 2, 3, 4, 5};
       int k = 2;
       int[] rotatedArray = ArrayRotation.rotationUsingExtraSpace(arr, k);
       System.out.println(Arrays.toString(rotatedArray));
    }
}