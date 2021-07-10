class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int start1 = 0;
        int start2 = 0;
        int index = 0;
        int[] temp = new int[m + n];
        while (start1 < m && start2 < n) {
            if (nums1[start1] < nums2[start2]) {
                temp[index++] = nums1[start1++];
            } else {
                temp[index++] = nums2[start2++];
            }
        }
        
        while (start1 < m) {
            temp[index++] = nums1[start1++];
        }
        while (start2 < n) {
            temp[index++] = nums2[start2++];
        }
        for (int i = 0; i < m +n; i++) {
            nums1[i] = temp[i];
        }
    }
}