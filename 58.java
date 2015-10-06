public class Solution {
    public int lengthOfLastWord(String s) {
        
        //int len=0;
        //int i=0;
        
        
       // if(s.IsEmpty())
           // return 0;
        //else
        //{
        String [] stringArr= s.split("\\ ");
        if(stringArr.length==0)
           return 0;
        //else if(stringArr.length==1)
           //return stringArr[0].length();
        else
           return stringArr[stringArr.length-1].length();
        //}
        //return 0;
       } 
    }