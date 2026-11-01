/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return solve(1, n);
    }
     private int solve(int left, int right) {
        if (left == right)return left;
        int mid = left + (right - left) / 2;

        if (isBadVersion(mid)) {
            return solve(left, mid);
        } else {
            return solve(mid + 1, right);
        }
    }
}