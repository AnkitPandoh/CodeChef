package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LuckyLuckyNumber
{
	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0)
		{
			long n = Integer.parseInt(br.readLine());
			boolean ind = false;
			if (n % 7 == 0)
			{
				System.out.println(n);
				ind = true;
			} else
			{
				int i = 1;
				long j = n;
				while (j >= 7)
				{
					j = n - 4 * i;
					if (j % 7 == 0)
					{
						System.out.println(j);
						ind = true;
						break;
					}
					i++;
				}
			}
			if (!ind)
			{
				if (n % 4 == 0)
					System.out.println(0);
				else
					System.out.println(-1);
			}
		}
	}
}
