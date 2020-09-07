class Solution {
    public boolean wordPattern(String pattern, String str) {
        //两个HashMap
        Map<Character, String> mapP = new HashMap<>();
        Map<String, Character> mapS = new HashMap<>();
        String[] words = str.split(" ");
        if(pattern.length() != words.length) return false;
        for(int i = 0 ; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(!mapP.containsKey(pattern.charAt(i))) {
                if(mapS.containsKey(words[i])) return false;
                else {
                    mapP.put(c, words[i]);
                    mapS.put(words[i], c);                    
                }
            }
            else {
                if(!mapS.containsKey(words[i])) return false;
                else {
                    String word = mapP.get(c);
                    if(!word.equals(words[i])) return false;                    
                }
            }
        }
        return true;
    }
}