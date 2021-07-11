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
        
        if (lists==null || lists.length==0) return null;
        //使用minheap，把k 个array的head都先放进去，直接pop就可以得到当前head的最小值
        //minheap是 a - b， maxheap是 b - a
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>((a,b)-> a.val-b.val);
        
        ListNode dummy = new ListNode(0);
        ListNode curr=dummy;
        int k = lists.length;
        for (int i = 0; i < lists.length; i++) {
            //其中有一些sorted array是空的，跳过
            if (lists[i] == null) {
                k--;
                continue;
            }
            queue.offer(lists[i]);
        }
        
        while (k > 0){
            curr.next = queue.poll();
            curr = curr.next;
            
            if (curr.next == null){
                k--;
                continue;
            }
            queue.offer(curr.next);
        }
        return dummy.next;
    }
}