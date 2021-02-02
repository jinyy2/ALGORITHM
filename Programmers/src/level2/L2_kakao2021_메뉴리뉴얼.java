package level2;

import java.util.*;

public class L2_kakao2021_메뉴리뉴얼 {
	public static void main(String[] args) {
		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		int[] course = { 2, 3, 4 };
		System.out.println(Arrays.toString(solution(orders, course)));
	}

	static HashMap<String, Integer> map;
	static StringBuilder sb;

	public static String[] solution(String[] orders, int[] course) {

		ArrayList<String> list = new ArrayList<>();

		// orders 오름차순 정렬
		for (int i = 0; i < orders.length; i++) {
			char[] ch = orders[i].toCharArray();
			Arrays.sort(ch);
			orders[i] = String.valueOf(ch);
		}
		for (int i = 0; i < course.length; i++) {
			map = new HashMap<>();
			sb = new StringBuilder();
			for (int j = 0; j < orders.length; j++) {
				if (course[i] > orders[j].length())
					continue;
				combi(orders[j], course[i], 0, 0);
			}
			int max = Integer.MIN_VALUE;
			for (Map.Entry<String, Integer> kv : map.entrySet()) {
				max = Math.max(max, kv.getValue());
			}
			for (Map.Entry<String, Integer> kv : map.entrySet()) {
				if (max == kv.getValue() && kv.getValue() >= 2) {
					list.add(kv.getKey());

				}
			}
		}

		String[] answer = new String[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		Arrays.sort(answer);

		return answer;
	}

	public static void combi(String order, int r, int cnt, int cur) {
		// 종료조건
		if (cnt == r) {
			if (map.containsKey(sb.toString())) {
				map.put(sb.toString(), map.get(sb.toString()) + 1);
			} else {
				map.put(sb.toString(), 1);
			}
			return;
		}
		for (int i = cur; i < order.length(); i++) {
			sb.append(order.charAt(i));
			combi(order, r, cnt + 1, i + 1);
			sb.delete(cnt, cnt + 1);
		}

	}

}
