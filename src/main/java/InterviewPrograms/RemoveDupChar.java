package InterviewPrograms;

public class RemoveDupChar {

	public static void main(String[] args) {

		String s = "nextgen";
		for (char c : s.toCharArray()) {
			int firstIndex = s.indexOf(c);
			int lastIndex = s.lastIndexOf(c);
			if (firstIndex == lastIndex)
				System.out.println(c);
		}

	}

}
