class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //使用monotic queue，保持queue里面的顺序是递增，这样后面新加入的element
        //只需要和当前windows的最大值比，不必要和所有值比较
        //如果面试可以从windows的binary search开始，这样就是nlogk
        if (nums == null) {
            return null;
        }
        if (nums.length == 1) {
            return nums;
        }
        //这里使用linkedlist一样的，都是可以双开口，头和尾都可以remove和add
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int[] results = new int[nums.length - k + 1];
        //[3 -1] k = 3, i = 3
        //[3 -1 -3]
        //[5 3] 
        //用queue来记录index好像更高效？
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            
            //valid 的最大值已经超出
            if (!queue.isEmpty() && i - k + 1 > queue.peekFirst()) {
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if (i >= k - 1) {
                results[j++] = nums[queue.peekFirst()];
                
            }
        }
        return results;
    }
}