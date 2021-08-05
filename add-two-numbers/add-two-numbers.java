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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode dummy = new ListNode(0);
        ListNode currNode = dummy;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int curr = x + y;
            
            if (carry) {
                curr++;
                carry = false;
            }
            
            if (curr >= 10) {
                curr %= 10;
                carry = true;
            }
            currNode.next = new ListNode(curr);
            currNode = currNode.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry) {
            currNode.next = new ListNode(1);
        }
        
        return dummy.next;

    }
}