package level1;

public class L1_하샤드수 {

	public static void main(String[] args) {
		int x = 10;
		System.out.println(solution(x));
	}

	public static boolean solution(int x) {
		boolean answer = true;
		String[] str = (String.valueOf(x)).split("");
		int sum = 0;

		for (int i = 0; i < str.length; i++) {
			sum += Integer.parseInt(str[i]);
		}
		if (x % sum != 0)
			answer = false;
		return answer;
	}

}
