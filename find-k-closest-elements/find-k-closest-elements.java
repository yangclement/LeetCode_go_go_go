class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //使用binary search找到这个array关于这个target的分界线，然后把这个array分成两半，然后用merge sort的方法一个个加入array
        //把这个array分成两半，分界线可以在tartge的左边或者右边
        //先binary search找分界线，这里使用小于target的最右边的数字
        int left = findBoundary(arr, x);
        int right = left + 1;
        //找到边界了，使用merge，拿k个element进array
        List<Integer> results = new ArrayList<Integer>();
        mergeKelement(results, arr, left, right, k, x);
        Collections.sort(results);
        return results;
    }
    private void mergeKelement(List<Integer> results, int[] arr, int left, int right, int k, int target) {
        while (k > 0) {
            if (left < 0) {
                results.add(arr[right]);
                right++;
            } else if (right > arr.length - 1) {
                results.add(arr[left]);
                left--;
            } else if (target - arr[left] <= arr[right] - target) {
                results.add(arr[left]);
                left--;
            } else {
                results.add(arr[right]);
                right++;
            }
            k--;
        }
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