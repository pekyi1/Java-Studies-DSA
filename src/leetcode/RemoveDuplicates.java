package leetcode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    //My solution
//    public int removeDuplicates(int[] nums) {
//        Set<Integer> numsSet = new HashSet<>();
//        int count = 0;
//        int j = 0;
//
//        for(int i = 0; i < nums.length; i++){
//            if(!numsSet.contains(nums[i])) {
//                numsSet.add(nums[i]);
//                nums[j] = nums[i];
//                j++;
//                count++;
//            }
//        }
//
//        return count;
//    }

    //Optimised solution
    public int removeDuplicates(int[] nums){
        int j = 0;
        int count = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] != nums[i]){
                nums[j++] = nums[i];
                count++;
            }
        }
        return count;
    }
}
