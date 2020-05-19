package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_3499_퍼펙트셔플 {
	static int T, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		Queue<String> que1 = new LinkedList<String>();
		Queue<String> que2 = new LinkedList<String>();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			if (N % 2 == 1) {
				for (int i = 0; i < N; i++) {
					if (i <= N / 2) {
						que1.offer(st.nextToken());
					} else {
						que2.offer(st.nextToken());
					}
				}
			} else {
				for (int i = 0; i < N; i++) {
					if (i < N / 2) {
						que1.offer(st.nextToken());
					} else {
						que2.offer(st.nextToken());
					}
				}
			}
			System.out.print("#" + test_case + " ");
			while (!que1.isEmpty() || !que2.isEmpty()) {
				System.out.print(que1.poll() + " ");
				if (!que2.isEmpty()) {
					System.out.print(que2.poll() + " ");
				}
			}
			System.out.println();
		}
	}
}
