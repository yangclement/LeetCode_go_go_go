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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //recursion
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        //iteration
//         ListNode prev = null;
//         ListNode temp = null;
//         if (l1.val < l2.val) {
//             temp = l1;
//             prev = l1;
//             l1 = l1.next;
//         } else {
//             temp = l2;
//             prev = l2;
//             l2 = l2.next;
//         }

//         while(l1 != null && l2 != null) {
//             if (l1.val < l2.val) {
//                 prev.next = l1;
//                 l1 = l1.next;
//             } else {
//                 prev.next = l2;
//                 l2 = l2.next;
//             }
//             prev = prev.next;
//         }
        
//         if (l1 != null) {
//             prev.next = l1;
//         }
//         if (l2 != null) {
//             prev.next = l2;
//         }
//         return temp;
        
        // first approch
//                 if (l2 == null) {
//             return l1;
//         }
//         if (l1 == null) {
//             return l2;
//         }
//         // get the head of the new list
//         ListNode head = null;
//         if (l1.val < l2.val) {
//             head = l1;
//         } else {
//             head = l2;
//         }
//         ListNode list1 = l1;
//         ListNode list2 = l2;
//         ListNode tail1 = null;
//         ListNode tail2 = null;
//         while (l1 != null && l2 != null) {
//             list1 = l1;
//             list2 = l2;
//             if (l1.val < l2.val) {
//                 l1 = l1.next;
//                 list1.next = list2;
//             } else {
//                 l2 = l2.next;
//                 list2.next = list1;
//             }
//         }
        
//         if (l2 != null) {
//             list1.next = l2;
//         }
        
//         if (l1 != null) {
//             list2.next = l1;
//         }
//         return head;
    }
}