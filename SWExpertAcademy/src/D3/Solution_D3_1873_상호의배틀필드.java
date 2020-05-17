package D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_D3_1873_상호의배틀필드 {
	static int T, H, W, N;
	static char[][] map;

	static char[] direction;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int d;
	static int y, x;
	static int shoot_y, shoot_x;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			N = Integer.parseInt(br.readLine());
			direction = br.readLine().toCharArray();

			// 출발 좌표 얻어
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '^') {
						y = i;
						x = j;
						break;
					} else if (map[i][j] == 'v') {
						y = i;
						x = j;
						break;
					} else if (map[i][j] == '<') {
						y = i;
						x = j;
						break;
					} else if (map[i][j] == '>') {
						y = i;
						x = j;
						break;
					}
				}
			}
//			출발 좌표 확인
//			System.out.println("y: "+y+", x: "+x);

			for (int i = 0; i < N; i++) {
				// UP
				direction(direction[i],i);
			}
			bw.write("#" + test_case + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					bw.write(map[i][j]);
				}
				bw.newLine();
			}
		}
		bw.close();
	}
	public static void direction(char arrow, int q) {
		if(arrow=='S') {
			d = 0;
		}else if(arrow=='D') {
			d = 1;
		}else if(arrow=='L') {
			d = 2;
		}else if(arrow=='R') {
			d= 3;
		}
		if (direction[q] == arrow) {
			// 갈 수 있는지 확인
			map[y][x] = '^';
			if (y + dy[0] >= 0 && map[y + dy[0]][x+dx[0]] == '.') {
				map[y][x] = '.';
				y += dy[0];
				x += dx[0];
				map[y][x] = '^';
			}
		}
		// DOWN
		else if (direction[q] == arrow) {
			map[y][x] = 'v';
			if (y + dy[1] < H && map[y + dy[1]][x+dx[1]] == '.') {
				map[y][x] = '.';
				y += dy[1];
				map[y][x] = 'v';
			}
			// LEFT
		} else if (direction[q] == arrow) {
			map[y][x] = '<';
			if (x + dx[2] >= 0 && map[y + dy[2]][x + dx[2]] == '.') {
				map[y][x] = '.';
				x += dx[2];
				map[y][x] = '<';
			}
			// RIGHT
		} else if (direction[q] == arrow) {
			map[y][x] = '>';
			if (x + dx[3] < W && map[y + dy[3]][x + dx[3]] == '.') {
				map[y][x] = '.';
				x += dx[3];
				map[y][x] = '>';
			}
		}if (direction[q] == arrow) {
			if (map[y][x] == '^') {
				shoot_y = y;
				shoot_y += dy[0];
				while (shoot_y >= 0) {
					// 벽돌
					if (map[shoot_y][x] == '*') {
						map[shoot_y][x] = '.';
						break;
						// 강철
					} else if (map[shoot_y][x] == '#') {
						break;
					}
					shoot_y += dy[0];
				}
			} else if (map[y][x] == 'v') {
				shoot_y = y;
				shoot_y += dy[1];
				while (shoot_y < H) {
					// 벽돌
					if (map[shoot_y][x] == '*') {
						map[shoot_y][x] = '.';
						break;
						// 강철
					} else if (map[shoot_y][x] == '#') {
						break;
					}
					shoot_y += dy[1];
				}
			} else if (map[y][x] == '<') {
				shoot_x = x;
				shoot_x += dx[0];
				while (shoot_x >= 0) {
					// 벽돌
					if (map[y][shoot_x] == '*') {
						map[y][shoot_x] = '.';
						break;
						// 강철
					} else if (map[y][shoot_x] == '#') {
						break;
					}
					shoot_x += dx[2];
				}
			} else if (map[y][x] == '>') {
				shoot_x = x;
				shoot_x += dx[3];
				while (shoot_x < W) {
					// 벽돌
					if (map[y][shoot_x] == '*') {
						map[y][shoot_x] = '.';
						break;
						// 강철
					} else if (map[y][shoot_x] == '#') {
						break;
					}
					shoot_x += dx[3];
				}
			}
		}
	} 
}
