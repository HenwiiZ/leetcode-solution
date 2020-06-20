class Solution {
    public String getPermutation(int n, int k) {
        // The trickiest skill used in this problem is that using an ArrayList 
        // to store the 0-9 and remove used numbers;
        // For example, if 2 has been used, then when you want the second smallest number,
        // it should be 3, and its index is still 1
        StringBuilder str = new StringBuilder();
        int[] factorial = new int[n];
        List<Integer> nums = new ArrayList<Integer>();
        factorial[0] = 1;
        for(int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
            nums.add(i);
        }
        nums.add(n);
        k--;
        for(int i = 0; i < n; i++) {
            int sum = factorial[n - 1 - i];
            int index = k / sum;
            str.append(nums.get(index));
            nums.remove(index);
            k %= sum;
        }
        return str.toString();
    }
}