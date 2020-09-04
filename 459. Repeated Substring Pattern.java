class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length() == 1) return false;
        for(int i = s.length() - 1; i >= s.length() / 2; i--) {
            if(s.length() % (s.length() - i) != 0) continue;
            StringBuilder sub = new StringBuilder();
            int times = s.length() / (s.length() - i);
            for(int j = 0; j < times; j++) {
                sub.append(s.substring(i));
            }
            if(sub.toString().equals(s)) return true;
        }
        return false;
    }
}