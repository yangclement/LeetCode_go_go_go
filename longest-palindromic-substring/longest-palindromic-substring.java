class Solution {
    //input constrain? empty space inside? empty string?
    public String longestPalindrome(String s) {
        if(s.length()==0||s==null){
            return "";
        }
        char[] charArray = s.toCharArray();
        int start = 0;
        int end = 0;
        for(int i=0;i<s.length();i++){
            //for odd longest substring
            int len1 = findMaxLength(i,i,charArray);
            //dont need this condition, because the while loop in the helper function 
            //will help to check
            // if(i!==s.length-1 & charArray[i]==charArray[i+1]){
            //     len2 = findMaxLength(i,i+1,charArray);
            // }
            //for even longest substring
            int len2 = findMaxLength(i,i+1,charArray);
            //use the len1 and len2 to compare to the (end - start), if so, update start and end
            int currLength = Math.max(len1,len2);
            if(currLength> end-start){
                start = i - ((currLength-1)/2);
                end = i + currLength/2;
            }
        }
        return s.substring(start,end+1);
    
}
    private int findMaxLength(int center1,int center2, char[] charArray){
        int left = center1;
        int right = center2;
        while(left>=0 && right<charArray.length && charArray[left]==charArray[right]){
            left--;
            right++;
        }
        return right-left-1;
    }
}