package level1;

public class L1_kakao2020_키패드누르기 {

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand = "right";
		System.out.println(solution(numbers, hand));
	}

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static String solution(int[] numbers, String hand) {
		String answer = "";
		int[][] map = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { -1, 0, -1 } };
		Point left = new Point(3, 0);
		Point right = new Point(3, 2);
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) { // left
				answer += "L";
				if (numbers[i] == 1)
					left = new Point(0, 0);
				if (numbers[i] == 4)
					left = new Point(1, 0);
				if (numbers[i] == 7)
					left = new Point(2, 0);
			} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) { // right
				answer += "R";
				if (numbers[i] == 3)
					right = new Point(0, 2);
				if (numbers[i] == 6)
					right = new Point(1, 2);
				if (numbers[i] == 9)
					right = new Point(2, 2);
			} else {// middle hand
				int r = 0;
				int c = 1;
				for (int j = 0; j < 4; j++) {
					if (map[j][1] == numbers[i]) {
						r = j;
						break;
					}
				}

				int leftD = Math.abs(left.r - r) + Math.abs(left.c - c);
				int rightD = Math.abs(right.r - r) + Math.abs(right.c - c);

				if (leftD < rightD) {
					answer += "L";
					left = new Point(r, c);
				} else if (leftD > rightD) {
					answer += "R";
					right = new Point(r, c);
				} else {
					if (hand.equals("left")) {
						answer += "L";
						left = new Point(r, c);
					} else if (hand.equals("right")) {
						answer += "R";
						right = new Point(r, c);
					}
				}
			}
		}
		return answer;
	}

}
