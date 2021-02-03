package level2;

import java.util.*;

public class L2_kakao2018_압축 {

	public static void main(String[] args) {
		String msg = "TOBEORNOTTOBEORTOBEORNOT";
		System.out.println(Arrays.toString(solution(msg)));
	}

	public static int[] solution(String msg) {

		// 1. 사전 초기화
		ArrayList<String> dictionary = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		dictionary.add("");
		for (int i = 0; i < 26; i++) {
			dictionary.add("" + (char) (65 + i));
		}
		while (msg.length() > 0) {
			// 2. 일치하는 가장 긴 문자열 찾기 => 뒤에서부터
			for (int i = dictionary.size() - 1; i > 0; i--) {
				if (msg.length() < dictionary.get(i).length())
					continue;
				if (dictionary.get(i).equals(msg.substring(0, dictionary.get(i).length()))) {
					// 3.색인 번호 출력
					list.add(i);

					// 4.다음 글자가 남아있나 확인 후 등록
					if (msg.length() - dictionary.get(i).length() > 0) {

						dictionary.add(msg.substring(0, dictionary.get(i).length() + 1));

					}
					// 3.입력에서 w 제거
					msg = msg.substring(dictionary.get(i).length());
					break;
				}
			}
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

}
