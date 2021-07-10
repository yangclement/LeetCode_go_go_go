class Solution {
    public boolean isRobotBounded(String instructions) {
        //这是一个periodic的题目。
        //一共三种情况：
        //1. 走完当前指令，然后回到原点
        //2. 走完指令，face下面，那再走一次指令就会回到原点
        //3. 走完指令，face左边或者右边，再走三次就会回到原点
        //其实只要走完不是face这上方，就是一个周期性的移动，始终就会回到原点
        //可以想象sin或者cos函数
        //这个direction array的顺序是使得走的路线是逆时针，所以 + 1是turn left
        //+ 3 是turn right。
        //e.g. 一开始是{0 , 1}，往北走。turn left的话是 {-1, 0}往西走 direction = direction + 1;
        //turn right的话是 {1, 0} direction = diretion + 3;
        //防止out of bound所以要%4.
        int[][] direction = new int[][]{{0 , 1}, {-1, 0}, {0, -1}, {1, 0}};
        int j = 0, x = 0, y = 0;
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'L') {
                //如果是turn left的话，就走direction array里面的下一个
                j = (j + 1) % 4;
            } else if (instructions.charAt(i) == 'R') {
                j = (j + 3) % 4;
            } else {
                x = x + direction[j][0];
                y = y + direction[j][1];
            }
        }
        //如果回到了原点或者不在原点且direction不向着north
        return (x == 0 && y ==0) || j != 0;
    }
}