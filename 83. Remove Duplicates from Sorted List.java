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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode pre = head;
        ListNode cur = pre.next;
        while(cur != null) {
            while(cur != null && pre.val == cur.val) {
                cur = cur.next;
                pre.next = cur;
            }
            if(cur == null) return head;
            pre = pre.next;
            cur = cur.next;
        }
        return head;
    }
}