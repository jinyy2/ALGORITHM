package kakao2021;

import java.util.Arrays;

public class Solution_kakao2021_합승택시요금_FloydWarshall {
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(solution(n, s, a, b, fares));
    }

    private static final int MAX = 200 * 100000 + 1;

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = MAX;
        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i < map.length; ++i) {
            Arrays.fill(map[i], MAX);
            map[i][0] = 0;
            map[i][i] = 0;
        }
        for (int i = 0; i < fares.length; ++i) {
            map[fares[i][0]][fares[i][1]] = fares[i][2];
            map[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        for (int k = 1; k < n + 1; ++k) {
            for (int i = 1; i < map.length; ++i) {
                for (int j = 1; j < map[i].length; ++j) {
                    if (i == k || k == j) continue;
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        for (int k = 1; k < map.length; k++) {
            answer = Math.min(answer, map[s][k] + map[k][a] + map[k][b]);
        }
        return answer;
    }
}
