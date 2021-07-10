class Solution {
    public boolean isValid(String s) {
        //second approch, 使用stack， last in first out
        Stack<Integer> path = new Stack<>();
        for (int i=0; i<s.length(); i++){
            char temp = s.charAt(i);
            if(temp == '('){
                path.push(1);
            }else if(temp == '['){
                path.push(2);
            } else if (temp == '{') {
                path.push(3);
            } else if (temp == ')'&&!path.empty()) {
                Integer temp2 = path.pop();
                if(temp2.compareTo(1) !=0){
                    return false;
                }
            }else if (temp == ']'&&!path.empty()) {
                Integer temp2 = path.pop();
                if(temp2.compareTo(2)!=0){
                    return false;
                }
            } else if (temp == '}'&&!path.empty()) {
                Integer temp2 = path.pop();
                if(temp2.compareTo(3)!=0){
                    return false;
                }
            } else{
                return false;
            }
            
        }
        return path.empty();
        //first approch, 只能用来做是否左右的数量刚好一样，不能解决要一定order的问题like（【）】。
        // int check = 0;
        // for (int i=0; i<s.length(); i++){
            // char temp = s.charAt(i);
            // if(temp == '('){
            //     check+=1;
            // }else if(temp == '['){
            //     check+=2;
            // } else if (temp == '{') {
            //     check+=3;
            // } else if (temp == ')') {
            //     check-=1;
            // } else if (temp == ']') {
            //     check-=2;
            // } else if (temp == '}') {
            //     check-=3;
            // }
        // }
        // return check == 0;
    }
}