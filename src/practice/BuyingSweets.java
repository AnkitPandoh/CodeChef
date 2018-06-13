package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BuyingSweets
{
	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0)
		{
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int x = Integer.parseInt(input[1]);
			input = br.readLine().split(" ");
			int[] notes = new int[n];
			int k = 0, sum = 0;
			for (int i = 0; i < n; i++)
			{
				notes[k++] = Integer.parseInt(input[i]);
				sum += notes[i];
			}
			if (sum < x)
				System.out.println(-1);
			else if (sum % x == 0)
				System.out.println(sum / x);
			else
			{
				int q = sum / x;
				int max = x * q;
				Arrays.sort(notes);
				int tempSum = 0;
				boolean ind = false;
				for (int i = notes.length - 1; i >= 0; i--)
				{
					tempSum += notes[i];
					if (tempSum >= max && i > 0)
					{
						System.out.println(-1);
						ind = true;
						break;
					}
				}
				if (!ind)
					System.out.println(q);
			}
		}
	}
}
