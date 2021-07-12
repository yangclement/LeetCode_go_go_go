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
        //用queue来记录index好像更高效，因为你可以根据index去找数字，但是你不能根据数字去找index
        //还需要用index来看当前的最大值是不是已经out of sliding windows了
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //valid 的最大值已经超出window size
            if (!queue.isEmpty() && i - k + 1 > queue.peekFirst()) {
                queue.removeFirst();
            }
            //把queue里面小于当前值nums[i]的都pop掉，之后只需要拿后面的数(nums[j], j > i)和当前值nums[i]比较就可以了
            //小于的数留着没用。如果queue里面还有数，就是这个数nums[i]之前的数(nums[k], k < i),虽然nums[k]现在比nums[i]大，
            //但是随着windows的滑动，nums[k]很有可能就会被上面那个condition删除，nums[i]可以作为最大值的candidates
            //这个while loop看上去好像会造成nk复杂度，但是因为其事所以element之后被add 或者remove一次，所以时间是O(n)
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