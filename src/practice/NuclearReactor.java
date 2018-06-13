package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NuclearReactor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		long a = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);
		int[] chamber = new int[k];
		int i = 0;
		while (n != 0 && a > 0) {
			i = 0;
			if (chamber[i] < n)
				chamber[i]++;
			else {
				chamber[i] = 0;
				if (!(i == k - 1)) {
					chamber[++i]++;
					reaction(chamber, n, i, a);
				}
			}
			a--;
		}
		for (int arr : chamber)
			System.out.print(arr + " ");
	}

	static void reaction(int[] chamber, int n, int i, long a) {
		if (a == 0)
			return;

		if (chamber[i] > n) {
			chamber[i] = 0;
			chamber[++i]++;
			reaction(chamber, n, i, a);
		}
	}
}
