package org.josh.singh.leetcode;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * Example:
 * Given n = 5, and version = 4 is the first bad version.
 * <p>
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * <p>
 * Then 4 is the first bad version.
 */
public class FirstBadVersion_278 extends VersionControl_FirstBadVersion_278 {
    public FirstBadVersion_278(int solution) {
        super(solution);
    }

    //Time limit Exceeded
    public int firstBadVersion(int n) {
        for (int i = 1; i <= n; i++) {
            if (isBadVersion(i))
                return i;
        }
        return n;
    }

    //Time limit Exceeded
    public int firstBadVersion_recursive(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) >>> 1;

            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}


class VersionControl_FirstBadVersion_278 {
    int firstBadVersion;

    public VersionControl_FirstBadVersion_278(int solution) {
        this.firstBadVersion = solution;
    }

    public boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }
}
