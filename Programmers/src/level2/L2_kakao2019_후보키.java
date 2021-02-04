package level2;

import java.util.*;

public class L2_kakao2019_후보키 {

	public static void main(String[] args) {
		String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };

		System.out.println(solution(relation));

	}

	static int N;
	static ArrayList<String> list;
	static String[][] db;
	static int answer;

	public static int solution(String[][] relation) {
		db = relation;
		answer = 0;
		N = relation[0].length;
		list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			StringBuilder sb = new StringBuilder();
			combi(i, 0, 0, sb);
		}
		return answer;
	}

	public static void combi(int r, int cnt, int cur, StringBuilder sb) {
		if (cnt == r) {
			// 최소성을 만족하는지 확인하기
			for (int i = 0; i < list.size(); i++) {
				if (sb.toString().replaceAll("[" + list.get(i) + "]", "").length() == sb.toString().length()
						- list.get(i).length()) {
					return;
				}
			}

			HashMap<String, Integer> map = new HashMap<>();
			String[] str = sb.toString().split("");
			StringBuilder concat;
			boolean flag = true;
			loop: for (int j = 0; j < db.length; j++) {
				concat = new StringBuilder();
				for (int k = 0; k < str.length; k++) {
					concat.append(db[j][Integer.parseInt(str[k])]);
				}
				if (map.containsKey(concat.toString())) {
					flag = false;
					break loop;
				} else {
					map.put(concat.toString(), 1);
				}
			}
			if (flag) {
				list.add(sb.toString());
				answer++;
			}

			return;
		}
		for (

				int i = cur; i < N; i++) {
			sb.append(i);
			combi(r, cnt + 1, i + 1, sb);
			sb.delete(cnt, cnt + 1);
		}
	}

}
