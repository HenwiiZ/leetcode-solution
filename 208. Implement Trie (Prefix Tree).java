class Trie {
    /** Initialize your data structure here. */
    private TrieNode root;
    public Trie() {
        root = new TrieNode(' ', false);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode(c, false);
            }
            if(i == word.length() - 1) {
                cur.children[c - 'a'].end = true;
            }
            cur = cur.children[c - 'a'];
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        if(cur.end) return true;
        else return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return true;
    }
}

class TrieNode {
    public char ch;
    public boolean end;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode(char ch, boolean end) {
        this.ch = ch;
        this.end = end;
        this.children = children;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


// class Trie {
//     private Set<String> set; 
//     /** Initialize your data structure here. */
//     public Trie() {
//         set = new HashSet<String>();
//     }
    
//     /** Inserts a word into the trie. */
//     public void insert(String word) {
//         if(!set.contains(word)) {
//             set.add(word);
//         }
//     }
    
//     /** Returns if the word is in the trie. */
//     public boolean search(String word) {
//         if(!set.contains(word)) return false;
//         else return true;
//     }
    
//     /** Returns if there is any word in the trie that starts with the given prefix. */
//     public boolean startsWith(String prefix) {
//         Iterator iter = set.iterator();
//         while(iter.hasNext()) {
//             String element = (String) iter.next();
//             if(element.length() < prefix.length()) continue;
//             if(element.substring(0, prefix.length()).equals(prefix)) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }

// /**
//  * Your Trie object will be instantiated and called as such:
//  * Trie obj = new Trie();
//  * obj.insert(word);
//  * boolean param_2 = obj.search(word);
//  * boolean param_3 = obj.startsWith(prefix);
//  */