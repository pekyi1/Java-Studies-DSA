package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
        public int[] twoSum(int[] nums, int target) {
            //[2, 7, 11, 15, 32]
            //we first find the complement of the number we are on,
            //then we store it in a map together with the index of the current number we are on
            //then we look for that complement in the array and return it together with the index of the first number
            Map<Integer, Integer> numsMap = new HashMap();
            for(int i = 0; i < nums.length; i++){
                int current = nums[i];
                if(numsMap.get(current) == null){
                    int complement = target - current;
                    numsMap.put(complement, i);
                }
                else{
                    return new int[] {i, numsMap.get(current)};
                }
            }
            return new int[] {};
        }
}
