package practice;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class Granama
{
	public static void main(String[] args)
	{
		InputReader io = new InputReader(System.in);
		int test = io.readInt();
		while (test-- > 0)
		{
			String first = io.readString();
			String scond = io.readString();
			Map<Character, Integer> mapFirst = dowork(first);
			Map<Character, Integer> mapScond = dowork(scond);
			if (mapFirst.size() != mapScond.size())
				System.out.println("YES");
			else
			{
				boolean check = true;
				for (Map.Entry<Character, Integer> e : mapFirst.entrySet())
				{
					char key = e.getKey();
					if (mapScond.get(key) == null)
					{
						check=true;
						break;
					}
					else
					{
						if (e.getValue() != mapScond.get(key))
							check = false;
					}
				}
				if (check)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}

	static Map dowork(String str)
	{
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++)
		{
			int count = 1;
			if (map.get(str.charAt(i)) == null)
				map.put(str.charAt(i), count);
			else
			{
				count = map.get(str.charAt(i));
				map.put(str.charAt(i), ++count);
			}
		}
		return map;
	}
}

class InputReader
{
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;

	public InputReader(InputStream stream)
	{
		this.stream = stream;
	}

	public int read()
	{
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars)
		{
			curChar = 0;
			try
			{
				numChars = stream.read(buf);
			} catch (IOException e)
			{
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public int readInt()
	{
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-')
		{
			sgn = -1;
			c = read();
		}
		int res = 0;
		do
		{
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public long readLong()
	{
		int c = read();
		while (isSpaceChar(c))
			c = read();
		long sgn = 1;
		if (c == '-')
		{
			sgn = -1;
			c = read();
		}
		long res = 0;
		do
		{
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public String readString()
	{
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do
		{
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}

	public boolean isSpaceChar(int c)
	{
		if (filter != null)
			return filter.isSpaceChar(c);
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public String next()
	{
		return readString();
	}

	public interface SpaceCharFilter
	{
		public boolean isSpaceChar(int ch);
	}
}
