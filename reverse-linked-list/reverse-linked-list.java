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
    public ListNode reverseList(ListNode head) {
        //dummyNode
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode curr = head;
        while (curr.next != null) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        return dummy.next;
        
        
        //recursion
        // if (head == null) {
        //     return null;
        // }
        // if (head.next == null) {
        //     return head;
        // }
        // this recursion function will return the last node.
        // ListNode last = recurrsiveReverse(head);
        // return last;
        
        // if (head == null) {
        //     return null;
        // }
        // if (head.next == null) {
        //     return head;
        // }
        // //iteration
        // ListNode curr = head;
        // ListNode prev = null;
        // while (curr != null) {
        //     ListNode temp = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = temp;
        // }
        // return prev;
        //first approch, not a good logic
        // ListNode next = head.next;
        // ListNode prev = null;
        // while (next !=null) {
        //     head.next = prev;
        //     prev = head;
        //     head = next;
        //     next = head.next;
        // }
        // head.next = prev;
        // return head;
    }
    private ListNode recurrsiveReverse(ListNode curr) {
        if (curr.next == null) {
            return curr;
        }
        ListNode next = curr.next;
        ListNode last = recurrsiveReverse(curr.next);
        // System.out.println(next.val);
        next.next = curr;
        curr.next = null;
        return last;
    }
}