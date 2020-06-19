package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Solution_D4_7701_염라대왕의이름정렬 {
	static int T;

	public static class OHC implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			if (o1.length() > o2.length()) {
				return 1;
			} else if (o1.length() < o2.length()) {
				return -1;
			} else {
				return o1.compareTo(o2);
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		TreeSet<String> ts = new TreeSet<>();
		LinkedList<String> names = new LinkedList<>();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			ts.clear();
			names.clear();
			for (int j = 0; j < N; j++) {
				String name = br.readLine();
				ts.add(name);
			}
			for (Iterator<String> iterator = ts.iterator(); iterator.hasNext();) {
				names.add(iterator.next());

			}
			names.sort(new OHC());
			System.out.println("#" + test_case);
			for (String a : names) {
				System.out.println(a);
			}
		}
	}
}