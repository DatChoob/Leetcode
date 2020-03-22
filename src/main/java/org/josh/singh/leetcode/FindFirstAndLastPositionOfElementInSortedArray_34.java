package org.josh.singh.leetcode;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * <p>
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     * Memory Usage: 42.6 MB, less than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     */
    public int[] searchRange(int[] nums, int target) {

        int index = binarySearch(nums, target, 0, nums.length - 1);
        if (index < 0) {
            return new int[]{-1, -1};
        }
        int left = findLeftIndex(nums, target, index);
        int right = findRightIndex(nums, target, index);
        return new int[]{left, right};
    }

    private int findLeftIndex(int[] nums, int target, int startingIndex) {
        while (startingIndex > 0 && nums[startingIndex - 1] == target) startingIndex--;
        return startingIndex;
    }

    private int findRightIndex(int[] nums, int target, int startingIndex) {
        while (startingIndex < nums.length - 1 && nums[startingIndex + 1] == target) startingIndex++;
        return startingIndex;
    }

    private int binarySearch(int[] a, int key, int low, int high) {
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid;
        }
        return -(low + 1);
    }
}
