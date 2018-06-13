package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BonApetite
{
	private int in;
	private int out;
	private int prefer;

	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0)
		{
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);
			List<BonApetite> ls = new ArrayList<BonApetite>();
			Map<Integer, List<BonApetite>> map = new HashMap<Integer, List<BonApetite>>();
			for (int j = 0; j < n; j++)
			{
				input = br.readLine().split(" ");
				BonApetite customer = new BonApetite();
				customer.in = Integer.parseInt(input[0]);
				customer.out = Integer.parseInt(input[1]);
				customer.prefer = Integer.parseInt(input[2]);
				ls.add(customer);
			}
			for (BonApetite cust : ls)
			{
				if (map.get(cust.prefer) != null)
					map.get(cust.prefer).add(cust);
				else
				{
					List<BonApetite> temp = new ArrayList<BonApetite>();
					temp.add(cust);
					map.put(cust.prefer, temp);
				}
			}
			int max = 0;
			for (Map.Entry<Integer, List<BonApetite>> e : map.entrySet())
				max += calculateCount(e.getValue());
			System.out.println(max);
		}
	}
	/**
	 * sort with finish time and compare if out time of first is less than
	 * or equal to in time of second. If it is compatible take it and compare it 
	 * with others
	 * @param ls
	 * @return
	 */
	static int calculateCount(List<BonApetite> ls)
	{
		Collections.sort(ls, new Comparator<BonApetite>()
		{
			public int compare(BonApetite o1, BonApetite o2)
			{
				return (o1.out > o2.out ? 1 : o1.out < o2.out ? -1 : 0);
			}
		});
		int i = 0,j=i+1,count=1;
		while(i < ls.size() && j < ls.size())
		{
			while(j < ls.size())
			{
				if(ls.get(i).out <= ls.get(j).in)
				{
					count++;
					i=j;
				}
				j++;
			}
		}
		return count;
	}
}
