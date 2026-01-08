package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
//Medium question
public class MultiplyAllExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;
        int n = nums.length;
        int[] result = new int[n];
        for(int i = 0; i<result.length; i++){
            result[i] =1;
        }
        for(int i = 0; i<nums.length; i++){
            result[i] = left;
            left *= nums[i];
        }

        for(int i = n - 1; i>=0; i--){
            result[i] = result[i] * right;
            right *= nums[i];
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 10};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
