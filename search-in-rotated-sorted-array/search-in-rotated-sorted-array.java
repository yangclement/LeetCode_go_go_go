class Solution {
    public int search(int[] nums, int target) {
        //用binary search。首先，怎么找到这个pivot point，也就是缝合的地方
        //binary search劈开的两边都是同时递增或者递减的，这个题目是递增array
        //所以每次binary 判断哪一边的是递增，哪一边是有pivot，再决定去哪一边找target
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] < nums[mid]) {
                //左边是递增，看看target在不在里面
                if (nums[mid] > target && target >= nums[start] ) {
                    //target在里面，走左边
                    end = mid;
                } else {
                    //target不在里面，走右边
                    start = mid;
                }
            } else {
                //右边是递增，同样的逻辑
                if (nums[mid] < target && target <= nums[end]) {
                    //target在里面，走右边
                    start = mid;
                } else {
                    //target不在里面，走左边
                    end = mid;
                }
            } 
            
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}