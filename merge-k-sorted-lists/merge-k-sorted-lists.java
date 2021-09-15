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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        int k = 0;
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            queue.offer(list);
            k++;
        }
        
        while (k > 0) {
            ListNode currNode = queue.poll();
            curr.next = currNode;
            if (currNode.next == null) {
                k--;
                curr = curr.next;
                continue;
            }
            
            queue.offer(currNode.next);
            curr = curr.next;
        }
        
        return dummy.next;
    }
}