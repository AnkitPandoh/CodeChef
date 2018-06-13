package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ForbiddenSum
{
	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int k = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[k++] = Integer.parseInt(input[i]);
		int m = Integer.parseInt(br.readLine());
		int savemax = 0;
		int savecheck = -1;
		int pl = -1, pr = -1;
		while (m-- > 0)
		{
			input = br.readLine().split(" ");
			int l = Integer.parseInt(input[0]);
			int r = Integer.parseInt(input[1]);
			if (r < pr)
				System.out.println(savecheck);
			else if (r == pl && savecheck < arr[r - 1])
				System.out.println(savecheck);
			else
			{
				pl = l;
				pr = r;
				int p = l - 1;
				Set<Integer> complete = new TreeSet<Integer>();
				while (p < r)
				{
					int maxsum = 0;
					for (int i = l - 1; i <= p; i++)
						maxsum += arr[i];
					Set<Integer> temp = new HashSet<Integer>();
					for (int i = l - 1; i <= p; i++)
						temp.add(maxsum - arr[i]);
					for (int i : complete)
						temp.add(arr[p] + i);
					if (complete.size() == 0)
						complete.add(arr[l - 1]);
					complete.addAll(temp);
					savemax = maxsum;
					p++;
				}
				int check = arr[l - 1];
				boolean end = false;
				complete.remove(0);
				for (int i : complete)
				{
					if (check == i)
						check++;
					else
					{
						System.out.println(check);
						savecheck = check;
						end = true;
						break;
					}
				}
				if (!end)
				{
					savecheck = savemax +1;
					System.out.println(savemax + 1);
				}
			}
		}
	}
}
