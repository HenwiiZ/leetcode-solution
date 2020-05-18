class Solution {
    public String multiply(String num1, String num2) {
        if(num1.length() == 0 || num2.length() == 0) return "0";
        int[] res = new int[num1.length() + num2.length()];
        StringBuilder str = new StringBuilder();
        for(int i = num1.length() - 1; i >= 0; i--) {
            for(int j = num2.length() - 1; j >= 0; j--) {
                int low = i + j + 1;
                int high = i + j;
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                temp += res[low];
                res[high] += temp / 10;
                res[low] = temp % 10;
            }
        }
        for(int i = 0; i < res.length; i++) {
            if(!(str.length() == 0 && res[i] == 0)) {
                str.append(res[i]);
            }
        }
        //如果全为0的话，str应该为空字符串
        return str.toString().equals("")? "0": str.toString();
    }
}