package level1;

import java.util.*;

public class L1_정수내림차순으로배치하기 {

	public static void main(String[] args) {
		long n = 118372;
		System.out.println(solution(n));
	}

	public static long solution(long n) {
		long answer = 0;
		String[] str = (String.valueOf(n)).split("");
		Arrays.sort(str, Collections.reverseOrder());
		String num = "";
		for (int i = 0; i < str.length; i++) {
			num += str[i];
		}
		answer = Long.parseLong(num);
		return answer;
	}

}
