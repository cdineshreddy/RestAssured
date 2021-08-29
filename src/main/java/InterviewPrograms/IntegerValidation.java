package InterviewPrograms;

import java.util.Arrays;

public class IntegerValidation {

	public static void main(String[] args) {

		boolean status;

		int input = 65438;
		int output = 83457;
		String number1 = String.valueOf(output);
		String number = String.valueOf(input);
		if (number.length() != number1.length()) {
			status = false;
		} else {

			char[] s1array = number.toCharArray();
			char[] s2array = number1.toCharArray();

			Arrays.sort(s1array);
			Arrays.sort(s2array);

			status = Arrays.equals(s1array, s1array);
		}

		if (status) {
			System.out.println(input + " and " + output + " are equal");
		} else {
			System.out.println(input + " and " + output + " are not equal");
		}

	}
}
