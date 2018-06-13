package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimePalindromes
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean check = false;
		int i;
		for (i = n; !check; i++)
			check = (isPalindrome(i) && isPrime(i));
		System.out.println(--i);
	}

	static boolean isPrime(int n)
	{
		if (n == 2)
			return true;
		for (int i = 2; i <= Math.sqrt(n); i++)
		{
			if (n % i == 0)
				return false;
		}
		return true;
	}

	static boolean isPalindrome(Integer num)
	{
		int org = num;
		int rev = 0;
		while (num != 0)
		{
			int d = num / 10;
			int r = num % 10;
			rev = rev * 10 + r;
			num = d;
		}
		if (org == rev)
			return true;
		else
			return false;
	}
}
