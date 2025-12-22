import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

    public static int minimumFinalLength(int[] nums) {
        // Copy nums into a mutable list
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }

        while (true) {
            boolean swapped = false;

            // One full bubble pass
            for (int i = 0; i < arr.size() - 1; i++) {
                if (arr.get(i) > arr.get(i + 1)) {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(i + 1));
                    arr.set(i + 1, temp);
                    swapped = true;
                }
            }

            // If no swaps, array is sorted → stop
            if (!swapped) {
                break;
            }

            // Remove the last element after a successful pass
            arr.remove(arr.size() - 1);
        }

        return arr.size();
    }

    public static void main(String[] args) {
        System.out.println(minimumFinalLength(new int[]{3, 1, 2}));      // 2
        System.out.println(minimumFinalLength(new int[]{4, 2, 1, 3}));   // 2
        System.out.println(minimumFinalLength(new int[]{1, 2, 3, 4}));   // 4
        System.out.println(minimumFinalLength(new int[]{5, 4, 3, 2, 1}));// 1
    }
}
