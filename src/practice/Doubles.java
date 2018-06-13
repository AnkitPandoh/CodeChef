package practice;
import java.util.Scanner;

public class Doubles
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while(t>0)
		{
			long n = input.nextInt();
			if(n%2==0)
				System.out.println(n);
			else
				System.out.println(n-1);
			t--;
		}
	}
}
