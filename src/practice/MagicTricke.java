package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicTricke
{
	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0)
		{
			int n = Integer.parseInt(br.readLine());
			long[] l = new long[n];
			String[] input = br.readLine().split(" ");
			int k = 0;
			for (int i = 0; i < n; i++)
				l[k++] = Long.parseLong(input[i]);
			input = br.readLine().split(" ");
			long a = Long.parseLong(input[0]);
			long b = Long.parseLong(input[1]);
			long c = Long.parseLong(input[2]);
			String s = br.readLine();
			b %= c;
			doWork(l, a, b, c, n, s);
		}
	}

	static void doWork(long[] l, long a, long b, long c, int n, String s)
	{
		int begin = 0;
		for (int i = 0; i < n; i++)
		{
			String str = s.substring(i, i + 1);
			if ("A".equals(str) || "M".equals(str))
				doJob(begin, i, l, s, a, b, i, c);
			else if ("R".equals(str))
			{
				int last = i;
				for (int j = i; j < n; j++)
					doJob(begin, i, l, s, a, b, j, c);
				reverse(l, last, c);
				begin = i + 1;
			}
			System.out.print(l[i] + " ");
		}
		System.out.println();
	}

	static void doJob(int begin, int index, long[] arr, String s, long a,
			long b, int j, long c)
	{
		for (int i = begin; i <= index; i++)
		{
			String str = s.substring(i, i + 1);
			if ("A".equals(str))
			{
				arr[j] += a;
				arr[j] %= c;
			} else if ("M".equals(str))
			{
				/*if (c > b || c > a)
				{
					BigDecimal bvalue = new BigDecimal(b);
					BigDecimal cvalue = new BigDecimal(c);
					BigDecimal arrvalue = new BigDecimal(arr[j]);
					BigDecimal result = arrvalue.multiply(bvalue);
					BigDecimal mod = result.divideAndRemainder(cvalue)[1];
					arr[j] = Long.valueOf(mod.toString());
				} else
				{*/
					arr[j] %= c;
					arr[j] *= b;
					arr[j] %= c;
				//}
			}
		}
	}

	static long[] reverse(long[] arr, int j, long c)
	{
		int i = j;
		for (int k = arr.length - 1; i < k; i++, k--)
		{
			arr[i] %= c;
			long temp = arr[i];
			arr[k] %= c;
			arr[i] = arr[k];
			arr[k] = temp;
		}
		arr[i] %= c;
		return arr;
	}
}
