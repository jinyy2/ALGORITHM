package level2;

public class L2_kakao2017_단체사진찍기 {

	public static void main(String[] args) {
		int n = 2;
		String[] data = { "N~F=0", "R~T>2" };
		System.out.println(solution(n, data));
	}

	static boolean[] visited;
	static char[] ch;
	static char[] friends = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
	static String[] dataa;
	static int answer;

	public static int solution(int n, String[] data) {
		dataa = data;
		visited = new boolean[8];
		ch = new char[8];
		answer = 0;
		perm(0);
		return answer;
	}

	private static void perm(int cnt) {
		if (cnt == 8) {
			if (check(ch))
				answer++;
			return;
		}
		for (int i = 0; i < 8; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			ch[cnt] = friends[i];
			perm(cnt + 1);
			visited[i] = false;
		}
	}

	private static boolean check(char[] friend) {
		boolean flag = true;
		int first = 0;
		int second = 0;
		for (int i = 0; i < dataa.length; i++) {
			for (int j = 0; j < friend.length; j++) {
				if (friend[j] == dataa[i].charAt(0))
					first = j;
				if (friend[j] == dataa[i].charAt(2))
					second = j;
			}
			char sign = dataa[i].charAt(3);
			int distance = (int) Math.abs(first - second) - 1;
			int value = dataa[i].charAt(4) - '0';
			if (sign == '<' && distance < value) {
				continue;
			} else if (sign == '>' && distance > value) {
				continue;
			} else if (sign == '=' && distance == value) {
				continue;
			} else {
				return false;
			}
		}
		return flag;
	}

}
