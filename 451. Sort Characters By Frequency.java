// class Solution {
//     public String frequencySort(String s) {
//         Map<Character, Integer> map = new HashMap<Character, Integer>();
//         for(int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);
//             if(map.containsKey(ch)) {
//                 map.put(ch, map.get(ch) + 1);
//             }
//             else {
//                 map.put(ch, 1);
//             }
//         }
//         System.out.println(map.keySet());
//         List<Character> list = new LinkedList<>(map.keySet());
//         Collections.sort(list, (c1, c2) -> map.get(c2) - map.get(c1));
//         StringBuilder str = new StringBuilder();
//         for(char c: list) {
//             for(int i = 0; i < map.get(c); i++) {
//                 str.append(c);
//             }
//         }
//         return str.toString();
//     }
// }
class Solution {
    // sort hashmap w.r.t values
    public String frequencySort(String s) {
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : ch) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        List<Character> chars = new ArrayList<>(map.keySet());
        // ascending map.get(a) - map.get(b) same order as (a, b)
        // descending reversed order as (a, b)
        Collections.sort(chars, (a, b) -> map.get(b) - map.get(a));
        
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            int num = map.get(c);
            for (int i = 0; i < num; i++) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}