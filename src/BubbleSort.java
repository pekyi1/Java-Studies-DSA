import java.util.Arrays;
public class BubbleSort {

    // Method to compute the minimum final length
    public static int minimumFinalLength(int[] nums) {
        int minRight = Integer.MAX_VALUE;
        int keep = nums.length;

        // Traverse from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > minRight) {
                // This element will cause swaps and be removed
                keep = i;
            } else {
                minRight = nums[i];
            }
        }
        return keep;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 1, 2};
        int[] nums2 = {4, 2, 1, 3};
        int[] nums3 = {1, 2, 3, 4};
        int[] nums4 = {5, 4, 3, 2, 1};

        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Final Length: " + minimumFinalLength(nums1));
        System.out.println();

        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Final Length: " + minimumFinalLength(nums2));
        System.out.println();

        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Final Length: " + minimumFinalLength(nums3));
        System.out.println();

        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println("Final Length: " + minimumFinalLength(nums4));
    }

}
