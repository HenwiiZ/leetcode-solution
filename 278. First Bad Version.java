/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int early = 0;
        int late = n;
        while(early < late - 1) {
            int middle = (late - early) / 2 + early;
            if(isBadVersion(middle)) {
                late = middle;
            }
            else {
                early = middle;
            }
        }
        if(!isBadVersion(early)) return late;
        else return early;
    }
}