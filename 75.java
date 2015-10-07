public class Solution {
    /*public void sortColors(int[] nums) {
        int a = -1;  // point the last red 
        int b = 0; // point the first blue
        int i = 0;
        nums.insert(0,2);
       
        while(i < nums.length){
            if(nums[i] == 0){
               a++;
               swap(nums, a, b);
               swap(nums, i, a);
               b++;
            }
            if(nums[i] == 1){
               swap(nums, b, i);
               b++;
            }
            i++;
        }
    }
    public void swap(int[] num1, int m, int n){
        int temp = 0;
        temp = num1[m];
        num1[m] = num1[n];
        num1[n] = temp;
    }*/
    public void sortColors(int[] nums){ // choose another very simple way to deal with.... T(n) =O(n) ; the method can be better by only one traversal
        int i = 0;
        int num0 = 0;
        int num1 = 0;
        int num2 = 0;
        for(; i < nums.length; i++){
            if(nums[i] == 1)
            num1 ++;
            if(nums[i] == 2)
            num2 ++;
            if(nums[i] ==0)
            num0 ++;
        }
        i = 0;
        while(i < num0){
        nums[i] = 0;
        i++;
        }
        while(i < num0+num1){
        nums[i] = 1;
        i++;
        }
        while(i < num0+num1+num2){
        nums[i] = 2;
        i++;
        }
    }
}

