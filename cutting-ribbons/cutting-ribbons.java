class Solution {
    public int maxLength(int[] ribbons, int k) {
        //这题很巧妙的是，在答案集上面做binary search
        //就是不能在原数组上面做二分，需要用原数组做完计算再二分
        //很容易想到，当要切割的目标长度越短，可以得到的k越大
        //当要切割的目标长度越长，可以得到的k越小
        //所以相当于在这个不同的长度这个答案集上面找k符合input
        if (ribbons == null || ribbons.length == 0) {
            return -1;
        }
        int start = 1;
        //这个end应该怎么找
        //1.肯定要小于或者等于ribbons里面的最大值
        //2.k * length <= sum of ribbons
        //拿这两个最restrict的数字
        int max = Integer.MIN_VALUE;
        //sum要是long，因为可能超出int的
        long sum = 0;
        for (int i = 0; i < ribbons.length; i++) {
            max = Math.max(max, ribbons[i]);
            sum += ribbons[i];
        }
        int end = (int)Math.min(max, (sum / k));
        if (end <= 0) {
            return 0;
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //当前的length是mid，看看k是多少
            int numOfRibbons = findK(ribbons, mid);
            if (numOfRibbons < k) {
                //小于k意味着不够多，所以要缩小长度，使得数量变多，往左走
                end = mid;
            } else {
                //等于也要继续往右走，因为有可能有相同的k使得length更大
                start = mid;
            }
        }
        //end要在前面因为如果相同，end的长度会比start的长
        int a = findK(ribbons, end);
        int b = findK(ribbons, start);
        //如果找不到刚刚好k，那就找最长长度的且大于且最接近k
        if (findK(ribbons, end) >= k) {
            return end;
        } else{
            return start;
        }
    }
    
    private int findK(int[] ribbons, int length) {
        int count = 0;
        for (int ribbon : ribbons) {
            count += (ribbon / length);
        }
        return count;
    }
}