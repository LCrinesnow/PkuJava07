
public class Solution {
    public void moveZeroes(int[] nums) {
        
        /*
        //int p = nums.length-1;
        
        //����˼·�Ǳ����������飬���Ϊ0����ô����ŵ��������
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
                temp++;//���¸���ԭ�����飬����Ҫ�ٿ�����������
            }
        }
        for(; temp < nums.length;temp++)
        {
            nums[temp] = 0;
        }
    }
}