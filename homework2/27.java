public class Solution {
    public int removeElement(int[] nums, int val) {
        
        int len=0;
        //int j=0;
        //int [] num=new int[nums.length];
        
        for(int i=0;i<nums.length;i++)
        {
            //for(j=0;j<num.length;j++)
            //{
                if(nums[i]!=val)
                {
                    //num[j]=nums[i];
                    nums[len]=nums[i];
                    len++;
                }
        }
         return len;
        }
       
    }