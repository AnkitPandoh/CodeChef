package practice;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BinTree
{
	static long count = 0;

	public static void main(String[] args) throws IOException
	{
		Input io = new Input(System.in);
		int q = io.getNextInt();
		while (q-- > 0)
		{
			count = 0;
			int i = io.getNextInt();
			int j = io.getNextInt();
			while (i != j)
			{
				if (i > j)
					i = getParent(i);
				else
					j = getParent(j);
			}
			System.out.println(count);
		}
	}

	static int getParent(int n)
	{
		if (n % 2 == 0)
			n /= 2;
		else if (n % 2 != 0)
			n = (n - 1) / 2;
		count++;
		return n;
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
