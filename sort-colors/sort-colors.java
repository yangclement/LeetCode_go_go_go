class Solution {
    public void sortColors(int[] nums) {
        //总结：把array分成有三种元素或则以下都可以用这种指针的方法做或者用partition array (quick sort)
        // 但是有三种以上的话，直接就用partition array做就好了
        //使用三个pointer，先用zero pointer指向第一个非零的数，然后用two pointer指向从尾部开始第一个非2的数
        //然后使用curr pointer 走遍这个array，如果是1，next，如果是 0， curr 和 zero 互换， 如果是2， curr和two互换
        if (nums.length <= 1) {
            return;
        }
        int zero = 0;
        int two = nums.length - 1;
        //这个步骤没什么luan用
        // //先找第一个非0的数
        // while (zero < nums.length && nums[zero] == 0) {
        //     zero++;
        // }
        // //找最后一个非2的数
        // while (two >= 0 && nums[two] == 2) {
        //     two--;
        // }
        //i 从 zero + 1的位置开始走, 知道i==two
        int i = 0;
        while (i <= two) {
            if (nums[i] == 0) {
                int temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
                //换完继续找下一个非0的数
                zero++;
                //等于0的时候可以i++，因为i会快于或者等于 zero，有可能i被换成0，不i++会死循环，有可能i被换成1，正好
                //不可能会换成2，因为如果前面有2，一早就和后面的two换了
                i++;
            } else if (nums[i] == 2) {
                int temp = nums[two];
                nums[two] = nums[i];
                nums[i] = temp;
                //这里换完不能i++,因为two这个位置换过来的数不知道是什么，i没有经过过，等下一个while loop来判断是什么
                two--;
            } else {
                //这里的nums[i]是1，让他留在原位置就好了
                i++;
            }
            
        }
        
    }
}