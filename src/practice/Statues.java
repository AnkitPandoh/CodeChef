package practice;
import java.util.Scanner;

public class Statues
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int t = 1;
		int rooms = input.nextInt();
		while (rooms != 0)
		{
			int arr[] = new int[rooms];
			int k = 0, sum = 0, count = 0;
			for (int i = 0; i < rooms; i++)
			{
				arr[k++] = input.nextInt();
				sum += arr[i];
			}
			int num = sum / rooms;
			for (int i = 0; i < rooms; i++)
				if (arr[i] > num)
					count += (arr[i] - num);
			System.out.println("Set #" + t);
			System.out.println("The minimum number of moves is " + count + ".");
			System.out.println();
			rooms = input.nextInt();
			t++;
		}
	}
}
