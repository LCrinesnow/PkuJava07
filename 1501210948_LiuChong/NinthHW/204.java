package count_Primes;

import java.util.ArrayList;

public class Count_Primes {

	public static int countPrimes(int n) {
		if(n<=1) return 0;
		
		boolean[] list=new boolean[n];
		list[0]=false;//因为non－negetive 所以第0位置0作废
		for(int i=1;i<n;i++){
			list[i]=true;
		}
//		list从第0位是0，第一位是1到第末位是n
//		设n为合数，n=ab,则a,b之中总有一个小于或等于根号n.
//        也就是说合数有大于根号n的因数存在，则必有一个小于根号n的因数与之对应。
//        再换个说法，如果一个数没有小于根号n的因数，则不能有大于根号n的因数。
//        所以只检查是否有小于或等于根号n的因数即可。
		for(int i=2;i*i<n;i++){ //从有效位i＝2开始  list［2］＝2  因为素数，所以跳过1（1不是素数）
			if(list[i]!=false){//如果没被删掉
				for(int j=i;j*i<n;j++){//i=2,j=2,3,4,5... j*i就是2的倍数，将其删掉
						list[j*i]=false;
					
				}
			}
		}
		int count=0;

		for(int i=2;i<n;i++){
			if(list[i]==true) count++;
			System.out.print(i);

			System.out.println(list[i]);

		}
		return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println((3)%2);
		System.out.println(countPrimes(10));
	}

}
