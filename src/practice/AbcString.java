package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AbcString
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char[] str = input.toCharArray();
		long count = 0;
		int k = 3, p = 1;
		while (k * p <= str.length)
		{
			int z = k * p;
			for (int i = 0; i <= str.length - z; i++)
			{
				long countA = 0;
				long countB = 0;
				long countC = 0;
				for (int j = i; j < i + z; j++)
				{
					if (countA > p || countB > p || countC > p)
						break;
					if (str[j] == 'A')
						countA++;
					else if (str[j] == 'B')
						countB++;
					else
						countC++;
				}
				if (countA == countB && countB == countC && countA == countC)
					count++;
			}
			p++;
		}
		System.out.println(count);
	}
}
