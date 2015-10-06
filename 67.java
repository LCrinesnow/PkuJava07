public class Solution {
    public String addBinary(String a, String b) {
        
    /*long aa=0;
       long bb=0;
       long c=0;
       String sum="";
       
       aa=Long.parseLong(Long.valueOf(a,2).toString());
       bb=Long.parseLong(Long.valueOf(b,2).toString());
       
       c=aa+bb;
       sum=Long.toBinaryString(c).toString();
       return sum;
       */
       int len1=0;
       int len2=0;
       int len3=0;
       int carry=0;
       //int sum=0;
       String res="";
       
       len1=a.length();
       len2=b.length();
       len3=Math.max(len1, len2);
       
        for  (int i = 0; i < len3; i++) 
        {
           
         int p=0,q=0;
         if(i<len1)
          p = a.charAt(len1-1-i) - '0';         
         else
          p =0;
         if(i<len2)
          q = b.charAt(len2-1-i)-'0';          
         else
          q = 0;
         
         int tmp = p + q + carry;
         carry = tmp / 2;
         res=tmp % 2+res;
         
         /*if(carry==0)
           res=Integer.toString(sum);
         else
           res="1"+Integer.toString(sum);*/

     }      
     return (carry == 0) ? res : "1" +res ;
     
    }
    
}
