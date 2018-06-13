package practice;
import java.util.Scanner;

public class ATM
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		float x = input.nextFloat();
		float tot = (float) (x + 0.50);
		float y = input.nextFloat();
		if (x % 5 == 0 && tot <= y)
			System.out.printf("%.2f", y - tot);
		else
			System.out.printf("%.2f", y);
		System.out.println();
	}
}
