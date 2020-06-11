class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String s1 = strs[0];
        String res = "";
        for(int i = 1; i < strs.length; i++) {
            StringBuilder str = new StringBuilder();
            String s2 = strs[i];
            int index = 0;
            while(index < s1.length() && index < s2.length()) {
                if(s1.charAt(index) == s2.charAt(index)) {
                    str.append(s1.charAt(index));
                }
                else {
                    break;
                }
                index++;
            }
            s1 = str.toString();
        }
        return s1;
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        for(int i = 0; i < strs[0].length(); i++){
            char ch = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(i == strs[j].length() || strs[j].charAt(i) != ch){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}