class Solution {
    //starting: validation of the input: 1. negative number? 2.the intervals are always increasing?
    //is start always greater than end?
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0 || intervals.length==1){
            return intervals;
        }
        //sorted array fixed most of the problems
        Arrays.sort(intervals, (a,b)->-b[0]+a[0]);
        int[][] results = new int[0][2];
        // boolean combined = false;
        int[] combinedArray = intervals[0];
        for (int i=1; i<intervals.length;i++){
            int[] curr = combinedArray;
            int[] next = intervals[i];
            //condition 1: 可以combine
            if(curr[1]-next[0]>=0){
                combinedArray = new int[]{curr[0],Math.max(next[1],curr[1])};
                // results = addElement(results, new int[]{curr[0],next[1]});
                // combined = true;
                if(i==intervals.length-1){
                    results = addElement(results, combinedArray);
                }
            }
            else {
                results = addElement(results, combinedArray);
                combinedArray = next;
                if (i==intervals.length-1){
                    results = addElement(results, next);
                }
                // combined = false;
            }
            // else{
            //     results = addElement(results, curr);
                //if the last two intervals are not overlap, since the foor loop is ended at i=length-                  //2, which will miss the last element from the original array. In this case,
                // we need to add the last element to the result if the j pointer reaches the end.
                // if(j == intervals.length-1){
                //     results = addElement(results, next);
                // }
            }
        return results;
        }
    
        public int[][] addElement(int[][] results,int[] result){
            results  = Arrays.copyOf(results, results.length + 1);
            results[results.length - 1] = result;
            return results;
        }
        
        
    }
    

