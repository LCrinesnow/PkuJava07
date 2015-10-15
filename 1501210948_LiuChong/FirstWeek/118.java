package Pascals_Triangle;
import java.util.*;
public class Pascals_Triangle {
	
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>>Pascals =new ArrayList<List<Integer>>();  //可变长度的二维数组，注意new的方法  里面必须是List ？：ArrayList<List<Integer>>()
//		List<Integer> Pascal=new ArrayList<Integer>();//多加一句就重命名了瞎
		for(int i=0;i<numRows;i++){
//			int j=numRows;
			List<Integer> Pascal=new ArrayList<Integer>();//这样效率能高吗？
			if(i==0){
				Pascal.add(1);
				Pascals.add(Pascal);
			}
			else if(i==1){
				Pascal.add(1);
				Pascal.add(1);
				Pascals.add(Pascal);
			}
			else if(i>1){
				Pascal.add(1);
				for(int j=0;j<=i-2;j++){
					int temp=Pascals.get(i-1).get(j)+Pascals.get(i-1).get(j+1);
					Pascal.add(temp);
				}
				Pascal.add(1);
				Pascals.add(Pascal);

			}
				
			
//			Pascals.add(Pascal);
			
		}
		return Pascals;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input=6;
		List<List<Integer>> Pascals_Triangle=new ArrayList<List<Integer>>();
		Pascals_Triangle=generate(input);
//		ListIterator<List<Integer>> P_T=Pascals_Triangle.listIterator();
		
		System.out.print(Pascals_Triangle.get(0));//输出自带方括号？是因为是二维数组吗？
		System.out.print(Pascals_Triangle.get(1));//输出自带方括号？是因为是二维数组吗？

//		System.out.print(Pascals_Triangle.get(1).get(0));//输出自带方括号？是因为是二维数组吗？
		System.out.print(Pascals_Triangle.get(2));//输出自带方括号？是因为是二维数组吗？
		System.out.print(Pascals_Triangle.get(3));//输出自带方括号？是因为是二维数组吗？
		System.out.print(Pascals_Triangle.get(4));//输出自带方括号？是因为是二维数组吗？
		System.out.print(Pascals_Triangle.get(5));//输出自带方括号？是因为是二维数组吗？

	}

}
