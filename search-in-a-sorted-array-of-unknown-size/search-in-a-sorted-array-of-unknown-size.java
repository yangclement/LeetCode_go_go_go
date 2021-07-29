/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        //不确定范围，没有办法直接用binary search
        //因为binary search需要一个range
        //所以要使用binary search之前，要先确定他的range
        //一个个找很慢，可以用倍增法，就像是tcp里面的快速重传，不断*2来确定范围
        if (reader.get(0) == target) {
            return 0;
        }
        
        int end = 1;
        while (reader.get(end) <= target) {
            if (reader.get(end) == target) {
                return end;
            }
            end *= 2;
        }
        
        //此时已经可以确定target的范围了，是0-end，可以开始二分
        int start = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }
}