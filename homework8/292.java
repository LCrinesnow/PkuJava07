public class Solution {
    public boolean canWinNim(int n) {
        
        //如果开始有少于三个的石头或者到自己时候只剩下1、2、3个石头，那么自己肯定会赢
        //也就是只要出现4N的时候就肯定为输
        /*
        if (n == 1 || n == 2 || n == 3)
          return true;
        else if()
        {
            
        }
        else
         return false;
    }*/
    return (n%4 == 0)?false:true;
   }
}
}