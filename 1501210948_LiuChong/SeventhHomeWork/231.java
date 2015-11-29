package Power_of_Two;

public class Power_of_Two {

	public static boolean isPowerOfTwo(int n) {
		int count=0;
		if(n==1) return true;
		if(n==0) return false;
		else{
		  while(n!=1){//最后会到一个阶段3/2=1余1，所以等n＝1时,不用再循环了，因为n＝1之前的那次循环已经n%2==0了且商1，证明就是2。 
	    		System.out.println(n/2);

	       	if(n%2==0&&n!=1){
	       		
	           	n=n/2;
	       	}
	       	else{
	    		System.out.println("count:"+count);

	       		count++;
	       		break;
	       	}
		  }
		  if(count==0) return true;
		  else return false;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=2;
		System.out.println(isPowerOfTwo(n));
	}

}
