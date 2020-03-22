package org.josh.singh.leetcode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists_21 {
    /**
     * Runtime: 1 ms, faster than 16.34% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 40.1 MB, less than 14.81% of Java online submissions for Merge Two Sorted Lists.
     * This is a clone, hence why it is slower. I think.
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(-1);
        ListNode current = fakeHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 == null) {
            current.next = l2;
        } else {
            current.next = l1;
        }
        return fakeHead.next;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 38.4 MB, less than 19.53% of Java online submissions for Merge Two Sorted Lists.
     */
    public ListNode mergeTwoLists_recursive(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists_recursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_recursive(l1, l2.next);
            return l2;
        }
    }
}


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
