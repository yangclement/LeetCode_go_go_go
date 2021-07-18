class Solution {
    public String addStrings(String num1, String num2) {
        //second approch: 
        StringBuilder result = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        while(i>=0 || j>=0){
            int temp1 = i>=0? num1.charAt(i) - '0':0;
            int temp2 = j>=0? num2.charAt(j) - '0':0;
            int temp3 = (temp1 + temp2 + carry) % 10;
            carry = (temp1 + temp2 + carry)/10;
            result.append(temp3);
            i--;
            j--;
        }
        if (carry!=0){
            result.append(carry);
        }
        return result.reverse().toString();
        //first approch: failed at coverting between char and int
        // int max;
        // int min;
        // String maxString = null;
        // StringBuilder stringBuilder1 = new StringBuilder();
        // if(num1.length()>num2.length()){
        //     min = num2.length();
        //     max = num1.length();
        //     maxString = num1;
        // } else {
        //     min = num1.length();
        //     max = num2.length();
        //     maxString = num2;
        // }
        // boolean carry = false;
        // String hellow;
        // for (int i=min-1; i>=0;i--){
        //     int temp1 = Character.getNumericValue(num1.charAt(i));
        //     int temp2 = Character.getNumericValue(num2.charAt(i));
        //     int temp3 = temp1 + temp2;
        //     if(carry){
        //         temp3++;
        //         carry = false;
        //     }
        //     if (temp3 >= 10){
        //         carry = true;
        //         temp3 -=10;
        //     }
        //     char temp4 = (char)temp3;
        //     stringBuilder1.append(temp4);
        //     hellow = stringBuilder1.toString();
        // }
        // for (int j = max-min-1; j>=0;j--){
        //     char temp = maxString.charAt(j);
        //     if(carry){
        //         int temp1 = (int)temp;
        //         temp1 ++;
        //         if (temp1 >=10){
        //             temp1 -=10;
        //         }
        //         else{
        //             carry = false;
        //         }
        //         temp = (char)temp1;
        //     }
        //     stringBuilder1.append(temp);
        // }
        // return stringBuilder1.toString();
        
    }
}