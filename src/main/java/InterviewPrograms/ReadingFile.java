package InterviewPrograms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadingFile {
	
	public static void readFile(String path) throws IOException{
		
		File file = new File(path);
		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		
		String st;
		while((st=br.readLine())!=null)
		System.out.println(st);
		br.close();
	}
	
	public static void readFileThruScanner(String path) throws IOException{
		File file = new File(path);
		Scanner sc = new Scanner(file);
		
		while(sc.hasNextLine())
			System.out.println(sc.nextLine());
		sc.close();
	}

	public static void main(String[] args) throws IOException {
		
		readFile("C:\\Users\\dineshreddyc\\Documents\\TestData.txt");	
		readFileThruScanner("C:\\Users\\dineshreddyc\\Documents\\TestData.txt");
	}

}
