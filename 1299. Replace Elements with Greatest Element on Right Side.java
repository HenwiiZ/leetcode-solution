class Solution {
    public int[] replaceElements(int[] arr) {
        if(arr.length == 0) return arr;
        // int maxVal = arr[arr.length - 1];
        if(arr.length == 1) {
            arr[0] = -1;
            return arr;
        }
        int temp = arr[arr.length - 2];
        int maxVal = Math.max(arr[arr.length - 1], arr[arr.length - 2]);
        for(int i = arr.length - 3; i >= 0; i--) {
            maxVal = Math.max(maxVal, temp);
            temp = arr[i];
            arr[i] = maxVal;
        }
        arr[arr.length - 2] = arr[arr.length - 1];
        arr[arr.length - 1] = -1;        
        return arr;
    }
}
// class Solution {
//     public int[] replaceElements(int[] arr) {
//         if(arr.length == 0) return arr;
//         for(int i = 0; i < arr.length; i++) {
//             int maxVal = 0;
//             for(int j = i + 1; j < arr.length; j++) {
//                 maxVal = Math.max(maxVal, arr[j]);
//             }
//             arr[i] = maxVal;
//         }
//         arr[arr.length - 1] = -1;
//         return arr;
//     }
// }