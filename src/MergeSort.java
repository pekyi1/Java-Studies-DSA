import java.util.*;

public class MergeSort {

    private static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];

        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums[i], i);
        }

        mergeSort(pairs, 0, n - 1, counts);

        List<Integer> result = new ArrayList<>();
        for (int c : counts) result.add(c);
        return result;
    }

    private static void mergeSort(Pair[] arr, int left, int right, int[] counts) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid, counts);
        mergeSort(arr, mid + 1, right, counts);
        merge(arr, left, mid, right, counts);
    }

    private static void merge(Pair[] arr, int left, int mid, int right, int[] counts) {
        List<Pair> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (arr[j].value < arr[i].value) {
                temp.add(arr[j]);
                rightCount++;  // one smaller element from the right
                j++;
            } else {
                counts[arr[i].index] += rightCount;
                temp.add(arr[i]);
                i++;
            }
        }

        while (i <= mid) {
            counts[arr[i].index] += rightCount;
            temp.add(arr[i]);
            i++;
        }

        while (j <= right) {
            temp.add(arr[j]);
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            arr[left + k] = temp.get(k);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        System.out.println(countSmaller(nums)); // [2, 1, 1, 0]
    }
}
