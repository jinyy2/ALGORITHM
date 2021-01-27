package level1;

public class L1_자연수뒤집어배열로만들기 {

	public static void main(String[] args) {
		long n = 12345;
		System.out.println(solution(n));
	}

	public static int[] solution(long n) {

		String str = Long.toString(n);
		String[] strArr = str.split("");
		int[] answer = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			answer[i] = Integer.parseInt(strArr[strArr.length - 1 - i]);
		}
		// StringBuilder sb = new StringBuilder(Long.toString(n));
		// sb.reverse();
		// String[] strArr = sb.toString().split("");
		// int[] answer = new int[strArr.length];
		// for(int i=0;i<strArr.length;i++){
		// answer[i] = Integer.parseInt(strArr[i]);
		// }

		return answer;
	}

}
