import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int r;
	int c;

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}

	@Override
	public String toString() {
		return "Point [r=" + r + ", c=" + c + "]";
	}

}

public class Main_17144_미세먼지안녕 {
	static int R, C, T;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R + 1][C + 1];

		Queue<Point> queue = new LinkedList<Point>();

		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != -1)
					queue.add(new Point(i, j));
			}
		} // input-end
		print(map);
		while (!queue.isEmpty()) {
			Point temp = queue.poll();
			System.out.println(temp + " " + map[temp.r][temp.c]);
		}

	}

	private static void print(int[][] pr) {
		for (int i = 1; i < pr.length; i++) {
			for (int j = 1; j < pr[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
