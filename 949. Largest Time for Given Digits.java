class Solution {
    public String largestTimeFromDigits(int[] A) {
        String res = "";
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j <4; j++) {
                for(int k = 0; k < 4; k++) {
                    if(i == j || j == k || i == k) continue;
                    StringBuilder str = new StringBuilder();
                    str.append(A[i]);
                    str.append(A[j]);
                    str.append(":");
                    str.append(A[k]);
                    str.append(A[6 - i - j - k]);
                    String temp = str.toString();
                    if(temp.substring(0, 2).compareTo("23") <= 0 && temp.substring(3).compareTo("59") <= 0 && temp.compareTo(res) >= 0) res = temp;                 
                }
            }
        }
        return res;
    }
}