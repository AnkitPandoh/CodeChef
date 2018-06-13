package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stamps
{
	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		long sum = 0, stampSum = 0;
		boolean check = false;
		for (int i = 0; i < n; i++)
		{
			sum += i + 1;
			stampSum += Integer.parseInt(input[i]);
			if (sum > stampSum)
			{
				check = true;
				break;
			}
		}
		if (!check && sum == stampSum)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
