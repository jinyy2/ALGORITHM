package level2;
import java.util.*;
public class L2_kakao2018_파일명정렬 {

	public static void main(String[] args) {
		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		System.out.println(Arrays.toString(solution(files)));
	}

	public static String[] solution(String[] files) {
		String[] answer = {};
		Arrays.sort(files, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				boolean s1Flag = true;
				int s1IdxNumber = 0;
				int s1IdxTail = s1.length();
				for (int i = 0; i < s1.length(); i++) {
					char c1 = s1.charAt(i);
					if (s1Flag && '0' <= c1 && c1 <= '9') {
						s1IdxNumber = i;
						s1Flag = false;
					} else if (!s1Flag && !('0' <= c1 && c1 <= '9')) {
						s1IdxTail = i;
						s1Flag = true;
						break;
					} else if (!s1Flag && i == s1.length() - 1) {
						s1Flag = false;

					}
				}
				String s1Head = s1.substring(0, s1IdxNumber);
				String s1Number = s1.substring(s1IdxNumber, s1IdxTail);
				String s1Tail = "";
				if (s1Flag)
					s1Tail = s1.substring(s1IdxTail);

				boolean s2Flag = true;
				int s2IdxNumber = 0;
				int s2IdxTail = s2.length();
				for (int i = 0; i < s2.length(); i++) {
					char c2 = s2.charAt(i);
					if (s2Flag && '0' <= c2 && c2 <= '9') {
						s2IdxNumber = i;
						s2Flag = false;
					} else if (!s2Flag && !('0' <= c2 && c2 <= '9')) {
						s2IdxTail = i;

						break;
					} else if (!s2Flag && i == s2.length() - 1) {
						s2Flag = false;

					}
				}
				String s2Head = s2.substring(0, s2IdxNumber);
				String s2Number = s2.substring(s2IdxNumber, s2IdxTail);
				String s2Tail = "";
				if (s2Flag)
					s2Tail = s2.substring(s2IdxTail);

				if (s1Head.toLowerCase().equals(s2Head.toLowerCase())) {
					return Integer.parseInt(s1Number) - Integer.parseInt(s2Number);
				} else {
					return s1Head.toLowerCase().compareTo(s2Head.toLowerCase());
				}

			}
		});

		return files;
	}

}
