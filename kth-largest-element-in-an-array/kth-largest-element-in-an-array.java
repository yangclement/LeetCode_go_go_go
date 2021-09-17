class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null) {
            return -1;
        }
        int results = quickSelect(nums, k, 0, nums.length - 1);
        return results;
    }
    
    private int quickSelect(int[] nums, int k, int start, int end) {
        if (start >= end) {
            return nums[start];
        }
        int left = start;
        int right = end;
        int mid = nums[start + ((end - start) / 2)];
        while (left <= right) {
            while (left <= right && nums[left] > mid) {
                left++;
            }
            while (left <= right && nums[right] < mid) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if (start + k - 1 >= left) {
            return quickSelect(nums, k - (left - start), left, end);
        }
        if (start + k - 1 <= right) {
            return quickSelect(nums, k, start, right);
        }
        return nums[right + 1];
    }
}