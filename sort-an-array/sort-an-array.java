class Solution {
    public int[] sortArray(int[] nums) {
        
        if (nums == null) {
            return null;
        }
        if (nums.length == 1) {
            return nums;
        }
        //quicksort
        // quicksort(0, nums.length - 1, nums);
        // return nums;
        
        //mergesort
        int[] temp = new int[nums.length];
        mergesort(0, nums.length - 1, nums, temp);
        return nums;
    }
    
    private void mergesort(int start, int end, int[] nums, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergesort(start, mid, nums, temp);
        mergesort(mid + 1, end, nums, temp);
        merge(start, end, mid, nums, temp);
        
    }
    
    private void merge(int start, int end, int mid, int[] nums, int[] temp) {
        int left = start;
        int leftEnd = mid;
        int right = mid + 1;
        int rightEnd = end;
        int index = start;
        
        while (left <= leftEnd && right <= rightEnd) {
            if (nums[left] < nums[right]) {
                temp[index] = nums[left];
                left++;
                index++;
            } else {
                temp[index] = nums[right];
                right++;
                index++;
            }
        }
        
        while(left <= leftEnd) {
            temp[index] = nums[left];
            index++;
            left++;
        }
        
        while(right <= rightEnd) {
            temp[index] = nums[right];
            index++;
            right++;
        }
        
        for (int i = start; i < end + 1; i++) {
            nums[i] = temp[i];
        }
    }
    
//     private void quicksort(int start, int end, int[] nums){
//         if (start >= end) {
//             return;
//         }
//         int mid = start + (end - start) / 2;
//         int left = start;
//         int right = end;
//         int pivot = nums[mid];
//         while (left <= right) {
//             while (left <= right && nums[left] < pivot) {
//                 left++;
//             }
            
//             while (left <= right && nums[right] > pivot) {
//                 right--;
//             }
            
//             if(left <= right) {
//                 int temp = nums[left];
//                 nums[left] = nums[right];
//                 nums[right] = temp;
//                 left++;
//                 right--;
//             }
//         }
//         quicksort(start, right, nums);//left part
//         quicksort(left, end, nums);//right part
//         return;
//     }
}