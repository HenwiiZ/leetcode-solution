class Solution {
    public String removeDuplicateLetters(String s) {
        int[] a = new int[26];
        boolean[] visited = new boolean[26];
        char smallC = 'z';
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            a[c - 'a']--;
            if(visited[c - 'a']) continue;
            while(!stack.isEmpty() && stack.peek() > c && a[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder str = new StringBuilder();
        for(char c: stack) {
            str.append(c);
        }
        return str.toString();
    }
}