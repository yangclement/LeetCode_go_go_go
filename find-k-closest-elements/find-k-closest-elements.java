class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //使用binary search找到这个array关于这个target的分界线，然后把这个array分成两半，然后用merge sort的方法一个个加入array
        //把这个array分成两半，分界线可以在tartge的左边或者右边
        //先binary search找分界线，这里使用小于target的最右边的数字
        int left = findBoundary(arr, x);
        int right = left + 1;
        //找到边界了，使用merge，拿k个element进array
        mergeKelement(arr, left, right, k, x);
        //因为这里要升序，所以要sort，但是就要nlogn，可以使用k个值的起始位置和end位置一个个加进去
        // Collections.sort(results);
        return mergeKelement(arr, left, right, k, x);
    }
    private List<Integer> mergeKelement(int[] arr, int left, int right, int k, int target) {
        while (k > 0) {
            if (left < 0) {
                right++;
            } else if (right > arr.length - 1) {
                left--;
            } else if (target - arr[left] <= arr[right] - target) {
                left--;
            } else {
                right++;
            }
            k--;
        }
        List<Integer> results = new ArrayList<Integer>();
        for (int i = left + 1; i < right; i++) {
            results.add(arr[i]);
        }
        return results;
    }
    private int findBoundary(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        //最右边，所以从end开始
        if (arr[end] < target) {
            return end;
        } else {
            return start;
        }
    }
}