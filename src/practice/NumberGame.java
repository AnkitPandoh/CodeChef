package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberGame
{
	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0)
		{
			long n = Integer.parseInt(br.readLine());
			if(n % 4 == 1)
				System.out.println("ALICE");
			else
				System.out.println("BOB");
		}
	}

}
