package leetcode;

import java.util.HashSet;

public class ContainsDuplicate {

//    static {
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) {
//                fw.write("0");
//            } catch (Exception e) {
//            }
//        }));
//    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> match = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(match.contains(nums[i])){
                return true;
            }
            match.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 1};
        System.out.println(containsDuplicate(nums));
    }
}
