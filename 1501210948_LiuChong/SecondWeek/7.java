package Reverse_Integer;

import java.util.*;

public class Reverse_Integer {

    public static int reverse(int x) {
	    long ret=0; 
//	    List<Integer> rev =new ArrayList<Integer>();
	    int i=0;
	    int temp=x;
//	    boolean flag=false;//一开始默认是整数
//	    if(temp<0){
//	    	temp=Math.abs(temp);
//	    	flag=true;
//	    }
//	    while(temp!=0){
//	    	rev.add(temp%10);
//	    	temp=temp/10;
//	    	i++;
//	    }
	    while(temp!=0){
	    	ret=ret*10+temp%10;
	    	temp=temp/10;
	    	i++;
	    }
//	    long ret=0;
//	    int j=0;
//	    int num=rev.size();
//	    
//	    //逆序数组整合成数
//	    while(j<rev.size()){
//	    	if(j==rev.size()-1){
//	    		ret=ret+rev.get(j);
//	    	}
//	    	else{//Math.pow 一旦溢出了不报错，输出错误信息，不能用于边界处理
//		    	ret=(long) (ret+(int)Math.pow(10,num-1)*(int)rev.get(j));
//	    	}
//	    	j++;
//	    	num--;
//	    }
//	    if(flag==true){
//	    	ret=ret*(-1);
//	    }
	    
	    if(ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE)
    		return 0;

	    
    	return (int)ret;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(1534236465));
	}

}
