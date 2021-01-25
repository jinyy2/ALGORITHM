package level1;

import java.util.*;

public class L1_문자열내림차순으로배치하기 {

	public static void main(String[] args) {
		String s = "Zbcdefg";
		System.out.println(solution(s));
	}

	public static String solution(String s) {
		String answer = "";
//	         char[] ch = s.toCharArray();

//	         Arrays.sort(ch);

//	         for(char c : ch){
//	             answer = c+answer;
//	         }
		String[] str = s.split("");
		Arrays.sort(str, Collections.reverseOrder());
		for (int i = 0; i < str.length; i++) {
			answer += str[i];
		}
		return answer;
	}

}
