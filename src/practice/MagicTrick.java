package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicTrick {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] l = new long[n];
			String[] input = br.readLine().split(" ");
			int k = 0;
			for (int i = 0; i < n; i++)
				l[k++] = Long.parseLong(input[i]);
			input = br.readLine().split(" ");
			long a = Long.parseLong(input[0]);
			long b = Long.parseLong(input[1]);
			long c = Long.parseLong(input[2]);
			String s = br.readLine();
			for (int i = 0; i < n; i++) {
				String str = s.substring(i, i + 1);
				if ("R".equals(str))
					l = reverse(l, i, c);
				else if ("A".equals(str))
					l = add(l, a, i, c);
				else if ("M".equals(str))
					l = multiply(l, b, i, c);

				System.out.print(l[i] + " ");
			}
			System.out.println();
		}
	}

	static long[] reverse(long[] arr, int j, long c) {
		for (int i = j, k = arr.length - 1; i < k; i++, k--) {
			long temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
		}
		for (int i = j; i < arr.length; i++) {
			arr[i] %= c;
		}
		return arr;
	}

	static long[] add(long[] arr, long a, int j, long c) {
		for (int i = j; i < arr.length; i++) {
			arr[i] += a;
			arr[i] %= c;
		}
		return arr;
	}

	static long[] multiply(long[] arr, long b, int j, long c) {
		b %= c;
		for (int i = j; i < arr.length; i++) {
			arr[i] %= c;
			arr[i] *= b;
			arr[i] %= c;
		}
		return arr;
	}
	
}
