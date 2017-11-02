package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileReader {

	public static String readFile(String filename) throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr); 
			String s;
			while((s = br.readLine()) != null) { 
				sb.append(s+"\n"); 
			} 
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if (fr != null) {
				fr.close();
			}
			if (br != null) {
				br.close();	
			}
		}
		return sb.toString();
	}

	public static int fileLength(String filename) throws IOException{
		int length = 0;
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		while (br.readLine() != null) {
			++length;			
		}
		br.close();
		
		return length;
	}
	
	
}
