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
		System.out.println("�ļ�����Ϊ��");
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
	//��ȡ�ʻ��
	public static void judge(List<String> data1,List<String> data2)
	{
		
		
		//data1=readbyline("C://Users//Administrator//Desktop//1.txt");
		//data2=readbyline("C://Users//Administrator//Desktop//2.txt");
		/*
		HashSet<String> list1 = new HashSet<String>();
		HashSet<String> list2 = new HashSet<String>();
		HashSet<String> list3 = new HashSet<String>();
		HashSet<String> list4 = new HashSet<String>();
		//HashSet<String> list5 = new HashSet<String>();//�����е��ʽ�ȥ
		//���ļ�һ�����е��ʷŵ�list����
				for(int i = 0;i< data1.size();i++)
				{
					list1.add(data1.get(i));
					list3.add(data1.get(i));
					//list5.add(data1.get(i));
					//list2.add(data1.get(i));
				}
				for(int i = 0;i< data2.size();i++)
				{
					//list4����ļ����ĵ���
					list4.add(data2.get(i));
					//list5.add(data2.get(i));
				}
				//�ж��ַ�
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
				System.out.println("�����ļ��Ĵʻ��Ϊ��"+list1);
				System.out.println("���ʸ���Ϊ��"+list1.size());
				System.out.println("�����ļ��еĽ������ʴʻ��Ϊ��"+list2);
				System.out.println("���ʸ���Ϊ��"+list2.size());
			//problem3
			 * 
			 */
		HashSet<String> list1 = new HashSet<String>();
		HashSet<String> list2 = new HashSet<String>();
		HashSet<String> res = new HashSet<String>();
		//HashSet<String> res1 = new HashSet<String>();
		float margin = 0;
		//���ļ�һ�ĵ��ʷŽ�list1,���ļ����ĵ��ʷŽ�list2��Ȼ������������
		for(int i = 0;i< data1.size();i++)
		{
			list1.add(data1.get(i));
			
		}
		for(int i = 0;i< data2.size();i++)
		{
			list2.add(data2.get(i));
			
		} 
		//���ļ��ʻ��
		res.clear();
		res.addAll(list1);
        res.addAll(list2);
        System.out.println("�����ļ��Ĵʻ��Ϊ��"+res);
		//�󽻼��ʻ��
        res.clear();
		res.addAll(list1);
        res.retainAll(list2);
        System.out.println("�����ļ��еĽ������ʴʻ��Ϊ��"+res);
        //������A�����ǲ�������B�еĵ���
        res.clear();
        res.addAll(list1);
        res.removeAll(list2);
        //System.out.println("************"+res.size());
        //System.out.println("************"+list1.size());
        margin = (float)res.size()/(float)list1.size();
        System.out.println("A-B(������A��������B�ĵ���)��"+res);
        System.out.println("��ռ�ٷֱ�Ϊ��"+margin);
        
       //������B�����ǲ�������A�еĵ���
        res.clear();
        res.addAll(list2);
        res.removeAll(list1);
        margin = (float)res.size()/(float)list2.size();
        System.out.println("B-A(������B��������A�ĵ���)��"+res);
        System.out.println("��ռ�ٷֱ�Ϊ��"+margin);

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
		/*System.out.println("�ļ�һΪ��");
		for(int i=0;i<data1.size();i++)
		{
		   
		   System.out.println(data1.get(i));
		}
		System.out.println("�ļ���Ϊ��");
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
			//System.out.print("�����ļ��ܹ��Ĵʻ��Ϊ��"+data1+" "+data2);
		//}
		//else
		//{
		  /*
			for(i=0;i<Math.max(data1.length(), data2.length());i++)
			{
				if(data1.charAt(i) != data2.charAt(i))
				{
					System.out.println("�����ļ��ܹ��Ĵʻ��Ϊ��");
					System.out.println(data1.charAt(i)+" "+data2.charAt(i));
				}
				else
					i++;
			}*/
		}
	}

