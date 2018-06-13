package practice;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BallAndCups
{
	public static void main(String[] args) throws IOException
	{
		Input io = new Input(System.in);
		int test = io.getNextInt();
		while (test-- > 0)
		{
			int n = io.getNextInt();
			int c = io.getNextInt();
			int q = io.getNextInt();
			for (int i = 0; i < q; i++)
			{
				int l = io.getNextInt();
				int r = io.getNextInt();
				if (c >= l && c <= r && l != r)
					c = l + (r - c);
			}
			System.out.println(c);
		}
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
