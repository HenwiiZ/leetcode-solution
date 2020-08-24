class Solution {
    public String decodeString(String s) {
        Stack<Integer> sInt = new Stack<>();
        Stack<String> sString=  new Stack<>();
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' < 10) {
                if(i >= 1 && !(s.charAt(i - 1) - '0' >= 0 && s.charAt(i - 1) - '0' < 10)) {
                    System.out.println(str.toString());
                    sString.push(str.toString());
                    str.delete(0, str.length());                    
                }
                str.append(s.charAt(i));
            }
            else if(s.charAt(i) == '[') {
                sInt.push(Integer.parseInt(str.toString()));
                str.delete(0, str.length());
            }
            else if(s.charAt(i) == ']') {
                StringBuilder temp = new StringBuilder();
                if(!sString.isEmpty()) temp.append(sString.pop());
                int time = sInt.isEmpty()? 1: sInt.pop();
                for(int j = 0; j < time; j++) {
                    temp.append(str.toString());
                }
                str = temp;
            }
            else {
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}