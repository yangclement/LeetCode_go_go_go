class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //如果面试可以从这种做法做起：走第一个col，看看target在哪，确认了在哪一个row，然后再进入row里面找，
        //等于用了两次binary search，但是load每个col很浪费时间，因为按col来做memory cache
        //考点：把2d matrix当作是一维array就好了
        //2D -> 1D: [i][j] -> [i * m + j], m是col的数量
        //1D -> 2D: i = index / m, j = index % m;用这个方法就可以把二维当作一维做了
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix[0].length;
        int n = matrix.length;
        int start = 0;
        // index of 1d array = nm
        
        int end = m * n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int curr = getNumber(mid, matrix, m);
            if (curr == target) {
                return true;
            } else if (curr < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (getNumber(start, matrix, m) == target) {
            return true;
        }
        if (getNumber(end, matrix, m) == target) {
            return true;
        }
        return false;
    }
    
    // use helper function to use the index from 1d array to get the number from 2d array
    private int getNumber(int index, int[][] matrix, int m) {
        int i = index / m;
        int j = index % m;
        return matrix[i][j];
    }
}