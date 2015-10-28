import java.util.*;

public class Solution {
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();//最终的结果List
    
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        Hashtable<Integer,Integer> table=new Hashtable<Integer,Integer>();
        //int res = 0;
        int res1 = 0;
        int res2 = 0;
        int target=0;
        //int[] result = new int [3];
        List<List<Integer>> result=new ArrayList<List<Integer>>(); 
        //index1=(int)(Math.random()*nums.length);
        //index2=(int)(Math.random()*nums.length);
        
        //set.addAll(Arrays.asList(nums));//转换为hashset，并除去相同的元素
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
        for(int i = 0;i < nums.length;i++)
        {
            res1= target - nums[i];
            for(int j = 0;j < nums.length;j++)
            {
                res2= res1 - nums[j];
              if(table.get(res1)!= null && table.get(res2)!= null && table.get(res2)!= j&& table.get(res1)!= i)
              {
                //res1 = res;
                //res2 = nums[i];
                result.get(0) = i+1;
                result.get(1) = table.get(res1)+1;
                result.get(2)= table.get(res2)+1;
                
                return result;
              }
            }
        
        for( i =0 ;i< nums.length;i++)
        {
            if(nums[i].equals(res1))
            {
                
            }
        }
        
      }
     return result;
     }*/
     //延续上节课的意思，首先对这组数据排序，接着转化为two sum的问题，使用两个指针的方法
     
     //
     
     if(nums == null || nums.length < 3)
           return result;
     //第一步排序，由于是ArrayList，所以可以直接调用ArrayList里面的排序库函数
     Arrays.sort(nums);
     
     //第二步，设置两个指针p和q，p为开头，q为数组最后，遍历数组
   
     
     for(int i = 0;i < nums.length-2;i++)
     {
         if(i > 0 && nums[i]==nums[i-1])
            continue;
         
         judge(nums,i+1,nums.length-1,nums[i]);
     }
     return result;
    }  
     public void judge(int[] num,int start,int end,int tag)
     {
         int p=start;int q=end;
         
         while(p<q)
         {
             if(num[p]+num[q]+tag==0)
             {
                 List<Integer> res=new ArrayList<Integer>();
                 //res.add(num[p]);
                 //res.add(num[q]);   注意结果集的顺序问题
                 //res.add(tag);
                 res.add(tag);
                 res.add(num[p]);
                 res.add(num[q]);
                 result.add(res);
                 
                 while( (p<q) && (num[p]==num[p+1]))
                      p++;
                 while( (p<q) && (num[q]==num[q-1]))
                      q--;
                 
                 p++;
                 q--;
             }
             else if(num[p]+num[q]+tag>0)
             {
                      q--;
             }
             else
             {
                      p++;
             }
         }
     }
}