import java.util.Arrays;
import java.util.Comparator;

public class Solution_가장큰수 {

	public static void main(String[] args) {
		int[] input = { 6, 10, 2 };
		System.out.println(solution(input));
	}

	public static String solution(int[] numbers) {
		String[] num = new String[numbers.length];
		for (int i = 0; i < num.length; i++) {
			num[i] = "" + numbers[i];
		}
		Arrays.sort(num, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
		if (num[0].equals("0"))
			return "0";

		String answer = "";
		for (int i = 0; i < num.length; i++) {
			answer += num[i];
		}

		return answer;
	}

}
