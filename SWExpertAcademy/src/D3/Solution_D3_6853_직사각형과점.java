package D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_6853_직사각형과점 {
	static int T, N;
	static int squareIn;
	static int squareOn;
	static int squareOut;
	static int x1, x2, y1, y2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			squareIn = 0;
			squareOn = 0;
			squareOut = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			if (x1 > x2) {
				int tempX = x1;
				x1 = x2;
				x2 = tempX;
			}
			if (y1 > y2) {
				int tempY = y1;
				y1 = y2;
				y2 = tempY;
			}
			N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				StringTokenizer xy = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(xy.nextToken());
				int y = Integer.parseInt(xy.nextToken());
				checkIn(x, y);
				checkOn(x, y);
				checkOut(x, y);
			}

			bw.write("#" + test_case + " " + squareIn + " " + squareOn + " " + squareOut + "\n");
		}
		bw.close();
	}

	public static void checkIn(int x, int y) {// 00
		if ((x1 < x && x2 > x) && (y1 < y && y2 > y)) {
			squareIn++;
		}
	}

	public static void checkOn(int x, int y) {
		if ((x1 == x && (y1 <= y && y2 >= y)) || (x2 == x && (y1 <= y && y2 >= y)) || (y1 == y && (x1 <= x && x2 >= x))
				|| (y2 == y && (x1 <= x && x2 >= x))) {
			squareOn++;
		}
	}

	public static void checkOut(int x, int y) {
		if (x1 > x || x2 < x || y1 > y || y2 < y) {
			squareOut++;
		}
	}
}