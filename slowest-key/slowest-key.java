class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        //second approce, double poiter.
        int max=0;
        int prev=0;
        int indexOnKey=0;
        for (int i=0; i<releaseTimes.length;i++){
           int duration = releaseTimes[i]-prev;
           if (duration>max){
               max = duration;
               indexOnKey = i;
           } else if(duration==max){
                //compare the pointer on last max and the pointer on current position in the case they
               //have the same duration
               if (Character.compare(keysPressed.charAt(indexOnKey), keysPressed.charAt(i)) < 0){
                   indexOnKey = i;
               }
           }
            prev = releaseTimes[i];
        }
        return keysPressed.charAt(indexOnKey);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //first approch, bad runtime
//         //1.validate input,no need;
//         List<int[]> duration = new ArrayList<int[]>();
//         int prev = 0;
            //get the duration between each release time
//         for (int i=0; i<releaseTimes.length;i++){
//             int[] temp = new int[]{releaseTimes[i]-prev,i};
//             duration.add(temp);
//             prev = releaseTimes[i];
//         }
        //sort and get the biggest duration time
//         Collections.sort(duration, (a,b) -> b[0]-a[0]);
        
//         List<String> results = new ArrayList<String>();
//         results.add(keysPressed.substring((duration.get(0))[1],(duration.get(0)[1])+1));
//         int max = duration.get(0)[0];
//         for (int j=0; j<duration.size(); j++){
//             if (duration.get(j)[0] == max){
//                 results.add(keysPressed.substring((duration.get(j))[1],(duration.get(j))[1]+1));
//             } else {
//                 break;
//             }
//         }
//         Collections.sort(results, Collections.reverseOrder());
//         return results.get(0).charAt(0);
    }
}