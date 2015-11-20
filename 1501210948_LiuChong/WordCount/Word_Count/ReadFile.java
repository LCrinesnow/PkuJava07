package Word_Count;
import java.io.*;

public class ReadFile {
	public String path;
	public ReadFile(String file_path){
		path=file_path;	
	}
	int readLines() throws IOException{
		FileReader fileToRead=new FileReader(path);
		BufferedReader bf=new BufferedReader(fileToRead);
		String aline;
		int numberOfLines=0;
		while((aline=bf.readLine())!=null){
			numberOfLines++;
		}
		bf.close();
		return numberOfLines;
	}
		
	public String[] OpenFile()throws IOException{
		FileReader fr=new FileReader(path);
		BufferedReader textReader=new BufferedReader(fr);
		int numberOfLines=readLines();
		String[] textData=new String[numberOfLines];
		for(int i=0;i<numberOfLines;i++){
			textData[i]=textReader.readLine();
			
		}
		textReader.close();
		return textData;
		
	}
}
