public class Solution {
    public int myAtoi(String str) {
        
       
        //int result=0;
        
        //boolean signal=true;
        char signal='+';
        int i=0;
        long result=0;
        
        if(str.length()==0)
            return 0;
        //String []s=str.split("\\ ");
        str=str.trim();
        
        /*if(str.charAt(0)=='-')
           signal=1;
           i++;
        else if(str.charAt(0)=='+')
           signal=0;
           i++;*/
          if(str.charAt(0)=='-' || str.charAt(0)=='+')
          {
              if(str.charAt(0)=='-')
              {
                  signal='-';
                  i++;
              }
              else 
              {
                  //signal=true;
                  i++;
              }
          }
        
        
           
        while (str.length()>i && str.charAt(i) >= '0' && str.charAt(i)<= '9')
        {
            result= result * 10 + (str.charAt(i)-'0');
            if(result>Integer.MAX_VALUE)
                break;
            i++;
           
        }
        
        if(signal=='-')
           result=-result;
           
          if (result >Integer.MAX_VALUE)
          {
              /*if(signal=='-')
              {
                  return Integer.MIN_VALUE;
              }*/
              
		      return Integer.MAX_VALUE;
          }
	       
		    if (result <Integer.MIN_VALUE){
		        /*if(signal=='+')
		        {
		            return Integer.MAX_VALUE;
		        }*/
	    	return Integer.MIN_VALUE;  
	    }
        //return (int)(-result);
         return (int)result;
        //else
        //return (int)result;
        //return (int)(-result);
    }
}