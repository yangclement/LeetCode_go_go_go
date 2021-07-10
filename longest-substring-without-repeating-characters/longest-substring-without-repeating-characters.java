class Solution {
    //input constrain? case sensitive? empty string?
    public int lengthOfLongestSubstring(String s) {        
        //first approch, but the runtime is not faster enough
        //double pointer traversal the string array;
        
        if(s.length()==0){
            return 0;
        }
        char[] charArray = s.toCharArray();
        HashMap<Character, Integer> position = new HashMap<>();
        int maxLength = 0;
        int prevPointer = 0;
        for(int i=0;i<charArray.length;i++){
            char curr = charArray[i];
            //如果已经有这个char，算目前的最长看看是不是大于max，也就是用现在的index-previous pointer的index，然后把
            //map里面curr的char的index拿出来加一变成prev pointer（从头开始with a new current char）。
            if(position.containsKey(curr)){
                //remove the char before previous char the same as the current one
                //we actually dont need this one, just compare the prevPointer and index from the map
                //and get the max one, so that the prePointer wont go back to the index less than prePointer
                // for(int j =prevPointer; j<currLength;j++){
                //     position.remove(charArray[j]);
                // }
                prevPointer = Math.max(prevPointer, position.get(curr) + 1);
            }
            //不仅仅遇到duplicate的char才计算，要每一个loop都计算，以免miss了最后一个位置（最后一个
            //不contains的话就不计算了)
            //需要+1因为这个是出现duplicate之前的一个index，出现了之后，prepointer就已经在if里面改变了
            //conclusion：遇到了duplicate再去减也可以，但是会miss最后一个，就要在foor loop外面加一个last one checking
            int length = i - prevPointer +1;
            if(length > maxLength){
                maxLength = length;
            }
            position.put(curr,i);
        }
        //the last element is not counted because of the foor loop times
        // if(charArray.length-prevPointer>maxLength){
        //     maxLength = charArray.length-prevPointer;
        // }
        return maxLength;
    }
}