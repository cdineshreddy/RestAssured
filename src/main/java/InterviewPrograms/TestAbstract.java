package InterviewPrograms;

public  class TestAbstract extends Animal {

	public static void main(String[] args) {

		TestAbstract test = new TestAbstract();
		Animal a = test;
		test.lion();
		a.parrot();
		

	}
	@Override
	public void lion() {
		System.out.println("Lion is an Wild Animal");
	}
}

abstract class Animal {

	public abstract void lion();

	public void parrot() {
		System.out.println("Parrot is an pet Animal");
	}

}
