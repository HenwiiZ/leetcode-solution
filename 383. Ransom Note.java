class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] word = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            word[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            word[ransomNote.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (word[i] < 0) return false;
        }
        return true;
    }
}