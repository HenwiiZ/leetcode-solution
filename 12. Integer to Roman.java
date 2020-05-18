class Solution{
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] ref = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder str = new StringBuilder();
        int i = 0;
        while(num != 0) {
            int temp = num / nums[i];
            num %= nums[i];
            for(int j = 0; j < temp; j++) {
                str.append(ref[i]);
            }
            i++;
        }
        return str.toString();
    }
}

//笨比思路
class Solution {
//     public String intToRoman(int num) {
//         Map<Integer, String> map = new HashMap<Integer, String>();
//         map.put(1, "I");
//         map.put(5, "V");
//         map.put(10, "X");
//         map.put(50, "L");
//         map.put(100, "C");
//         map.put(500, "D");
//         map.put(1000, "M");
        
//         StringBuilder str = new StringBuilder();
//         int curNum = num / 1000;
//         num %= 1000;
//         if(curNum > 0) {
//             if(curNum > 1) {
//                 for(int i = 0; i < curNum - 1; i++) {
//                     str.append(map.get(1000));
//                 }              
//             }
//             str.append(map.get(1000));
//         }
//         System.out.println(str.toString());
//         curNum = num / 100;
//         num %= 100;
//         if(curNum > 0) {
//             if(curNum == 9) {
//                 str.append(map.get(100));
//                 str.append(map.get(1000));
//             }
//             else if(curNum < 9 && curNum > 5) {
//                 int cnt = curNum % 5;
//                 str.append(map.get(500));
//                 for(int i = 0; i < cnt; i++) {
//                     str.append(map.get(100));
//                 }
//             }
//             else if(curNum == 5) {
//                 str.append(map.get(500));
//             }
//             else if(curNum == 4) {
//                 str.append(map.get(100));
//                 str.append(map.get(500));
//             }
//             else {
//                 for(int i = 0; i < curNum; i++) {
//                     str.append(map.get(100));
//                 }                
//             }
//         }
//         curNum = num / 10;
//         num %= 10;
//         if(curNum > 0) {
//             if(curNum == 9) {
//                 str.append(map.get(10));
//                 str.append(map.get(100));
//             }
//             else if(curNum < 9 && curNum > 5) {
//                 int cnt = curNum % 5;
//                 str.append(map.get(50));
//                 for(int i = 0; i < cnt; i++) {
//                     str.append(map.get(10));
//                 }
//             }
//             else if(curNum == 5) {
//                 str.append(map.get(50));
//             }
//             else if(curNum == 4) {
//                 str.append(map.get(10));
//                 str.append(map.get(50));
//             }
//             else {
//                 for(int i = 0; i < curNum; i++) {
//                     str.append(map.get(10));
//                 }                
//             }
//         }
//         if(num > 0) {
//             if(num == 9) {
//                 str.append(map.get(1));
//                 str.append(map.get(10));
//             }
//             else if(num < 9 && num > 5) {
//                 int cnt = num % 5;
//                 str.append(map.get(5));
//                 for(int i = 0; i < cnt; i++) {
//                     str.append(map.get(1));
//                 }
//             }
//             else if(num == 5) {
//                 str.append(map.get(5));
//             }
//             else if(num == 4) {
//                 str.append(map.get(1));
//                 str.append(map.get(5));
//             }
//             else {
//                 for(int i = 0; i < num; i++) {
//                     str.append(map.get(1));
//                 }                
//             }
//         }
//         return str.toString();
//     }
// }