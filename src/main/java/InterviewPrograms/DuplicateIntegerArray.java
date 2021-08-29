package InterviewPrograms;

public class DuplicateIntegerArray {

	public static void main(String[] args) {

		int a[] = { 5, 6, 7, 8, 5, 6 };
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if ((a[i] == a[j]) && (i != j)) {
					System.out.println(a[i]);
				}
			}
		}
	}

}
