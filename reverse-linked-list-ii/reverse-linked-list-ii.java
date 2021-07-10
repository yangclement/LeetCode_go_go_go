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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //先使用dummynode的方法
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;
        //画图必了解
        for (int i = left; i < right; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }
//             if (head == null) {
//             return null;
//         }
//         if (head.next == null) {
//             return head;
//         }
//         ListNode leftPrev = null;
//         ListNode rightNode = head;
//         ListNode leftNode = head;
//         for (int i = 0; i < right - 1; i++) {
//             if (i == left - 2) {
//                 leftPrev = rightNode;
//             }
//             if (i == left - 1) {
//                 leftNode = rightNode;
//             }
//             rightNode = rightNode.next;
//         }
//         ListNode rightNext = rightNode.next;
//         ListNode prev = rightNext;
//         int changes = right - left + 1;
//         while (changes != 0) {
//             ListNode next = leftNode.next;
//             leftNode.next = prev;
//             prev = leftNode;
//             leftNode = next;
//             changes--;
//         }
//         if (leftPrev != null) {
//             leftPrev.next = rightNode;
//         } else {
//             return prev;
//         }
//         // ListNode leftPrev = head;
//         // ListNode rightNode = head;
//         // for (int i = 0; i < end; i++) {
//         //     if (i == start - 1) {
//         //         leftPrev = rightNode;
//         //     }
//         //     rightNode = rightNode.next;
//         // }
//         // ListNode rightNext = rightNode.next;
//         // ListNode leftNode = leftPrev.next;
//         // ListNode prev = rightNext;
//         // int changes = right - left;

//         // leftPrev.next = rightNode;
//         return head;
}