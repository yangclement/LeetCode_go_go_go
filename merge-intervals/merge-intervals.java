class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return null;
        }
        
        Arrays.sort(intervals, (a , b) -> a[0] - b[0]);
        
        int[][] results = new int[0][2];
        int index = 0;
        int lastStart = intervals[0][0];
        int lastEnd = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] <= lastEnd) {
                lastEnd = Math.max(lastEnd, interval[1]);
            } else {
                results = Arrays.copyOf(results, results.length + 1);
                int[] result = new int[] {lastStart, lastEnd};
                lastStart = interval[0];
                lastEnd = interval[1];
                results[results.length - 1] = result;
            }
        }
        results = Arrays.copyOf(results, results.length + 1);
        results[results.length - 1] = new int[] {lastStart, lastEnd};
        
        return results;
    }
}