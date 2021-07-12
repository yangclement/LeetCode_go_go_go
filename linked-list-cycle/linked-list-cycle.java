/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //直接弄个visited的list放所有visited过的node，但是followup是用O(1) space.
        //follow up做法，使用快慢双指针
        //慢指针一次走一步，快指针一次走两步，如果快指针走到头了，证明没有circle （这个情况肯定会end earlier）
        //如果慢指针走完了一圈和快指针相遇了（此时快指针应该走完两圈）就是有circle
        //但是这题是linkedlist，我们不知道长度无法定义一圈，就用while loop让这两个指针一直走
        //走到相遇为止
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        //快慢指针的经典题。 快指针每次走两步，慢指针一次走一步。 在慢指针进入环之后，快慢指针之间的距离每次缩小1，所以最终能相遇。
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}