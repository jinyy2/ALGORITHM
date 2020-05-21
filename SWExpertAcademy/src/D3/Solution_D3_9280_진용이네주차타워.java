package D3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_9280_진용이네주차타워 {
	static int T, n, m;
	static int fee;
	static int[] R_i;
	static int[] W_i;
	static int[] car_number;
	static int[] parking;
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> que = new LinkedList<Integer>();
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			R_i = new int[n];
			W_i = new int[m];
			// R_i 값 받기
			for (int i = 0; i < n; i++) {
				R_i[i] = Integer.parseInt(br.readLine());
			}
			// W_i 값 받기
			for (int i = 0; i < m; i++) {
				W_i[i] = Integer.parseInt(br.readLine());
			}
			// 차량 번호
			car_number = new int[m * 2];
			for (int i = 0; i < m * 2; i++) {
				car_number[i] = Integer.parseInt(br.readLine());
			}
			sum = 0;
			// 주차장 개설
			parking = new int[n];

			for (int i = 0; i < m * 2; i++) {
				// In 양수
				if (car_number[i] >= 0) {
					for (int j = 0; j < n; j++) {
						// 주차할 수 있어
						if (parking[j] == 0) {
							parking[j] = car_number[i];
							sum += R_i[j] * W_i[parking[j] - 1];
							break;
						} else if (j == n - 1 && parking[j] != 0) {
							que.offer(car_number[i]);
						}
					}
					// Out 음수
				} else {
					for (int j = 0; j < n; j++) {
						if (parking[j] == -car_number[i]) {
							parking[j] = 0;
							if (!que.isEmpty()) {
								parking[j] = que.poll();
								sum += R_i[j] * W_i[parking[j] - 1];

							}
						}
					}
				}
			}
			bw.write("#" + test_case + " " + sum + "\n");
		}
		bw.close();
	}
}