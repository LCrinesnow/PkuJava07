import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args)   {
		 BufferedReader br1 =null ;
		 BufferedReader br2 =null;
		 String s1 =  "a b c d e";
		 String s2 = "a b f" ;
		try {
		//这上面就是流的封装 
			FileInputStream fis1 = new FileInputStream(new File ("d:\\c1.txt"));
			FileInputStream fis2 = new FileInputStream(new File ("d:\\c23.txt"));
			InputStreamReader ins1 = new InputStreamReader(fis1,"utf-8"); 
			  br1 = new BufferedReader(ins1);
			InputStreamReader ins2 = new InputStreamReader(fis2,"utf-8"); 
			  br2 = new BufferedReader(ins2);
		  
			StringBuffer sb1 = new StringBuffer() ;
			StringBuffer sb2 = new StringBuffer() ;
			String s  = null ;
			while((s=br1.readLine())!=null){
				sb1.append(s);
			}
			while((s=br2.readLine())!=null){
				sb2.append(s);
			}
			
			 s1 = sb1.toString () ;
			 s2 = sb2.toString() ;
		}catch (IOException e) { 
			
		}
		
		System.out.println("文件A :" );
		System.out.println(s1);
		System.out.println("文件B :" );
		System.out.println(s2);
		
		
		//上面读完文件 ，下面开始统计单词数并比较
		Set<String> set1 =  new HashSet<String> ();
		Set<String> set2 =  new HashSet<String> ();
		dealTxt (s1,set1);
		dealTxt (s2,set2);
		
		
		Set<String> bingji = new HashSet <String> ();
		Set<String> jiaoji = new HashSet <String> ();
		
		
		//求并集
		bingji.addAll(set1);
		bingji.retainAll(set2) ;
		System.out.println("题1: 并集数量 ： " + bingji.size());
		
		for (Iterator<String > iter = bingji.iterator() ; iter.hasNext();){
			System.out.print(iter.next()+" ");
		}
		System.out.println();
		
		//求交集
		jiaoji.clear();
		jiaoji.addAll(set1);
		jiaoji.addAll(set2);
		System.out.println("题2: 交集数量 ： " + jiaoji.size());
		
		for (Iterator<String > iter = jiaoji.iterator() ; iter.hasNext();){
			System.out.print(iter.next()+" ");
		}
		System.out.println();
		System.out.println();
		
		//第三问
		double AXB = (set1.size() - bingji.size())*1.0/set1.size() ;  //属于A且不属于B的单词 在A中的百分比
		double BXA = (set2.size() - bingji.size())*1.0/set2.size() ;  //属于A且不属于B的单词 在A中的百分比
		
		System.out.println("题3 :A单词数量 ： " + set1.size());
		System.out.println("    B单词数量 ： " + set2.size());
		System.out.println("    AXB = "+AXB +" ,BXA =" +BXA );
		//System.out.println(sb1);
	}
	//把文章的单词分出来，加入到set中
	public static void dealTxt  ( String s1  ,Set<String> set1) { 
		int flag = 0 ;
		char ch ;
		int head =0;
		int i = 0 ;
		for ( ; i < s1.length() ;i++) { 
			ch = s1.charAt(i) ;
			if (ch >='a' && ch<='z' ||ch >='A' && ch<='Z') { 
				if (flag ==0){ //表示匹配到一个新单词的开始 
					head = i ;
					flag =1 ;
				}
				
			}else if (ch == '\n') { 
				continue ;
			}else { 
				if (flag ==1) { //表示有单词 结束
					String sub = s1.substring(head, i) ;
					sub = sub.toLowerCase(); //换成小写
					set1.add(sub) ;
					flag =0 ;
				}
			}
		}
		if (flag !=0){ 
			String sub = s1.substring(head, i) ;
			sub = sub.toLowerCase(); //换成小写
			set1.add(sub) ;
			flag =0 ;
		}
	}
}
