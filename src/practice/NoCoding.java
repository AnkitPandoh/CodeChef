package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NoCoding
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0)
		{
			String input = br.readLine();
			int simple = input.length() * 11;
			char[] arr = input.toCharArray();
			int count = 0;
			int max = 'z';
			for (int i = 1; i < arr.length; i++)
			{
				int first = arr[i - 1];
				int second = arr[i];
				if (second - first >= 0)
					count += second - first + 1;
				else
					count += max - first + second-'a' + 2;
			}
			count += 2;
			if (count > simple)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}
}