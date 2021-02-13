package level2;

public class L2_최댓값과최솟값 {

	public static void main(String[] args) {
		String s = "-1 -2 -3 -4";
		System.out.println(solution(s));
	}

	public static String solution(String s) {
		String answer = "";
		String[] str = s.split(" ");
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < str.length; i++) {
			max = Math.max(max, Integer.parseInt(str[i]));
			min = Math.min(min, Integer.parseInt(str[i]));
		}
		answer = min + " " + max;
		return answer;
	}

}
