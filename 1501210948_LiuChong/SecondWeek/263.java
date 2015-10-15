package Ugly_Number;

public class Ugly_Number {
//	必须只有2，3，5这三个素数
	 public static boolean isUgly(int num) {
		   if(num<=0) return false;
		   //先对二一遍一遍除
		   while(num%2==0){
			   num=num/2;
		   }
		   //剩余数对3一遍一遍除
		   while(num%3==0){
			   num=num/3;
		   }
		   //剩余数对5一遍一遍除
		   while(num%5==0){
			   num=num/5;
		   }
		   //就剩一了的话就是，不剩1就不是了
		   if(num==1)
			   return true;
		   else return false;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input=30;
		System.out.println(isUgly(input));
	}

}
