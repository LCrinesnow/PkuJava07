//import java.util.ArrayList;
//���������������n����MAXֵ���������������ͻ���������������٣�������ac�ˡ�
public class Solution {
    
     public static final int MAX=20000;
     private static int[] temp = new int[MAX];//�����н���ݴ�����
     //List <Integer> temp = new ArrayList<Integer>();
     public int climbStairs(int n) {
        
        /*
        //ʹ�õݹ�ɽ��n�Ƚ�С����������n�ϴ������ֳ�ʱ����
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
    //ʹ�ö�̬�滮
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

//�ڶ��ַ���
import java.util.ArrayList;

public class Solution {
    
     //public static final int MAX=20000;
     //private static int[] temp = new int[MAX];//�����н���ݴ�����
     //List <Integer> temp = new ArrayList<Integer>();
     public int climbStairs(int n) {
     
     //for(int i = 0;i < n;i++)
     //{
         //temp.add(0);
     //}
        /*
        //ʹ�õݹ�ɽ��n�Ƚ�С����������n�ϴ������ֳ�ʱ����
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
    //ʹ�ö�̬�滮
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