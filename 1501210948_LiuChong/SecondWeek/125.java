package Valid_Palindrome;

import java.util.*;

public class Valid_Palindrome {

	    public static boolean isPalindrome(String s) {
	    	
////	    	Stack <Character> testifP=new Stack<Character>();
			
			char [] input2char=s.toCharArray();
			List<Character> cleanchar=new ArrayList<Character>();
			//除去大小写和非char字符
			for(int i=0;i<input2char.length;i++){
				//大写字母A－Z 65-90，小写字母 97-122 
				if((input2char[i]>=48&&input2char[i]<=58)||(input2char[i]>=65&&input2char[i]<=90)||(input2char[i]>=97&&input2char[i]<=122)){
					if(input2char[i]>=65&&input2char[i]<=90){//大写
////						testifP.push((char)(input2char[i]+32));//转小写
						cleanchar.add((char)(input2char[i]+32));
					}
					else
						cleanchar.add(input2char[i]);
////						testifP.push(input2char[i]);
				}	
			}
			for(int i=0;i<cleanchar.size();i++){
				System.out.println(cleanchar.get(i));
			}
			if(cleanchar.size()==1) return false;
//            else if(cleanchar.size()==0) return true;

			int j=cleanchar.size()-1;
			int count=0;
			for(int i=0;i<=cleanchar.size()/2-1;i++){
				if(cleanchar.get(i)==cleanchar.get(j)) count++;
				j--;
				System.out.print(cleanchar.get(i));
				System.out.print(count);

			}
			if(count==cleanchar.size()/2) return true;
			else return false;
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		for(int i=0;i<cleanchar.size();i++){//测试输出
//			System.out.print(cleanchar.get(i));
//		}
		
////		if(input2char.length%2==0){
////			for(int i=input2char.length/2;i<input2char.length;i++){
////				//大写字母A－Z 65-90，小写字母 97-122
////				if(){
////					testifP.peek();
////					testifP.pop();
////				}	
////			}
////		}
////		System.out.println(testifP.size());
		
////		while(!testifP.empty()){
////			System.out.println(testifP.peek());
////			testifP.pop();
////		}
		String input="000";

		boolean IF= isPalindrome(input);
		

		System.out.println(IF);
		
		
		


	}

}
