class Solution {
    //binary search
    public int hIndex(int[] citations) {
        if(citations.length == 0) return 0;
        int left = 0;
        int right = citations.length - 1;
        int h = 0;
        while(left < right - 1) {
            int mid = (right - left) / 2 + left;
            if(citations[mid] >= citations.length - mid) {
                h = citations.length - mid;
                right = mid;
            }
            else left = mid;
        }
        if(citations[left] >= citations.length - left)
            return citations.length - left;
        else if(citations[right] >= citations.length - right)
            return citations.length - right;
        else return 0;
    }
}