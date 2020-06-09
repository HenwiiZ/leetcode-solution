class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        for(int i = 0; i < s.length(); i++) {
            int index = t.indexOf(s.charAt(i));
            if(index == -1) return false;
            else {
                index++;
                t = t.substring(index);
            }
        }
        return true;
    }
}