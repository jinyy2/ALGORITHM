import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {
	static LinkedList<Integer>[] magnet;
	static int K; // 회전 횟수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		magnet = new LinkedList[5]; // 1, 2, 3, 4

		for (int i = 1; i <= 4; i++) {
			magnet[i] = new LinkedList<Integer>();
			char[] c = br.readLine().toCharArray();

			for (int j = 0; j < 8; j++) {
				magnet[i].add(c[j] - '0'); // 톱니 입력
			}
		}
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int mNum = Integer.parseInt(st.nextToken());
			boolean dir = Integer.parseInt(st.nextToken()) == 1 ? true : false; // true: 시계, false: 반시계

			if (mNum > 1) {
				action(mNum,6,dir);
			}
			if (mNum > 1 && mNum < 4) {
				rotate(mNum,!dir);
			}
			if (mNum < 4) {
				action(mNum,2,dir);
			}
			
		}
		int ans =0;
		for (int i = 1; i <= 4; i++) {
			ans += (magnet[i].get(0)*(1<<(i-1)));
		}
		System.out.println(ans);
	}

	private static void action(int mNum, int idx, boolean dir) { // idx 2 | 6
		int mNext = mNum + (idx==2 ? +1:-1); //2면 오른쪽
		if(mNext>0&&mNext<5&&magnet[mNum].get(idx)!=magnet[mNext].get((idx+4)%8)){
			action(mNext,idx,!dir);
		}
		rotate(mNum,dir);

	}

	private static void rotate(int mNum, boolean dir) {
		if (dir) { // 시계
			magnet[mNum].addFirst(magnet[mNum].removeLast());
		} else { // 반시계
			magnet[mNum].addLast(magnet[mNum].removeFirst());
		}

	}

}
