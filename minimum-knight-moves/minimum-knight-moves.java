class Solution {
    public int minKnightMoves(int x, int y) {
        //在bfs里面，在这种matrix里面，最好先用方向向量来定义一下，他所能移动的方向
        //因为guarrent 有一个 answer就不用edges case check了.
        int[][] directions = new int[][]{{-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
        Queue<int[]> queue = new ArrayDeque<>();
        //这道题solution说了不能用set，会time limit,用boolean[][]
        // Set<int[]> visited = new HashSet<>();
        //x 和 y的范围是-300 到300，可以把整个棋盘总体往右移300，就是0到600
        boolean[][] visited = new boolean[605][605];
        queue.add(new int[]{0, 0});
        visited[302][302] = true;
        int length = 0;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currPos = queue.poll();
                if (currPos[0] == x && currPos[1] == y) {
                        return length - 1;
                    }
                for (int[] direction : directions) {
                    int row = currPos[0] + direction[0];
                    int col = currPos[1] + direction[1];
                    int[] nextPos = new int[]{row, col};
                    //这里必须判断！的情况，如果你看的是有没有visited会out of bound，但是！的话无论是false或者null都会return true，不会有out of bound的问题
                    if (!visited[row + 302][col + 302]) {
                        queue.add(nextPos);
                        visited[row + 302][col + 302] = true;
                    }
                }
            }
        }
        return -1;
    }
}