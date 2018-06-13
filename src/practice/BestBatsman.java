package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BestBatsman
{
	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0)
		{
			String[] input = br.readLine().split(" ");
			int k = Integer.parseInt(br.readLine());
			int[] arr = new int[11];
			int j = 0;
			Map<Integer, Integer> original = new HashMap<Integer, Integer>();
			for (int i = 0; i < 11; i++)
			{
				arr[j] = Integer.parseInt(input[i]);
				int count = 0;
				if (original.containsKey(arr[j]))
				{
					count = original.get(arr[i]);
					original.put(arr[i], count + 1);
				} else
					original.put(arr[i], count + 1);
				j++;
			}
			Arrays.sort(arr);
			Map<Integer, Integer> temp = new HashMap<Integer, Integer>();

			for (int i = arr.length - 1; i >= arr.length - k; i--)
			{
				int count = 0;
				if (temp.containsKey(arr[i]))
				{
					count = temp.get(arr[i]);
					temp.put(arr[i], count + 1);
				} else
					temp.put(arr[i], count + 1);
			}
			int result = 1;
			for (Map.Entry<Integer, Integer> e : temp.entrySet())
			{
				int origval = original.get(e.getKey());
				int tempval = temp.get(e.getKey());
				if (origval != tempval)
					result *= factorial(origval)
							/ (factorial(tempval) * factorial(origval - tempval));
			}
			System.out.println(result);
		}
	}

	static int factorial(int n)
	{
		int f = 1;
		for (int i = n; i > 0; i--)
			f *= i;
		return f;
	}
}
