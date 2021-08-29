package InterviewPrograms;

public class SplitProgram {

	public static void main(String[] args) {
		
		String str = "Hello how are you doing. What are you doing. Call me";
		String[] str1 = str.split("[.]");
		for(int i=0;i<str1.length;i++) {
			System.out.println(str1[i].trim());
		}

	}

}
