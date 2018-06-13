package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cielab
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int result = a - b;
		int digit = result%10;
		if(digit == 9)
			System.out.println(result -= 1);
		else
			System.out.println(result += 1);
	}
}
