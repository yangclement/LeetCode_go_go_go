class Solution {
    public int findKthLargest(int[] nums, int k) {
        //quickselect, similar to quicksort
        // if (nums == null) {
        //     return null;
        // }
        int result = quickselect(0, nums.length - 1, k, nums);
        return result;
    }
    
    private int quickselect(int start, int end, int k, int[] nums) {
        if (start >= end) {
            return nums[start];
        }
        
        int left = start;
        int right = end;
        int pivot = nums[start + (end - start) / 2];
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            // if left == right, will enter this condition, which could cause there is a number between left and right. We need to dead with this number later
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
            
            //The above part is the same as the quicksort.
            //here, the array is possibly divided into three part.
            //left, middle (from the condition above), right.
            //k in left side.
            if (start + k - 1 <= right) {
                return quickselect(start, right, k, nums);
            }
            //k in the right side.
            if (start + k - 1 >= left) {
                //here should not be k - left for the new k
                //这个时候要走右边，左边会有 left - start 个数，对于k来说就少了 left -start个数，
                //所以新的k = k - (left - start)
                return quickselect(left, end, k - (left - start), nums);
            }
            
            // If the code reaches here, it means there is a middle part
            return nums[right + 1];
            
        
    }
}