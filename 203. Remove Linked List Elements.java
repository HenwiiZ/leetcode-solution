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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode pre = new ListNode(-1);
        ListNode ret = pre;
        pre.next = head;
        ListNode cur = head;
        while(cur != null) {
            if(cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
                continue;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return ret.next;
    }
}