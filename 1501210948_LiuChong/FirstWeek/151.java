package Reverse_Words_in_a_String;
import java.lang.*;
import java.util.*;
public class Reverse_Words_in_a_String {
	 public static String reverseWords(String s) {
//	  List<String> strArr=new ArrayList<String>();
         String strArr[] =s.split(" ");
         if(strArr.length-1<0)return "";
	     String ret=strArr[strArr.length-1];

	     for(int i=strArr.length-2;i>=0;i--){
	   // 	 System.out.println(strArr[i]);
	    	 if(strArr[i].equals(""))//string之间千万别用＝＝号！
	    		continue;
	    	  ret=ret+" "+strArr[i];
	     }
		 return ret;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ret=reverseWords("I am good");
		System.out.print(ret);
	}

}
