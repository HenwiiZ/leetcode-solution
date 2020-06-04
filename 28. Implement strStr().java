class Solution {
    public int strStr(String haystack, String needle) {
        // empty needle appears everywhere, first appears at 0 index
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;
        
        
        for (int i = 0; i < haystack.length(); i++) {
            // no enough places for needle after i
            if (i + needle.length() > haystack.length()) break;
            
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
                if (j == needle.length()-1)
                    return i;
            }
        }
        
        return -1;
    }
    
    
    // public int strStr(String haystack, String needle) {
    //     if(needle.length() == 0) return 0;
    //     if(haystack.length() < needle.length()) return -1;
    //     int res = -1;
    //     int i = 0;
    //     int j = 0;
    //     while(i < haystack.length()) {
    //         if(haystack.charAt(i) == needle.charAt(j)) {
    //             if(j == needle.length() - 1) {
    //                 return i - needle.length() + 1;
    //             }
    //             else {
    //                 i++;
    //                 j++;
    //             }
    //         }
    //         else {
    //             i = i - j + 1;
    //             if (i + needle.length() > haystack.length()) break;
    //             j = 0;
    //         }
    //     }
    //     return -1;
    // }
}