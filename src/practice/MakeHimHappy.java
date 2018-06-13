package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakeHimHappy
{
	int mid;
	static int min = 99999999;
	static boolean check = false;

	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		int[] arr = new int[n];
		Map<Integer, List<Integer>> temp = new HashMap<Integer, List<Integer>>();
		List<Integer> ls = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
		{
			arr[i] = Integer.parseInt(input[i]);
			if (temp.get(arr[i]) != null)
				ls = temp.get(arr[i]);
			else
				ls = new ArrayList<Integer>();
			ls.add(i);
			temp.put(arr[i], ls);
		}
		int time = -1;
		for (int i = 0; i < n; i++)
		{
			int num = k - arr[i];
			List<Integer> l = temp.get(num);
			if (num > 0 && l != null)
			{
				int least = l.get(0);
				int high = l.get(l.size() - 1);
				if (least > i)
					time = getMin(i, least, arr, n);
				if (least != high && high > i)
					time = getMin(i, high, arr, n);
			}
		}
		System.out.println(time);
	}

	static int getMin(int lower, int upper, int[] arr, int n)
	{
		int mid = n / 2;
		if (arr[lower] != arr[upper])
		{
			check = true;
			if (upper <= mid)
			{
				int leftTime = upper + 1;
				if (min > leftTime)
					min = leftTime;
			} else if (lower >= mid)
			{
				int rightTime = n - lower;
				if (min > rightTime)
					min = rightTime;
			}
			if (lower <= mid && upper >= mid)
			{
				int lt = lower + 1;
				int rt = (n - upper);
				int bothTime;
				if (lt < rt)
					bothTime = rt;
				else if (lt > rt)
					bothTime = lt;
				else
					bothTime = lt;
				if (min > bothTime)
					min = bothTime;
			}
		}
		if (!check)
			return -1;
		else
			return min;
	}
}