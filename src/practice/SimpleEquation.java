package practice;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SimpleEquation
{
	public static void main(String[] args) throws IOException
	{
		Input io = new Input(System.in);
		int test = io.getNextInt();
		while (test-- > 0)
		{
			int n = io.getNextInt();
			int a = io.getNextInt();
			int b = io.getNextInt();
			int c = io.getNextInt();
			int[] arr =
			{ a, b, c };
			Arrays.sort(arr);
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			int k = 0;
			for (int i = 0; i <= arr[0]; i++)
				map.put(k++, i + 1);
			int count = 0;
			for (int i = 0; i <= arr[2]; i++)
			{
				for (int j = 0; j <= arr[1]; j++)
				{
					int x = n - (i + j);
					if (x >= 0)
					{
						Integer temp = map.get(x);
						if (temp == null)
							count += arr[0] + 1;
						else
							count += temp;
					}
					else
						break;
				}
			}
			System.out.println(count);
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
