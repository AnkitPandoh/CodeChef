package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinFlip
{
	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0)
		{
			int g = Integer.parseInt(br.readLine());
			while (g-- > 0)
			{
				String[] input = br.readLine().split(" ");
				int iState = Integer.parseInt(input[0]);
				int n = Integer.parseInt(input[1]);
				int q = Integer.parseInt(input[2]);
				if (n % 2 == 0)
					System.out.println(n / 2);
				else
				{
					if (q == iState)
						System.out.println(n / 2);
					else
						System.out.println(n / 2 + 1);
				}
			}
		}
	}
}
