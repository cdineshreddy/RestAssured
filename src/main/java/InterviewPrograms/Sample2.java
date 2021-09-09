package InterviewPrograms;

public class Sample2 {

	public static void main(String[] args) {

		int a[] = { 1, 2, 5, 3 };
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		int b = 1;
		for (int k = 0; k < a.length; k++) {
			if (b != a[k])
				System.out.println(b);
			b++;
		}

	}

}
