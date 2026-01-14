package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        List<Integer> subset = new ArrayList<>();
        generate(i, nums, subset, res);
        return res;
    }

    static void generate(int i, int[] nums, List<Integer> subset, List<List<Integer>> res){
        if(i >= nums.length){
            List<Integer> subsetCopy = new ArrayList<>(subset);
            res.add(subsetCopy);
            return;
        }
        subset.add(nums[i]);
        generate(i + 1, nums, subset, res);
        subset.removeLast();
        generate(i + 1, nums, subset, res);
    }
}
