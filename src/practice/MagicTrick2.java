package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class MagicTrick2 {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			BigDecimal[] l = new BigDecimal[n];
			String[] input = br.readLine().split(" ");
			int k = 0;
			for (int i = 0; i < n; i++)
				l[k++] = BigDecimal.valueOf(Long.parseLong(input[i]));
			input = br.readLine().split(" ");
			long a = Long.parseLong(input[0]);
			long b = Long.parseLong(input[1]);
			long c = Long.parseLong(input[2]);
			String s = br.readLine();
			BigDecimal cvalue = new BigDecimal(c);
			for (int i = 0; i < n; i++) {
				String str = s.substring(i, i + 1);
				if ("R".equals(str))
					l = reverse(l, i);
				else if ("A".equals(str))
					l = add(l, a, i);
				else if ("M".equals(str))
					l = multiply(l, b, i, c);

				for (int j = i; j < n; j++)
					l[j] = l[j].divideAndRemainder(cvalue)[1];
				System.out.print(l[i] + " ");
			}
			System.out.println();
		}
	}

	static BigDecimal[] reverse(BigDecimal[] arr, int j) {
		for (int i = j, k = arr.length - 1; i < k; i++, k--) {
			BigDecimal temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
		}
		return arr;
	}

	static BigDecimal[] add(BigDecimal[] arr, long a, int j) {
		BigDecimal avalue = new BigDecimal(a);
		for (int i = j; i < arr.length; i++)
			arr[i] = arr[i].add(avalue);
		return arr;
	}

	static BigDecimal[] multiply(BigDecimal[] arr, long b, int j, long c) {
		BigDecimal bvalue = new BigDecimal(b);
		for (int i = j; i < arr.length; i++) {
			arr[i] = arr[i].multiply(bvalue);
		}
		return arr;
	}
}
