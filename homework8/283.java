
public class Solution {
    public void moveZeroes(int[] nums) {
        
        /*
        //int p = nums.length-1;
        
        //初步思路是遍历整个数组，如果为0，那么将其放到数组最后
        for(int i = 0;i < nums.length-1;i++)
        {
                 nums[i] = nums[i+1];
                 nums[nums.length-1]=temp; 
        }
        */
        int temp = 0;
        for(int i = 0;i < nums.length;i++)
        {
            if(nums[i] != 0)
            {
                nums[temp] = nums[i];
                temp++;//重新覆盖原先数组，不需要再拷贝其他数组
            }
        }
        for(; temp < nums.length;temp++)
        {
            nums[temp] = 0;
        }
    }
}