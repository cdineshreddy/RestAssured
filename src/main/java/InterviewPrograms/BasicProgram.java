package InterviewPrograms;


public class BasicProgram extends test.test1 {

	public static void main(String[] args) {

		test t = new test();
		t.add();
		sub();
	}
}

class test {

	public void add() {
		int a = 10, b = 20;
		int c = a + b;
		System.out.println(c);
	}

	static class test1 {

		public static void sub() {
			int a = 10, b = 20;
			int c = a - b;
			System.out.println(c);
		}
	}
}
