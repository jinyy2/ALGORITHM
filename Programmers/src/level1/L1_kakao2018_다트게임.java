package level1;

public class L1_kakao2018_다트게임 {

	public static void main(String[] args) {
		String[] dart = { "1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*" };
		for (String str : dart) {
			System.out.println(solution(str));
		}
	}

	public static int solution(String dartResult) {
		int answer = 0;
		int[] score = new int[4];
		int num = 0;
		int scoreIdx = 1;
		for (int i = 0; i < dartResult.length(); i++) {
			char ch = dartResult.charAt(i);
			if ('0' <= ch && ch <= '9') {
				if (i > 0 && ch == '0' && dartResult.charAt(i - 1) == '1') {
					continue;
				} else if (ch == '1') {
					if (dartResult.charAt(i + 1) == '0')
						num = 10;
					else
						num = 1;
				} else {
					num = ch - '0';
				}
			} else if (ch == 'S' || ch == 'D' || ch == 'T') {
				if (ch == 'S')
					num = (int) Math.pow(num, 1);
				if (ch == 'D')
					num = (int) Math.pow(num, 2);
				if (ch == 'T')
					num = (int) Math.pow(num, 3);
				score[scoreIdx++] = num;
			} else if (ch == '*' || ch == '#') {
				if (ch == '*') {
					score[scoreIdx - 1] *= 2;
					score[scoreIdx - 2] *= 2;
				} else if (ch == '#') {
					score[scoreIdx - 1] = -num;
				}
			}
		}
		for (int plus : score) {
			answer += plus;
		}
		return answer;
	}
}
