class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int index = 0;
        StringBuilder str = new StringBuilder();
        while(index < a.length() && index < b.length()) {
            int tempa = a.charAt(a.length() - 1 - index) - '0';
            int tempb = b.charAt(b.length() - 1 - index) - '0';
            int sum = tempa + tempb + carry;
            if(sum == 3) {
                carry = 1;
                str.append(1);
            }
            else if(sum == 2) {
                carry = 1;
                str.append(0);
            }
            else {
                carry = 0;
                str.append(sum);
            }
            index++;
        }
        while(index < a.length()) {
            int tempa = a.charAt(a.length() - 1 - index) - '0';
            int sum = tempa + carry;
            if(sum == 2) {
                carry = 1;
                str.append(0);
            }
            else {
                carry = 0;
                str.append(sum);
            }
            index++;
        }
        while(index < b.length()) {
            int tempb = b.charAt(b.length() - 1 - index) - '0';
            int sum = tempb + carry;
            if(sum == 2) {
                carry = 1;
                str.append(0);
            }
            else {
                carry = 0;
                str.append(sum);
            }
            index++;
        }
        if(carry == 1) str.append(1);
        return str.reverse().toString();
    }
}