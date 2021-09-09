package InterviewPrograms;

public class Sample {

	public static void main(String[] args) {

		int a[] = { 100, 14, 46, 47, 94, 94, 52, 86, 36, 94, 89 };
		int temp;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if ((a[i] < a[j]) && (i != j)) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		// for(int k=0;k<a.length;k++)
		System.out.println(a[1]);

	}

}
