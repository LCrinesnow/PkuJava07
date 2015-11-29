//import java.util.*;

public class Solution {
    public int removeDuplicates(int[] nums) {
        /*
        HashSet set = new HashSet();
        for(int i = 0;i < nums.length; i++)
        {
            //if(!set.contains())
            set.add(nums[i]);
        }
        return set.size();
        */
        int len = 1;
        if(nums.length == 0)
        return 0;
        else
        {
            for(int i = 1;i < nums.length;i++)
            {
                if(nums[i]!=nums[i-1])
                {
                    //num[j]=nums[i];
                    nums[len]=nums[i];
                    len++;
                }

            }
        }
        return len;
    }
}