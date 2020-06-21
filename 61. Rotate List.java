/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int len = 1;
        ListNode left = head;
        ListNode right = head;
        while(right.next != null) {
            right = right.next;
            len++;
        }
        if(len == 1) return head;
        k %= len;
        k = len - k;
        while(k > 0) {
            ListNode tempLeft = left;
            left = left.next;
            tempLeft.next = null;
            right.next = tempLeft;
            right = right.next;
            k--;
        }
        return left;
    }
}