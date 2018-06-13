package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HotelBytelandia
{
	private int in;
	private int out;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0)
		{
			int guest = Integer.parseInt(br.readLine());
			List<HotelBytelandia> ls = new ArrayList<HotelBytelandia>();
			String[] inTime = br.readLine().split(" ");
			String[] outTime = br.readLine().split(" ");
			for (int i = 0; i < guest; i++)
			{
				HotelBytelandia time = new HotelBytelandia();
				time.in = Integer.parseInt(inTime[i]);
				time.out = Integer.parseInt(outTime[i]);
				ls.add(time);
			}
			Collections.sort(ls, new Comparator<HotelBytelandia>()
			{
				@Override
				public int compare(HotelBytelandia o1, HotelBytelandia o2)
				{
					return (o1.out > o2.out ? 1 : o1.out < o2.out ? -1 : 0);
				}
			});
			int max = 1;
			for (int i = 0; i < ls.size() - 1; i++)
			{
				int count = 1;
				for (int j = i + 1; j < ls.size(); j++)
				{
					if (ls.get(i).out > ls.get(j).in)
						count++;
				}
				if (max < count)
					max = count;

				if (max == guest)
					break;
			}
			System.out.println(max);
		}
	}
}
