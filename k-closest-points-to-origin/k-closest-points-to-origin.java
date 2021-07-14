class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //找k个点一般都用heap来做，这里是最近的点，所以比较远的点要pop掉，很明显应该用max heap
        if (points == null) {
            return null;
        }
        if (points.length < k) {
            return points;
        }
        //低级错误这里，算平方不能直接nums^2, 要么Math.pow(),但是这个input必须要是doulbe，最直接就nums * nums吧
        PriorityQueue<int[]> nearestKpoints = new PriorityQueue<int[]>((a, b) ->
                                                b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);
        for (int i = 0; i < points.length; i++) {
            nearestKpoints.offer(points[i]);
            //保持heap里面只有k个elements
            if (nearestKpoints.size() > k) {
                nearestKpoints.poll();
            }
        }
        
        int[][] results = new int[k][2];
        for (int j = 0; j < k; j++) {
            results[j] = nearestKpoints.poll();
        }
        return results;
    }
}