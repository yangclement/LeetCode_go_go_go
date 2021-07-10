class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null){
            return new int[] {-1,-1};
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            int total = numbers[left] + numbers[right];
            if (total > target){
                right--;
            } else if (total == target) {
                return new int[] {left + 1, right + 1};
            } else {
                left++;
            }
        }
        return new int[] {-1,-1};
    }
}