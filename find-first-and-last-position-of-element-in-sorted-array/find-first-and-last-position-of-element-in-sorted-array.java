class Solution {
    public int[] searchRange(int[] nums, int target) {
        //用binary search找到第一个element，然后用while loop找到最后一个element的position
        //!!!!!这个方法不对，因为找到了第一个element，用while loop去找last element的runtime是O(N)
        //如果用两次binary search，1 次找第一个位置, 1 次找第二个位置，这样是连个logn still O(logn)
        if (nums == null || nums.length  < 1) {
            return new int[] {-1, -1};
        }
        int first = 0;
        int last = 0;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) {
            first = start;
        } else if (nums[end] == target){
            first = end;
        } else {
            return new int[] {-1, -1};
        }
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            last = end;
        } else {
            last = start;
        }
        return new int[] {first, last};
        // int start = 0;
        // int end = nums.length - 1;
        // while (start + 1 < end) {
        //     int mid = start + (end - start) / 2;
        //     //就算找到了target也要继续往左走，因为当前有可能不是第一个position的element
        //     if (nums[mid] == target) {
        //         end = mid;
        //     } else if (nums[mid] < target) {
        //         start = mid;
        //     } else {
        //         end = mid;
        //     }
        // }
        // //出来以后有start和end两个数还没有check.
        // int first = -1;
        // if (nums[start] == target) {
        //     first = start;
        // } else if (nums[end] == target) {
        //     first = end;
        // }
        // int last = first;
        // while (first != -1 && last < nums.length - 1 && nums[last] == nums[last + 1]) {
        //     last++;
        // }
        // return new int[]{first, last};
    }
}