package Happy_Number;
import java.util.*;
import java.math.*;
public class Happy_Number {
//Runtime 100ms的第一次算法
//    public static boolean isHappy(int n) {
//        boolean flag=false;
//        int num[]=int2list(n);
//        System.out.print(num[0]);
//        System.out.print(num[1]);
////        System.out.print(num[2]);
////        System.out.print(num[3]);
//        double sum=0;
//        Set<Integer> ifIn=new HashSet();
//        for(int i=0;i<num.length;i++){
//        	sum=sum+Math.pow(num[i], 2);
//    	}
//        ifIn.add((int) sum);
//        while(true){
//        	if(sum==1){
//        		flag=true;
//        		break;
//        	}
//        	int temp[]=int2list((int)sum);
//        	sum=0;
//        	for(int i=0;i<temp.length;i++){
//            	sum=sum+Math.pow(temp[i], 2);
//        	}
//        	System.out.println(sum);
//        	if(ifIn.add((int)sum)==false){
//        		flag=false;
//        		break;
//        	}
////        	num=int2list((int)sum);
//        }
//    	return flag;
//    
//    }
//    
//    public static int[] int2list(int n) {
//    	List<Integer> numlist=new ArrayList<Integer>();
//        int i=0;
//        int temp=n;
//        while(true){
//        	if(temp==0) break;
//        	numlist.add(temp%10);//先模并存余  203 余3    20余0   2余2
//        	temp=temp/10;//再除十再存结果   203 商20   20商2   2商0 break
//        	i++;//记位数
//        }
//        int count=i;
//        //逆存
//        int[] num=new int[i];
//        int j=0;
//        while(i>0){
//        	num[j]=numlist.get(i-1);
////            System.out.print(num[j]);
//        	j++;
//        	i--;
//        }
//    	return num;
//    }
	
	
// Runtime 仅5ms的算法   大体想法一样，其实不必排序    //注意：什么时候要存数组，是否必要一定要存？如果最终目标不是排序时，可以用hashset或者在loop里面进行运算。而非一定要存储好了，再操作
//    public class Solution {
//    	  public static boolean isHappy(int n) {
//    	    Set<Integer> inLoop = new HashSet<Integer>();
//    	    int squareSum,remain;
//    	    while (inLoop.add(n)) {
//    	        squareSum = 0;
//    	        while (n > 0) {
//    	            remain = n%10;
//    	            squareSum += remain*remain;
//    	            n /= 10;
//    	        }
//    	        if (squareSum == 1)
//    	            return true;
//    	        else
//    	            n = squareSum;
//    	    }
//    	    return false;
//    	  }
//    	    
//    }
//Runtime 51ms 改进后的    
	public static boolean isHappy(int n) {
        boolean flag=false;
        Set<Integer> ifIn=new HashSet();
        int sum=Calcu(n);
        ifIn.add((int) sum);
        while(true){
        	if(sum==1){
        		flag=true;
        		break;
        	}
        	
        	sum=Calcu(sum);
        	if(ifIn.add((int)sum)==false){
        		flag=false;
        		break;
        	}
//        	num=int2list((int)sum);
        }
    	return flag;
    
    }
    
    public static int Calcu(int n) {
    	 List<Integer> numlist=new ArrayList<Integer>();
        int i=0;
        int temp=n;
        int sum=0;
        while(true){
        	if(temp==0) break;
        	numlist.add(temp%10);//先模并存余  203 余3    20余0   2余2
        	temp=temp/10;//再除十再存结果   203 商20   20商2   2商0 break
        	sum=sum+numlist.get(i)*numlist.get(i);
        	i++;//记位数
        }
//		System.out.print(sum);

        return sum;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input=19;
//		System.out.print(i);
		
//        System.out.print(num);
		
		if(isHappy(input))System.out.println("happy");
		else System.out.println("not happy");
	}

}
