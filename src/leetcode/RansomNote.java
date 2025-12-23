package leetcode;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] positionsToStartFrom = new int[26]; // each letter gets a spot (using the formula letter - 'a') e.g a -> 0  and b -> 1
        for (char c : ransomNote.toCharArray()) {
            int idx = magazine.indexOf(c, positionsToStartFrom[c - 'a']); // look for the character but start from the next position from where you last saw it
            if (idx == -1) return false; // magazine doesn't have the letter needed to construct ransomNote
            positionsToStartFrom[c - 'a'] = idx + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abaa", "baaa"));
    }
}
