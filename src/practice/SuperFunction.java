package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuperFunction
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		long n = Long.parseLong(input[0]);
		long k = Long.parseLong(input[1]);
		long m = Long.parseLong(input[2]);
		long sum = 0;
		long i = 1;
		while (i < n)
		{
			if(!(n % i == 0 || (i % 2==0 && n % 2 ==0)))
			{	
				long result = calculateGCD(i, n);
				if (result == 1)
					sum += Math.pow(i, k);
			}
			i++;
		}
		System.out.println(sum % m +1);
	}

	private static long calculateGCD(long m, long n)
	{
		if (n % m == 0)
			return m;
		while (m != 0)
		{
			long rem = n % m;
			n = m;
			m = rem;
		}
		return n;
	}
}
