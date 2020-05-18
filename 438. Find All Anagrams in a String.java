class Solution {
    //window sliding，超过p的长度时判断最前面的字符个数
    //如果为1说明只有第一次出现过，remove
    //大于1说明后面还出现过，个数减1
    //冷知识，hashmap可以用equals
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pmap = new HashMap<Character, Integer>();
        List<Integer> res = new LinkedList<Integer>();
        for(int i = 0; i < p.length(); i++) {
            if(!pmap.containsKey(p.charAt(i))) {
                pmap.put(p.charAt(i), 1);
            }
            else {
                pmap.replace(p.charAt(i), pmap.get(p.charAt(i))+1);
            }
        }
        Map<Character, Integer> smap = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!smap.containsKey(ch)) {
                smap.put(ch, 1);
            }
            else {
                smap.replace(ch, smap.get(ch)+1);
            }
            if(i >= p.length()) {
                ch = s.charAt(i - p.length());
                if(smap.get(ch) == 1) {
                    smap.remove(ch);
                }
                else {
                    smap.replace(ch, smap.get(ch) - 1);
                }            
            }
            if(pmap.equals(smap)) {
                res.add(i - p.length() + 1);
            }            
        }
        return res;
    }
}