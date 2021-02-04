package level2;

import java.util.*;
import java.util.Map.Entry;

public class L2_kakako2018_뉴스클러스터링 {
	public static void main(String[] args) {
		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";
		System.out.println(solution(str1, str2));
	}

	public static int solution(String str1, String str2) {
		int answer = 0;

		HashMap<String, Integer> map = new HashMap<>();
		HashMap<String, Integer> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		if (str1.equals(str2))
			return 65536;
		for (int i = 0; i < str1.length() - 1; i++) {
			String tempStr1 = str1.substring(i, i + 2).replaceAll("[^A-Z]+", "");
			if (tempStr1.length() != 2)
				continue;

			map1.put(tempStr1, map1.getOrDefault(tempStr1, 0) + 1);

		}
		for (int i = 0; i < str2.length() - 1; i++) {
			String tempStr2 = str2.substring(i, i + 2).replaceAll("[^A-Z]+", "");
			if (tempStr2.length() != 2)
				continue;
//			hs.add(tempStr2);
			map2.put(tempStr2, map2.getOrDefault(tempStr2, 0) + 1);
		}

		int min = 0;
		int sum = 0;
		for (Entry<String, Integer> s : map1.entrySet()) {
			System.out.println(s.getKey() + " " + s.getValue() + " " + map2.getOrDefault(s.getKey(), 0));
			min += Math.min(s.getValue(), map2.getOrDefault(s.getKey(), 0));
			if (map2.containsKey(s.getKey())) {
				sum += Math.max(s.getValue(), map2.get(s.getKey()));
			} else {
				sum += s.getValue();
			}
		}
		for (Entry<String, Integer> s : map2.entrySet()) {
			if (map1.containsKey(s.getKey()))
				continue;
			sum += s.getValue();
		}

		if (sum == 0)
			return 0;
		System.out.println(min + " " + sum);
		answer = 65536 * min / sum;

		return answer;
	}

}
