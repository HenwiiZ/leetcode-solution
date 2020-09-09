class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int idx1 = 0;
        int idx2 = 0;
        while(idx1 < v1.length && idx2 < v2.length) {
            if(Integer.parseInt(v1[idx1]) > Integer.parseInt(v2[idx2])) return 1;
            else if(Integer.parseInt(v1[idx1]) < Integer.parseInt(v2[idx2])) return -1;
            idx1++;
            idx2++;
        }
        while(idx1 < v1.length){
            if(Integer.parseInt(v1[idx1]) > 0) return 1;
            else if(Integer.parseInt(v1[idx1]) < 0) return -1;
            idx1++;
        }
        while(idx2 < v2.length){
            if(Integer.parseInt(v2[idx2]) > 0) return -1;
            else if(Integer.parseInt(v2[idx2]) < 0) return 1;
            idx2++;
        }        
        return 0;
    }
}