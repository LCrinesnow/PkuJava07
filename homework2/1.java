import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //int i = 0;
        //int index1 = 0;
        //int index2 = 0;
        //HashSet set = new HashSet();
        //Hashtable table = new Hashtable();
        Hashtable<Integer,Integer> table=new Hashtable<Integer,Integer>();
        int res = 0;
        //int res1 = 0;
        //int res2 = 0;
        int[] result = new int [2];
        //index1=(int)(Math.random()*nums.length);
        //index2=(int)(Math.random()*nums.length);
        
        
        for(int i=0;i<nums.length;i++)
        {
    	 Integer iint = i;
    	 Integer num = nums[i];
    	 table.put(num,iint); 
        }
        //int[] num = (int[])set.toArray(new int[0]);//生成新数组
         //for(i=0;i<num.length;i++)
        //{
            //if(index1<index2)
            //{
                
            //}
            //else
        //}
        for(int j = 0;j < nums.length;j++)
        {
            res = target - nums[j];
            if(table.get(res)!= null && table.get(res)!= j)
            {
                //res1 = res;
                //res2 = nums[i];
                result[0] = j+1;
                result[1] = table.get(res)+1;
                return result;
            }
        /*
        for( i =0 ;i< nums.length;i++)
        {
            if(nums[i].equals(res1))
            {
                
            }
        }*/
        
      }
     return result;
  }
 
}