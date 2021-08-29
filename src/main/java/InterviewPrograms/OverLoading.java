package InterviewPrograms;

public class OverLoading {
	
	OverLoading(int a, int b)
	{
	System.out.println("a = "+a+" b = "+b);
	}
	OverLoading(int a, float b)
	{
	System.out.println("a = "+a+" b = "+b);
	}
	public static void main (String args[])
	{
	byte a = 10;
	byte b = 15;
	OverLoading test = new OverLoading(a,b);
	}

}
