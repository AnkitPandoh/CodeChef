package practice;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

class Main
{
	public static void main(String[] args) throws Exception
	{
		final InputReader in = new InputReader(System.in);
		final OutputWriter out = new OutputWriter(System.out);
		int t, h1[] = new int[26], h2[] = new int[26], c, i, flag, len1, len2;
		char r[], s[];
		t = in.readInt();
		while (t-- > 0)
		{
			r = (in.readString()).toCharArray();
			s = (in.readString()).toCharArray();
			len1 = r.length;
			len2 = s.length;
			for (i = 0; i < 26; i++)
				h1[i] = h2[i] = 0;
			for (i = 0; i < len1; i++)
				h1[r[i] - 'a']++;
			for (i = 0; i < len2; i++)
				h2[s[i] - 'a']++;
			flag = 0;

			for (i = 0; i < 26; i++)
			{
				if ((h1[i] == 0 && h2[i] != 0) || (h1[i] != 0 && h2[i] == 0))
				{
					// printf("ingredients mismatched\n");
					flag = 1;
					break;
				}
			}
			if (flag == 0)
			{
				flag = 1;
				for (i = 0; i < 26; i++)
				{
					if (h1[i] != h2[i])
					{
						flag = 0;
						break;
					}
				}
				// if(i==26&&flag!=0)
				// flag=1;
			}
			if (flag == 1)
				out.printLine("YES");
			else
				out.printLine("NO");
		}

		out.close();
	}

	static class InputReader
	{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

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

		public String readLine()
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do
			{
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
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

		public long readLong()
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

		public boolean isSpaceChar(int c)
		{
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public boolean isEndOfLine(int c)
		{
			return c == '\n' || c == '\r' || c == -1;
		}
	}

	static class OutputWriter
	{
		private final PrintWriter writer;

		public OutputWriter(OutputStream outputStream)
		{
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					outputStream)));
		}

		public OutputWriter(Writer writer)
		{
			this.writer = new PrintWriter(writer);
		}

		public void print(Object... objects)
		{
			for (int i = 0; i < objects.length; i++)
			{
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}

		public void printLine(Object... objects)
		{
			print(objects);
			writer.println();
		}

		public void close()
		{
			writer.close();
		}
	}
}