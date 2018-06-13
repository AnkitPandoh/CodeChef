package practice;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HolesInText
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		Map<Character, Integer> holes = new HashMap<Character, Integer>();
		holes.put('A', 1);
		holes.put('B', 2);
		holes.put('D', 1);
		holes.put('O', 1);
		holes.put('P', 1);
		holes.put('Q', 1);
		holes.put('R', 1);
		while (testCase > 0)
		{
			String text = input.next();
			char[] test = new char[text.length()];
			test = text.toCharArray();
			int sum = 0;
			for (int i = 0; i < test.length; i++)
			{
				if (holes.containsKey(test[i]))
					sum += holes.get(test[i]);
			}
			System.out.println(sum);
			testCase--;
		}
	}
}
