package practice;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class ChefAndDigit
{
	public static void main(String[] args) throws IOException
	{
		InputReader1 in = new InputReader1(System.in);
		int n = in.readInt();
		int m = in.readInt();
		String num = in.readString();
		char[] arr = num.toCharArray();
		Map<Integer,Map<Integer,Integer>> map = new HashMap<Integer,Map<Integer,Integer>>();
		for(int i=0;i<arr.length;i++)
		{
			int val = arr[i]-48;
			Map<Integer,Integer> tempMap = new HashMap<Integer,Integer>();
			for(Map.Entry<Integer,Map<Integer,Integer>> e : map.entrySet())
			{
			}
			if(map.get(i-1) != null)
				tempMap = map.get(i-1);
			int count = 0;
			if(tempMap != null && tempMap.get(val) != null)
			{
				count = tempMap.get(val);
				tempMap.put(val, ++count);
			}
			else
				tempMap.put(val, 1);
			map.put(i, tempMap);
		}
		
		while (m-- > 0)
		{
			int x = in.readInt();
			x -= 1;
			Map<Integer,Integer> ans = new HashMap<Integer,Integer>();
			ans = map.get(x-1);
			int xvalue = arr[x]- 48;
			int sum = 0;
			if(ans != null)
			{
				for (Map.Entry<Integer, Integer> e : ans.entrySet())
				{
					int cal = e.getKey()*e.getValue();
					sum += Math.abs(xvalue- cal);
				}
			}
			System.out.println(sum);
		}
	}
}

class InputReader1
{
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;

	public InputReader1(InputStream stream)
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
