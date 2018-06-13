package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PayingUp {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0) {
			String[] input = br.readLine().split(" ");
			int num = Integer.parseInt(input[0]);
			int money = Integer.parseInt(input[1]);
			int[] notes = new int[num];
			int k = 0;
			for (int i = 0; i < num; i++)
				notes[k++] = Integer.parseInt(br.readLine());
			Arrays.sort(notes);
			int pos = notes.length - 1;
			for (int i = 0; i < notes.length; i++) {
				if (notes[i] > money) {
					pos = i - 1;
					break;
				}
			}
			int sum = 0, count = 0, lastsum = 0;
			for (int i = pos; i >= 0; i--) {
				if (count == 1)
					break;
				if (notes[i] == money) {
					count = 1;
					break;
				}
				int j = i - 1;
				while (j >= 0) {
					lastsum = notes[i];
					int p = j;
					while (p >= 0) {
						sum = notes[p] + lastsum;
						if (sum == money) {
							count = 1;
							break;
						} else if (sum < money) {
							lastsum = sum;
						} else {
							lastsum = sum - notes[p];
						}
						p--;
					}
					if (count == 1)
						break;
					j--;
				}
			}
			if (count == 1)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}
