package codingTestHighScoreKit;

public class Solution_해시_전화번호목록 {

	public static void main(String[] args) {
		String[] phone_book = { "119", "97674223", "1195524421" };
		System.out.println(solution(phone_book));
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;

		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 0; j < phone_book.length; j++) {
				if (i == j)
					continue;
				if (phone_book[j].contains(phone_book[i])) {
					boolean flag = false;
					for (int k = 0; k < phone_book[i].length(); k++) {
						if (phone_book[i].charAt(k) != phone_book[j].charAt(k))
							flag = true;
					}
					if (!flag)
						return false;

				}
			}
		}

		return answer;
	}

}
