import java.util.*;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        if(nums.length == 0)
           return false; 
        boolean flag = false;
        HashSet set = new HashSet();
        
        for(int i = 0;i < nums.length;i++)
        {
            if(set.contains(nums[i]))
               return true;
            else
            {
                set.add(nums[i]);
                continue;
            }
        }
        return false;
    }
}