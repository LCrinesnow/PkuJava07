public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();//½á¹û¼¯
        
        Arrays.sort(nums);
        
        if(nums == null || nums.length <4) 
              return result;
        
        
        for(int i = 0;i< nums.length-3;i++)
        {
            if( i>0 && nums[i] == nums[i-1]) 
                continue; 
            
            for(int j = i+1;j<nums.length-2;j++)
            {
                 if (j > i+1 && nums[j] == nums[j-1]) 
                   continue;  
                 
                int half = nums[i]+nums[j];
                int rs = target-half;
                
                int p = j+1;
                int q = nums.length-1;
                
                while( p < q )
                {
                    if(nums[p]+nums[q]==rs)
                    {
                        List<Integer> ret = new ArrayList<Integer>();
                        ret.add(nums[i]);
                        ret.add(nums[j]);
                        ret.add(nums[p]);
                        ret.add(nums[q]);
                        result.add(ret);
                        p++;
                        q--;
                        
                        while (p < q && nums[p] == nums[p-1]) 
                            p++;  
                        while (p < q && nums[q] == nums[q+1]) 
                            q--; 
                    }
                    else if(nums[p]+nums[q] < rs)
                       p++;
                    else
                       q--;
                }
            }
        }
        return result;
    }
}