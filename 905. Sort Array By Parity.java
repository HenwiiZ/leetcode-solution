class Solution {
    public int[] sortArrayByParity(int[] A) {
        int oddIdx = A.length - 1;
        int evenIdx = 0;
        while(oddIdx > evenIdx) {
            if(A[oddIdx] % 2 == 0) {
                while(oddIdx > evenIdx && A[evenIdx] % 2 == 0) evenIdx++;
                if(oddIdx <= evenIdx) return A;
                else {
                    int temp = A[evenIdx];
                    A[evenIdx] = A[oddIdx];
                    A[oddIdx] = temp;
                    evenIdx++;
                }
            }
            oddIdx--;
        }
        return A;
    }
}