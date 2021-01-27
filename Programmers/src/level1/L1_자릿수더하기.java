package level1;

import java.util.*;

public class L1_자릿수더하기 {

	public static void main(String[] args) {
		int n = 987;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int answer = 0;
		// String num = Integer.toString(n);
		// String[] numArr = num.split("");
		// for(String s : numArr){
		// answer += Integer.parseInt(s);
		// }
		while (true) {
			answer += n % 10;
			if (n < 10)
				break;
			n /= 10;
		}

		return answer;
	}

}
