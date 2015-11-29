package Excel_Sheet_Column_Number;

public class Excel_Sheet_Column_Number {

	public static int titleToNumber(String s) {
		int num=0;
		for(int i=0;i<s.length();i++){
	        char temp=s.charAt(i);
//	        System.out.println((int)temp);
	        num=(int) (num+Math.pow(26,s.length()-1-i)*((int)temp-64));  //26的s.length()-1-i次方，然后加在一起。如：ABC A是26的3-1-0次方乘以temp-64+B是26的3-1-1次方乘以temp-64+C是26的3-1-2次方乘以temp-64.
		}
		return num;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="AAC";
        System.out.println(titleToNumber(s));
        
	}

}
