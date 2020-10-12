class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()) return false;
        int[] a = new int[26];
        int[] b = new int[26];
        int diff = 0;
        for(int i = 0; i < A.length(); i++) {
            char ca = A.charAt(i);
            char cb = B.charAt(i);
            a[ca - 'a']++;
            b[cb - 'a']++;
            if(ca != cb) diff++;
        }
        if(diff == 2) {
            for(int i = 0; i < 26; i++) {
                if(a[i] != b[i]) return false;
            }
            return true;
        }
        else if(diff == 0) {
            for(int i =0 ; i < 26; i++) {
                if(a[i] >= 2) return true;
            }
            return false;
        }
        else return false;
    }
}