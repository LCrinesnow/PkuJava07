package filehandle;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class Readfile {
	
	    
	
	public static List<String> readbyline(String add)
	{
		
		String data = null;
		List<String> res = new ArrayList<String>();
		try
		{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(add)));
		System.out.println("文件内容为：");
		while((data = br.readLine())!=null)
		{
		   //System.out.println(data);
		   //res.add(data);
			String[] word = data.split("\\s");
			for(int k = 0;k < word.length;k++)
			{
				if(!word[k].equals(""))
				   res.add(word[k]);            
				//System.out.println("*********"+res);
				//System.out.println("*********"+word[k]);
			}
			
			System.out.println(data);
		}
		}catch(FileNotFoundException e) {
	    // TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return res;
	}
	//获取词汇表
	public static void judge(List<String> data1,List<String> data2)
	{
		
		
		//data1=readbyline("C://Users//Administrator//Desktop//1.txt");
		//data2=readbyline("C://Users//Administrator//Desktop//2.txt");
		/*
		HashSet<String> list1 = new HashSet<String>();
		HashSet<String> list2 = new HashSet<String>();
		HashSet<String> list3 = new HashSet<String>();
		HashSet<String> list4 = new HashSet<String>();
		//HashSet<String> list5 = new HashSet<String>();//放所有单词进去
		//将文件一的所有单词放到list里面
				for(int i = 0;i< data1.size();i++)
				{
					list1.add(data1.get(i));
					list3.add(data1.get(i));
					//list5.add(data1.get(i));
					//list2.add(data1.get(i));
				}
				for(int i = 0;i< data2.size();i++)
				{
					//list4存放文件二的单词
					list4.add(data2.get(i));
					//list5.add(data2.get(i));
				}
				//判断字符
				for(int i = 0;i < data2.size();i++)
				{
					if(list1.contains(data2.get(i)))
					{
						list2.add(data2.get(i));
						list1.remove(data2.get(i));
					}
					else
					{
						list1.add(data2.get(i));
						//list2.remove(data2.get(i));
					}
				}
				System.out.println("两个文件的词汇表为："+list1);
				System.out.println("单词个数为："+list1.size());
				System.out.println("两个文件中的交集单词词汇表为："+list2);
				System.out.println("单词个数为："+list2.size());
			//problem3
			 * 
			 */
		HashSet<String> list1 = new HashSet<String>();
		HashSet<String> list2 = new HashSet<String>();
		HashSet<String> res = new HashSet<String>();
		//HashSet<String> res1 = new HashSet<String>();
		float margin = 0;
		//把文件一的单词放进list1,把文件二的单词放进list2，然后做集合运算
		for(int i = 0;i< data1.size();i++)
		{
			list1.add(data1.get(i));
			
		}
		for(int i = 0;i< data2.size();i++)
		{
			list2.add(data2.get(i));
			
		} 
		//求文件词汇表
		res.clear();
		res.addAll(list1);
        res.addAll(list2);
        System.out.println("两个文件的词汇表为："+res);
		//求交集词汇表
        res.clear();
		res.addAll(list1);
        res.retainAll(list2);
        System.out.println("两个文件中的交集单词词汇表为："+res);
        //包含在A，但是不包含在B中的单词
        res.clear();
        res.addAll(list1);
        res.removeAll(list2);
        //System.out.println("************"+res.size());
        //System.out.println("************"+list1.size());
        margin = (float)res.size()/(float)list1.size();
        System.out.println("A-B(即属于A但不属于B的单词)："+res);
        System.out.println("所占百分比为："+margin);
        
       //包含在B，但是不包含在A中的单词
        res.clear();
        res.addAll(list2);
        res.removeAll(list1);
        margin = (float)res.size()/(float)list2.size();
        System.out.println("B-A(即属于B但不属于A的单词)："+res);
        System.out.println("所占百分比为："+margin);

	}
	public static void main(String args[])
	{
		
		List<String> data1 = new ArrayList<String>();
		List<String> data2 = new ArrayList<String>();
		data1=readbyline("C://Users//Administrator//Desktop//1.txt");
		data2=readbyline("C://Users//Administrator//Desktop//2.txt");
		judge(data1,data2);
		//HashSet<String> res = new HashSet<String>();
		//Readfile f1=new Readfile();
		//Readfile f2=new Readfile();
		//data1=readbyline("C://Users//Administrator//Desktop//1.txt");
		//data2=readbyline("C://Users//Administrator//Desktop//2.txt");
		/*System.out.println("文件一为：");
		for(int i=0;i<data1.size();i++)
		{
		   
		   System.out.println(data1.get(i));
		}
		System.out.println("文件二为：");
		for(int j=0;j<data2.size();j++)
		{
		   
		   System.out.println(data2.get(j));
		}
		*/
		
		//for(int i=0;i<data1.size();i++)
		//{
			//for(int j=0;j<data2.size();j++)
			//{
			  
			//}
		//}
		//if(data1.equals(data2) == false)
		//{
			//System.out.print("两个文件总共的词汇表为："+data1+" "+data2);
		//}
		//else
		//{
		  /*
			for(i=0;i<Math.max(data1.length(), data2.length());i++)
			{
				if(data1.charAt(i) != data2.charAt(i))
				{
					System.out.println("两个文件总共的词汇表为：");
					System.out.println(data1.charAt(i)+" "+data2.charAt(i));
				}
				else
					i++;
			}*/
		}
	}

