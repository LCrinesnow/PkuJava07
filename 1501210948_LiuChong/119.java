package Pascals_Triangle_2;
import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle_2 {

	public static List<Integer> getRow(int rowIndex) {
		List<Integer>Pascal = new ArrayList<Integer>();  //可变长度的二维数组，注意new的方法  里面必须是List ？：ArrayList<List<Integer>>()
		if(rowIndex==0){
			Pascal.add(1);
			return Pascal;
		}
		long temp=1;//必须用long否则不能超出运算范围
		Pascal.add(1);
		for(int i=1;i<rowIndex/2+1;i++){
			temp=temp*(rowIndex-i+1)/i;//杨辉三角第rowIndex行的第i个数，排列组合中的组合计算，公式为何如此？。
			Pascal.add((int)temp);//强转一下
		}
		if(rowIndex%2==0&&rowIndex!=0){//对称拷贝，0的情况特殊，归结到上面的if
			int k=rowIndex/2-1;
			for(int j=rowIndex-1;j>rowIndex/2;j--){
				Pascal.add(Pascal.get(k));
				k--;
			}
			Pascal.add(1);
		}
		else{
			int k=rowIndex/2;
			for(int j=rowIndex-1;j>rowIndex/2;j--){
				
				Pascal.add(Pascal.get(k));
				k--;
			}
			Pascal.add(1);
		}
		return Pascal;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input=30;
		List<Integer> pascals_Row=new ArrayList<Integer>();
		pascals_Row=getRow(input);
//		ListIterator<List<Integer>> P_T=Pascals_Triangle.listIterator();
		
		System.out.print(pascals_Row);//输出自带方括号？是因为是二维数组吗？
	

	}

}
