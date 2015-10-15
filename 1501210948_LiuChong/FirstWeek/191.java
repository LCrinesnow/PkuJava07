package Number_of_1_Bits;
import java.math.*;
public class Number_of_1_Bits {

	public static int hammingWeight(int n) {
        int count=0;
        long num=n;
//        BigInteger Bignum=BigInteger.valueOf(num);//能用吗？
//        byte [] Bigarray=Bignum.toByteArray();
//        for(int i=0;i<Bigarray.length;i++){
//        	if(Bigarray[i]==1){
//        		count++;
//        	}
//        	System.out.print(Bigarray[i]);
//        }
        String BinStr=Integer.toBinaryString(n);
        char[] BinChar=BinStr.toCharArray();
        for(int i=0;i<BinChar.length;i++){
        	if(BinChar[i]=='1')
        	count++;
        }
        
		return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(hammingWeight(11));
	
	}

}
