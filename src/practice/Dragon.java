package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dragon
{
	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0)
		{
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int a = Integer.parseInt(input[1]);
			int b = Integer.parseInt(input[2]);

			char[] first = toBinary(a, n).toCharArray();
			char[] second = toBinary(b, n).toCharArray();

			int zero1 = 0, one1 = 0, zero2 = 0, one2 = 0;
			int i = 0;
			while (i < first.length)
			{
				if (first[i] == '0')
					zero1++;
				else
					one1++;
				i++;
			}
			i = 0;
			while (i < second.length)
			{
				if (second[i] == '0')
					zero2++;
				else
					one2++;
				i++;
			}
			int k = 0;
			char[] firstTemp = new char[first.length];
			char[] secondTemp = new char[second.length];

			if (zero1 < one2)
			{
				while (zero1-- > 0)
				{
					firstTemp[k] = '0';
					secondTemp[k] = '1';
					k++;
				}
			} else
			{
				while (one2-- > 0)
				{
					firstTemp[k] = '0';
					secondTemp[k] = '1';
					k++;
				}
			}
			if (one1 < zero2)
			{
				while (one1-- > 0)
				{
					firstTemp[k] = '1';
					secondTemp[k] = '0';
					k++;
				}
			} else
			{
				while (zero2-- > 0)
				{
					firstTemp[k] = '1';
					secondTemp[k] = '0';
					k++;
				}
			}
			while (k != n)
			{
				firstTemp[k] = '0';
				secondTemp[k] = '0';
				k++;
			}
			StringBuilder firstBin = new StringBuilder();
			for (char l : firstTemp)
				firstBin.append(l);
			Long aDec = Long.parseLong(firstBin.toString(), 2);

			firstBin = new StringBuilder();
			for (char l : secondTemp)
				firstBin.append(l);
			Long bDec = Long.parseLong(firstBin.toString(), 2);
			System.out.println(aDec ^ bDec);
		}
	}

	static String toBinary(int num, int bits)
	{
		int[] binary = new int[bits];
		int k = bits - 1;
		while (num != 0)
		{
			binary[k--] = num % 2;
			num /= 2;
		}
		StringBuilder bin = new StringBuilder();
		for (int i : binary)
			bin.append(i);
		return bin.toString();
	}
}
