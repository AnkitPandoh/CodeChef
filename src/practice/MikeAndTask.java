package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MikeAndTask
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		long x = Long.parseLong(input[1]);
		input = br.readLine().split(" ");
		int[] arr = new int[n];
		int k = 0;
		for(int i = 0;i<n;i++)
			arr[k++] = Integer.parseInt(input[i]);
		Arrays.sort(arr);
		int count = 0, sum= 0;
		int pos =0,nextPos=0;
		for(int i = 0;i<arr.length;i++)
		{
			sum =+ arr[i];
			if(sum <= x)
				count++;
			if(sum >= x)
			{
				pos = i;
				nextPos = i+1;
				break;
			}
		}
		int j;
		for(int i =0;i<=pos;i++)
		{
			int val = arr[i] / 2;
			if(val % 2 == 0)
				j = val/2;
			else
				j= val/2 + 1;
			
		}
	}
	
	private void check(int[] arr, int nextPos,int extra)
	{
		for(int i = nextPos; i<arr.length;i++)
		{
			
		}
	}
}
