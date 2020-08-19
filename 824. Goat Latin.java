class Solution {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        for(int i = 0; i < words.length; i++) {
            StringBuilder s = new StringBuilder();
            String word = words[i];
            if(word.toLowerCase().charAt(0) == 'a' || word.toLowerCase().charAt(0) == 'e' || word.toLowerCase().charAt(0) == 'i' 
              || word.toLowerCase().charAt(0) == 'o' || word.toLowerCase().charAt(0) == 'u') {
                s.append(word);

            }
            else {
                char c = word.charAt(0);
                s.append(word.substring(1));
                s.append(c);
            }
            s.append("ma");
            for(int j = 0; j < i + 1; j++) {
                s.append("a");
            }
            words[i] = s.toString();
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < words.length - 1; i++) {
            res.append(words[i]);
            res.append(" ");
        }
        return res.append(words[words.length - 1]).toString();
    }
}