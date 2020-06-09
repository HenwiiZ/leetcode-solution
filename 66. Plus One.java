class Solution {
    public int[] plusOne(int[] digits) {
        boolean a = true;
        List<Integer> res = new LinkedList<Integer>();
        for(int i = digits.length - 1; i >= 0; i--) {
            if(a) {
                if(digits[i] == 9) {
                    res.add(0);
                    // digits[i] = 0;
                    a = true;
                }
                else {
                    res.add(digits[i] + 1);
                    // digits[i] = digits[i] + 1;
                    a = false;
                }
            }
            else {
                res.add(digits[i]);
            }
        }
        if(a) res.add(1);
        int[] r = new int[res.size()];
        for(int i = res.size() - 1; i >= 0; i--) {
            r[r.length - 1 - i] = res.get(i);
        }
        return r;
    }
}