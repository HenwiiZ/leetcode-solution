class Solution {
    public String countAndSay(int n) {
        //Corner Case
        if(n == 1) return "1";
        String cur = "1";
        //n times iteration
        for(int i = 1; i < n; i++) {
            StringBuilder str = new StringBuilder();
            int count = 1;
            char c = cur.charAt(0);
            for(int j = 1; j < cur.length(); j++) {
                
                if(cur.charAt(j) == c) {
                    count++;
                }
                else {
                    str.append(count);
                    str.append(c);
                    count = 1;
                    c = cur.charAt(j);
                }
            }
            str.append(count);
            str.append(c);
            cur = str.toString();
        }
        return cur;
    }
}