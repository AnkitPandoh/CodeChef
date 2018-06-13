package practice;

public class MakxSum
{
	public static void main(String[] args)
	{
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		int maxsofar = 0,maxend = 0;
		for(int i=0;i<arr.length;i++)
		{
			maxend += arr[i];
			if(maxend < 0)
				maxend = 0;
			if(maxsofar < maxend)
				maxsofar = maxend;
		}
		System.out.println(maxsofar);
	}
}
