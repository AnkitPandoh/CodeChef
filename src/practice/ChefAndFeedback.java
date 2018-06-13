package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndFeedback
{
	public static void main(String[] args) throws NumberFormatException,
			IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0)
		{
			String str = br.readLine();
			if (str.length() < 3)
				System.out.println("Bad");
			else
			{
				boolean good = false;
				for (int i = 0; i <= str.length() - 3; i++)
				{
					String temp = str.substring(i, i + 3);
					if ("101".equals(temp) || "010".equals(temp))
					{
						System.out.println("Good");
						good = true;
						break;
					}
				}
				if (!good)
					System.out.println("Bad");
			}
		}
	}
}
