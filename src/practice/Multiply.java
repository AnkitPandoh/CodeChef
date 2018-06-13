package practice;

public class Multiply
{
	public static void main(String[] args){
		String a = "123";
		String b = "934";
		
		char[] first = a.toCharArray();
		char[] second = b.toCharArray();
		
		int sum = 0,carry=0,val=0;
		String result, temp =null;
		int[] mid = new int[second.length+1];
		int k = mid.length-1;
		for(int i =first.length-1;i>=0;i--)
		{
			for(int j=second.length-1;j>=0;j--)
			{
				int mul = ((first[i]-48) * (second[j]-48))+carry;
				carry = mul / 10;
				//result = String.valueOf(mul%10);
				mid[k--] = mul%10;
			}
			val = Integer.valueOf(temp);
			val += val * Math.pow(10,i);
		}
	    System.out.println(val);
	}
}
