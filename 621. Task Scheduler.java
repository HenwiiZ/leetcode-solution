class Solution {
    //安排好最高频的，例如AAABBBCDE，n=2
    //ABXABXAB，所以最短肯定是填满或者本身字符串长度
    public int leastInterval(char[] tasks, int n) {
        int[] t = new int[26];
        for(int i = 0; i < tasks.length; i++) {
            t[tasks[i] - 'A']++;
        }
        int max = 0;
        int count = 0;
        for(int i = 0; i < 26; i++) {
            if(max < t[i]) {
                max = t[i];
                count = 1;
            }
            else if(max == t[i]) {
                count++;
            }
        }
        System.out.println(max);
        System.out.println(count);
        return Math.max(tasks.length, (max - 1) * (n + 1) + count);
    }
}