//import java.util.ArrayList;
//这个方法不适用于n超过MAX值的情况，如果超过就会出错。由于用例较少，所以它ac了。
public class Solution {
    
     public static final int MAX=20000;
     private static int[] temp = new int[MAX];//把运行结果暂存起来
     //List <Integer> temp = new ArrayList<Integer>();
     public int climbStairs(int n) {
        
        /*
        //使用递归可解决n比较小的情况，如果n较大，则会出现超时错误。
        int method=0;
        
        //if(n == 0)
         //return 0;
        //else if(n == 1)
        if(n == 0 || n == 1)
          return 1;
        else //if(n > 2)
        {
            method = climbStairs(n-1) + climbStairs(n-2);
            return method;
        }
        //else
         //return 2;
    }*/
    //使用动态规划
    //int method = 0;
    if(n == 0 || n == 1)
      return 1;
    if(temp[n]!= 0)
    {
        return temp[n];
    }
    temp[n] = climbStairs(n-1) + climbStairs(n-2);
    return temp[n];
   }
}

//第二种方法
import java.util.ArrayList;

public class Solution {
    
     //public static final int MAX=20000;
     //private static int[] temp = new int[MAX];//把运行结果暂存起来
     //List <Integer> temp = new ArrayList<Integer>();
     public int climbStairs(int n) {
     
     //for(int i = 0;i < n;i++)
     //{
         //temp.add(0);
     //}
        /*
        //使用递归可解决n比较小的情况，如果n较大，则会出现超时错误。
        int method=0;
        
        //if(n == 0)
         //return 0;
        //else if(n == 1)
        if(n == 0 || n == 1)
          return 1;
        else //if(n > 2)
        {
            method = climbStairs(n-1) + climbStairs(n-2);
            return method;
        }
        //else
         //return 2;
    }*/
    //使用动态规划
    int[] temp = new int[n];
    //int method = 0;
    if(n < 2)
      return n;
    else
    {
    //int[] temp = new int[n];
    
     temp[0] = 1;
     temp[1] = 2;
    //if(n == 0 || n == 1)
      //return 1;
    //temp[n] = climbStairs(n-1) + climbStairs(n-2);
    for(int i=2;i<n;i++)
    {
      temp[i] = temp[i-1] + temp[i-2];
     
    }
   
   }  
   return temp[n-1];
    }
}