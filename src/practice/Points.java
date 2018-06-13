package practice;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Points
{
	int x;
	int y;

	Points(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0)
		{
			String blank = br.readLine();
			int n = Integer.parseInt(br.readLine());
			List<Points> ls = new ArrayList<Points>();
			for (int i = 0; i < n; i++)
			{
				String[] input = br.readLine().split(" ");
				int x = Integer.parseInt(input[0]);
				int y = Integer.parseInt(input[1]);
				Points coordinates = new Points(x, y);
				ls.add(coordinates);
			}
			Collections.sort(ls, new Comparator<Points>()
			{
				@Override
				public int compare(Points p1, Points p2)
				{
					if (p1.x < p2.x)
						return -1;
					else if (p1.x > p2.x)
						return 1;
					else if (p1.x == p2.x)
					{
						if (p1.y > p2.y)
							return -1;
						else if (p1.y < p2.y)
							return 1;
						else if (p1.y == p2.y)
							return 0;
					}
					return 0;
				}
			});
			System.out.printf("%.2f", calDistance(ls));
			System.out.println();
		}
	}

	private static double calDistance(List<Points> ls)
	{
		double distance = 0;
		for (int k = 0; k < ls.size() - 1; k++)
		{
			Points p1 = ls.get(k);
			Points p2 = ls.get(k + 1);
			int x1 = p1.x;
			int y1 = p1.y;
			int x2 = p2.x;
			int y2 = p2.y;
			distance += (Math.sqrt(Math.pow((x2 - x1), 2)
					+ Math.pow((y2 - y1), 2)));
		}
		return distance;
	}
}
