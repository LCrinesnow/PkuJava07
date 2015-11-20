//Word_Count
//1、求两文件单词的并集。
//2、求两文件单词的交集。
//3、假设单词wd，文件A，文件B,求A，B文件中各自单词总数。wd∈A 且wd ∉B的单词占A文件的百分比  和   wd∈B且 wd∉A的单词占B文件的百分比。
package Word_Count;
import java.io.*;
import java.util.*;
public class Word_Count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileNameA="/Users/rinesnow/Documents/EclipseWorkSpace/Word_Count/src/Word_Count/DataA.txt";
		String fileNameB="/Users/rinesnow/Documents/EclipseWorkSpace/Word_Count/src/Word_Count/DataB.txt";
		HashSet<String> hashA=new HashSet<String>();
		HashSet<String> hashB=new HashSet<String>();
		HashSet<String> hashUnion=new HashSet<String>();
		HashSet<String> hashIntersect=new HashSet<String>();
		int numA=0,numB=0;
		int Arep=0,Brep=0;
		try{
			ReadFile fileA=new ReadFile(fileNameA);
			String[] fileALines=fileA.OpenFile();
			for(int i=0;i<fileALines.length;i++){
				String[] wordbuffer=fileALines[i].split(" ");
				for(int j=0;j<wordbuffer.length;j++){
					numA++;
					if(!hashA.add(wordbuffer[j])){//若不成功添加，说明A自身重复
						
					}
				}
//				System.out.println(fileALines[i]);
				
			}
			
			ReadFile fileB=new ReadFile(fileNameB);
			String[] fileBLines=fileB.OpenFile();
			for(int i=0;i<fileBLines.length;i++){
				String[] wordbuffer=fileBLines[i].split(" ");
				for(int j=0;j<wordbuffer.length;j++){
					numB++;
					if(!hashB.add(wordbuffer[j])){//若不成功添加，说明B自身重复
						
					}
				}
//				System.out.println(fileBLines[i]);
			}
//			Object[] hashAArray=hashA.toArray();
//			Object[] hashBArray=hashB.toArray();
			HashSet<String> tempB=new HashSet<String>();
			tempB=hashB;
			for(String s:hashA){
				if(!tempB.add(s)){//若不成功添加，说明A与B重复
					hashIntersect.add(s);//其实这里用链表也可以
				}
			}
			
			
			System.out.println("文件A单词个数："+numA);
			System.out.println("文件B单词个数："+numB);
			//并集
			hashUnion=hashB;
			hashUnion.addAll(hashA);
			System.out.print("并集为：");
			for(String s:hashUnion){
				System.out.print(" "+s);
			}
			System.out.println();
			int numInter=0;
			System.out.print("交集为：");
			for(String s:hashIntersect){
				System.out.print(" "+s);
				numInter++;
			}
			System.out.println();
			System.out.println("wd∈A 且wd ∉B的单词占A文件的百分比："+(float)(numA-numInter)/numA);
			System.out.println("wd∈B且 wd∉A的单词占B文件的百分比："+(float)(numB-numInter)/numB);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

}
