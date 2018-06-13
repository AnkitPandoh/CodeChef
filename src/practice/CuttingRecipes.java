package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CuttingRecipes
{
	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0)
		{
			String[] input = br.readLine().split(" ");
			int q = Integer.parseInt(input[0]);
			int[] arr = new int[q];
			int l = 0;
			for (int i = 1; i < input.length; i++)
				arr[l++] = Integer.parseInt(input[i]);
			l = 0;
			int[] temp = new int[arr.length];
			for (int k : arr)
				temp[l++] = k;
			int m = 0, n, i = 0;
			while (i < arr.length - 1)
			{
				if (arr[i] < arr[i + 1])
				{
					m = arr[i + 1];
					n = arr[i];
				} else
				{
					m = arr[i];
					n = arr[i + 1];
				}
				while (n != 0)
				{
					int k = m % n;
					m = n;
					n = k;
				}
				if (m == 1)
					break;
				else
					arr[++i] = m;
			}
			if (m == 1)
				for (int k : temp)
					System.out.print(k + " ");
			else
				for (int k : temp)
					System.out.print(k / m + " ");
			System.out.println();
		}
	}
}
