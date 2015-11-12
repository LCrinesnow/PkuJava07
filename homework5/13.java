public class Solution {
    public int romanToInt(String s) {
          char roman[] = s.toCharArray();
          int len = s.length();
          int[] number = new int[len];
          int num = 0;
          for(int i = 0; i < len;i++){
              switch (roman[i]) {  
                case 'I': number[i] = 1;  break;
                case 'V': number[i] = 5;  break;
                case 'X': number[i] = 10;  break;
                case 'L': number[i] = 50;  break;
                case 'C': number[i] = 100;  break;
                case 'D': number[i] = 500;  break;
                case 'M': number[i] = 1000;  break;
              }
            }  
          /*if(len ==1) return number[0];
          for(int i = 0; i < len-1;i++){
              if(number[i] >= number[i+1])
              num += number[i];
              else{
              num = num + (number[i+1] - number[i]);
              i++;
            }
          if(number[len-2]>=number[len-1])
              num =num + number[len-1];*/
          for(int i=len-1;i>=0;i--){  
                if(i==len-1)  
                   {  
                     num=number[i];  
                     continue;  
                   }  
                if(number[i] >= number[i+1])  
                     num += number[i];  
                else  
                     num -= number[i]; 
          }
         return num;
        }
}