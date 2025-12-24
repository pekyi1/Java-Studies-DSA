package leetcode;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] letter = new int[26];
        //check of lengths are not the same first
        if(s.length() != t.length()){
            return false;
        }
        //increase s and decrease t at their respective character locations in letters[]
        for (int i = 0; i < s.length(); i++) {
            letter[s.charAt(i) - 'a'] += 1;
            letter[t.charAt(i) - 'a'] -= 1;
        }
        //finally check if none of the indexes in letters is not equal to zero
        for (int i = 0; i < letter.length; i++) {
            if(letter[i] != 0){
                return false;
            }
        }
        return true;
    }
}
