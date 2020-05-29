/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode evenFirst = head.next;
        ListNode evenLast = head.next;
        ListNode oddLast = head;
        ListNode oddAdd = head;
        int index = 0;
        while(evenLast != null && evenLast.next != null) {
            oddAdd = evenLast.next;
            // |oddLast|evenFirst|***|evenLast|oddAdd|***|null
            evenLast.next = oddAdd.next;
            oddLast.next = oddAdd;
            oddAdd.next = evenFirst;
            oddLast = oddAdd;
            evenLast = evenLast.next;
        }
        return head;
    }
}