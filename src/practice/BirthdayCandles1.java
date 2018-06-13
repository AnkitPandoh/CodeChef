package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BirthdayCandles1
{
	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0)
		{
			String[] input = br.readLine().split(" ");
			int[] candles = new int[input.length];
			int k = 0;
			for (int i = 0; i < input.length; i++)
				candles[k++] = Integer.parseInt(input[i]);
			int pos = 1;
			int min = candles[1];
			int count = 0, sum = 0;
			for (int i = 1; i < candles.length; i++)
			{
				if (candles[i] == 0)
				{
					pos = i;
					count = 1;
					break;
				}
				if (candles[i] < min)
				{
					min = candles[i];
					pos = i;
				}
			}
			if (count == 1)
				System.out.println(pos);
			else
			{
				int d, j = 0;
				d = candles[pos];
				d += 1;
				while (d-- > 0)
					sum += pos * Math.pow(10, j++);
				d = candles[0];
				d += 1;
				int sum1 = (int) Math.pow(10, d);
				if (sum > sum1)
					System.out.println(sum1);
				else
				{
					System.out.println(sum);
				}
			}
		}
	}
}
