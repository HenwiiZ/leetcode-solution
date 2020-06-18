class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for(int i = citations.length - 1; i >= 0; i--) {
            if(citations[i] >= h + 1) {
                h += 1;
            }
            else {
                break;
            }
        }
        return h;
    }
}