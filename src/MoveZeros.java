public class MoveZeros {
    public static int[] moveZeroesToNewArray(int[] nums) {
    int n = nums.length;
    int[] result = new int[n]; // new array filled with zeros automatically

    int index = 0;

    // Copy all non-zero numbers into result
    for (int i = 0; i < n; i++) {
        if (nums[i] != 0) {
            result[index] = nums[i];
            index++;
        }
    }

    // No need to add zeros manually, Java already filled the array with zeros

    return result;
}
    
}
