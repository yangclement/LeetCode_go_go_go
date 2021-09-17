class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[right.length - 1] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            left[i + 1] = nums[i] * left[i];
        }
        
        for (int i = nums.length - 1; i > 0; i--) {
            right[i - 1] = nums[i] * right[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
            right[i] *= left[i];
        }
        return right;
    }
}