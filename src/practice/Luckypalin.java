package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Luckypalin
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test > 0)
		{
			String s = br.readLine();
			int len = s.length();
			if (len < 9)
				System.out.println("unlucky");
			else
			{
				char[] arr = s.toCharArray();
				char[] lucky =
				{ 'l', 'u', 'c', 'k', 'y' };
				int front=0,end=0,k=0,count=0;
				for(int i=0,j=len-1;k<5;i++,j--)
				{
					if(lucky[k] != arr[i])
						front++;
					if(lucky[k] != arr[j])
						end++;
					k++;
				}
				int str1 = front+end;
				k=4;front=0;end=0;
				for(int i=0,j=len-1;k>=0;i++,j--)
				{
					if(lucky[k] != arr[i])
						front++;
					if(lucky[k] != arr[j])
						end++;
					k--;
				}
				int str2 = front+end;
				if(str1==str2)
				{
					k=0;
					for(int i=0,j=len-1;k<5;i++,j--)
					{
						if(lucky[k] != arr[i])
							arr[i] = lucky[k];
						if(lucky[k] != arr[j])
							arr[j] = lucky[k];
						k++;
					}
				}
				else if(str1<str2)
				{
					k=0;
					for(int i=0,j=len-1;k<5;i++,j--)
					{
						if(lucky[k] != arr[i])
							arr[i] = lucky[k];
						if(lucky[k] != arr[j])
							arr[j] = lucky[k];
						k++;
					}
					for(int i=5,j=len-5;i<=j;i++,j--)
					{
						if ((int) arr[i] > (int) arr[j])
							arr[i] = arr[j];
						else
							arr[j] = arr[i];
						count += str1;
					}
				}
				else{
					k=4;
					for(int i=0,j=len-1;k>0;i++,j--)
					{
						if(lucky[k] != arr[i])
							arr[i] = lucky[k];
						if(lucky[k] != arr[j])
							arr[j] = lucky[k];
						k--;
					}
					for(int i=5,j=len-5;i<=j;i++,j--)
					{
						if ((int) arr[i] > (int) arr[j])
							arr[i] = arr[j];
						else
							arr[j] = arr[i];
						count += str2;
					}
				}
				for (int i = 0; i < len; i++)
					System.out.print(arr[i]);
				System.out.println(" " + count);
			}
			test--;
		}
	}
}
