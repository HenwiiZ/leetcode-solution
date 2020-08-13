class CombinationIterator {

    public Queue<String> comb;
    StringBuilder ss;
    public CombinationIterator(String characters, int combinationLength) {
        comb = new LinkedList<>();
        ss = new StringBuilder();
        helper(characters, ss, combinationLength, 0);
    }
    
    public void helper(String s, StringBuilder ss, int len, int idx) {
        if(ss.length() >= len) {
            comb.offer(ss.toString());
            return;
        }
        if(idx >= s.length()) return;
        for(int i = idx; i < s.length(); i++) {
            
            ss.append(s.charAt(i));
            helper(s, ss, len, i + 1);
            ss.deleteCharAt(ss.length() - 1);
           
        }
    }
    
    public String next() {
        return comb.poll();
    }
    
    public boolean hasNext() {
        if(comb.size() == 0) return false;
        else return true;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */