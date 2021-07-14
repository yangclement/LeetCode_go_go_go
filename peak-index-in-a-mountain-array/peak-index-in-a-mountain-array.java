class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        //O(n) 找最大值，too easy lar
        //使用binary search
        //错误：判断 arr[i] > arr[i + 1] && arr[i] > arr[i - 1];
        //没必要，只需要判断arr[i] > arr[i + 1]， 第一个开始下降的地方必定是peak
        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                //已经开始下降，也有可能mid本身就是peak，不知道所以要继续
                end = mid;
            } else {
                start = mid;
            }
        }
        if (arr[start] > arr[end]) {
            return start;
        } else if (end == arr.length - 1 || (end < arr.length - 1 && arr[end] > arr[end - 1])) {
            return end;
        }
        return -1;
    }
}