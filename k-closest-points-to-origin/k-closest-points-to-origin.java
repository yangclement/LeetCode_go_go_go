class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //找k个点一般都用heap来做，这里是最近的点，所以比较远的点要pop掉，很明显应该用max heap
        if (points == null) {
            return null;
        }
        if (points.length < k) {
            return points;
        }
        PriorityQueue<int[]> nearestKpoints = new PriorityQueue<int[]>((a, b) ->
                                                b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);
        for (int i = 0; i < points.length; i++) {
            nearestKpoints.offer(points[i]);
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