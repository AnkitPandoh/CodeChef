package practice;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ChefAndMatrices
{
	public static void main(String[] args) throws IOException
	{
		Input io = new Input(System.in);
		int n = io.getNextInt();
		int arr[] = new int[n / 2];
		for (int i = 1; i <= n / 2; i++)
			arr[i - 1] = i * (n - i);
		int last = arr[arr.length - 1];
		long prime[] = new long[last - 1];
		prime[0] = 1;
		for (int i = 2; i < last; i++)
			prime[i - 1] = calPrimeFactor(i);
		long sum1 = 0, sum2 = 0, temp = 0;
		int k = 0;
		for (int i = 0; k < arr.length; i++)
		{
			if (i == arr[k] - 1)
			{
				temp = sum2;
				sum2 = sum1;
				if (arr[k] != n)
					sum2 *= 2;
				else
					sum2 *= 1;
				sum2 += temp;
				k++;
				i--;
			} else
				sum1 += prime[i];
		}
		System.out.println(sum2);
	}

	static long calPrimeFactor(int n)
	{
		List<Integer> ls = new ArrayList<Integer>();
		for (int i = 2; n != 1; i++)
		{
			int sum = 0;
			while (n % i == 0 && n > 1)
			{
				n /= i;
				sum++;
			}
			ls.add(sum + 1);
		}
		long ksum = 1;
		for (int e : ls)
			ksum *= e;
		return ksum;
	}

	static class Input
	{
		private BufferedInputStream inp = null;
		private int offset = 0;
		private int size = 51200;
		private byte[] buff = new byte[size];

		public Input(InputStream in) throws IOException
		{
			inp = new BufferedInputStream(in);
			inp.read(buff, 0, size);
		}

		public int getNextInt() throws IOException
		{
			int parsedInt = 0;
			int i = offset;
			while (i < buff.length && (buff[i] < '0' || buff[i] > '9'))
			{
				i++;
			}
			while (i < buff.length && buff[i] >= '0' && buff[i] <= '9')
			{
				parsedInt *= 10;
				parsedInt += buff[i] - '0';
				i++;
			}
			if (i == buff.length)
			{
				int j = 0;
				for (; offset < buff.length; j++, offset++)
				{
					buff[j] = buff[offset];
				}
				inp.read(buff, j, size - j);
				offset = 0;
				parsedInt = getNextInt();
			} else
			{
				offset = i;
			}
			return parsedInt;
		}
	}
}
