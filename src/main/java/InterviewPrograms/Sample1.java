package InterviewPrograms;

public class Sample1 {

	public static void main(String[] args) {

		String s = "java is a programing language";
		String rev = " ";
		String str[] = s.split(" ");
		for (int j = str.length - 1; j >= 0; j--) {
			rev = rev + str[j] + " ";
		}
		System.out.println(rev);
	}

}
