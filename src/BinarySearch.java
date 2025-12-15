public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2; // Middle index
            int current = arr[mid];

            if (current == target) {
                return mid; // Found it!
            }

            // If mid value is less than target, search right side
            if (arr[mid] < target) {
                low = mid + 1;
            }
            // If mid value is greater than target, search left side
            else {
                high = mid - 1;
            }
        }

        return -1; // Not found
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        int target = 13;
        int index = binarySearch(numbers, target);

        if (index != -1) {
            System.out.println("Target found at index: " + index);
        } else {
            System.out.println("Target not found.");
        }
    }
}

