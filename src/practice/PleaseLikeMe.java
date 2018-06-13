package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PleaseLikeMe
{
	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0)
		{
			String[] input = br.readLine().split(" ");
			int l = Integer.parseInt(input[0]);
			int d = Integer.parseInt(input[1]);
			int s = Integer.parseInt(input[2]);
			int c = Integer.parseInt(input[3]);
			int constant = 1 + c;
			long cald = (long) (s * Math.pow((constant), (d - 1)));
			if (l <= cald)
				System.out.println("ALIVE AND KICKING");
			else
				System.out.println("DEAD AND ROTTING");
		}
	}
}
