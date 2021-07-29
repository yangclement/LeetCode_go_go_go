class Solution {
    public int findMin(int[] nums) {
        //binary search
        //看看哪边mid 是 大于end （本来应该是mid < end）就去哪边
        //另一边则是有pivot的
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                //mid 大于end，去右边
                start = mid;
            } else {
                end = mid;
            }
        }
        return nums[start] < nums[end]? nums[start] : nums[end];
    }
}