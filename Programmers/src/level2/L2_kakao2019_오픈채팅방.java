package level2;

import java.util.*;

public class L2_kakao2019_오픈채팅방 {

	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		System.out.println(Arrays.toString(solution(record)));
	}

	static class Record {
		String result;
		String uid;

		public Record(String result, String uid) {
			this.result = result;
			this.uid = uid;
		}
	}

	public static String[] solution(String[] record) {

		ArrayList<String> list = new ArrayList<>();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < record.length; i++) {
			String[] str = record[i].split(" ");
			if (str[0].equals("Enter")) {
				map.put(str[1], str[2]);
				list.add(str[1] + "님이 들어왔습니다.");
			} else if (str[0].equals("Leave")) {
				list.add(str[1] + "님이 나갔습니다.");
			} else if (str[0].equals("Change")) {
				map.put(str[1], str[2]);
			}
		}
		String[] answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = map.get(list.get(i).replaceAll("[^a-zA-Z0-9]+", ""))
					+ list.get(i).replaceAll("[a-zA-Z0-9]+", "");
		}
		return answer;

	}

}
