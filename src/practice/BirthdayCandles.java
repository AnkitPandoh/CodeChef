package practice;

public class BirthdayCandles
{
	public static void main(String[] args){
		int[] arr =  {490,800,999,422,211,233,977,1000,411,933};
		int i=1,j=1,count=0;
		while(count == 0)
		{
			int[] temp = new int[arr.length];
			int k = 0;
			for(int e : arr)
				temp[k++] = e;
			i = j;
			while(i!=0)
			{
				int digit = i%10;
				int num = i/10;
				i = num;
				if(temp[digit] == 0)
					count=1;
				else
					temp[digit] -=1;
			}
			j++;
		}
		System.out.println(j-1);
	}
}
