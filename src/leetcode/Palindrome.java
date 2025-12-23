package leetcode;

public class Palindrome {
    public static int reverse(int x) {
        // boolean negative = x < 0;
        x = Math.abs(x);

        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return reversed;
    }



    public static boolean isPalindrome(int x) {
        return reverse(x) == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }


}
