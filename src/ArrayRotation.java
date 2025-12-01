public class ArrayRotation {
    public static int[] rotationUsingExtraSpace(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        
        int[] temp =  new int[n];

        for(int i = 0; i< n; i++){
            temp[(i + k) % n] = arr[i];
        }
        return temp;
    }

    public static int[] rotationInPlace(int[] arr, int k){
        int n = arr.length;
        k = k % n;

        reverse(arr, 0, n-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
        return arr;
    }

    public static void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

