import java.util.*;

public class QuickSort {

    public static int minDifference(int[] nums, int k) {
        int pivot = quickSelect(nums.clone(), 0, nums.length - 1, k - 1);

        int sumA = 0, sumB = 0;
        boolean pivotUsed = false;

        for (int num : nums) {
            if (num < pivot) {
                sumA += num;
            } else if (num > pivot) {
                sumB += num;
            } else {
                // handle pivot value
                if (!pivotUsed) {
                    sumA += num; // temporarily place pivot in A
                    pivotUsed = true;
                } else {
                    sumA += num; // duplicates of pivot also go to A
                }
            }
        }

        // Decide where pivot belongs
        if (sumB > sumA) {
            sumA -= pivot;
            sumB += pivot;
        }

        return Math.abs(sumA - sumB);
    }

    // QuickSelect to find k-th smallest element
    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) return arr[left];

        int pivotIndex = partition(arr, left, right);

        if (k == pivotIndex) return arr[k];
        else if (k < pivotIndex) return quickSelect(arr, left, pivotIndex - 1, k);
        else return quickSelect(arr, pivotIndex + 1, right, k);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {8, 3, 1, 5, 2};
        int k = 3;
        System.out.println(minDifference(nums, k)); // 13
    }
}
