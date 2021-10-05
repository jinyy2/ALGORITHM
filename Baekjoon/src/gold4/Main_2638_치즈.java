package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638_치즈 {
    static int N, M;
    static int[][] map;
    static boolean[][] checked;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Cheese {
        int r;
        int c;

        public Cheese(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 2][M + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int meltCnt = 0;
        while (true) {
            boolean cheeseReamin = false;
            //치즈가 남아있지 않으면 그만
            loop:
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (map[i][j] == 1) {
                        cheeseReamin = true;
                        break loop;
                    }
                }
            }
            if (!cheeseReamin) break;
            //치즈가 남아있으면 멜팅
            meltCnt++;
            airCheck();
            meltCheeseCheck();
        }
        System.out.println(meltCnt);

    }

    private static void meltCheese(Queue<Cheese> queue) {
        while (!queue.isEmpty()) {
            Cheese cheese = queue.poll();
            map[cheese.r][cheese.c] = 0;
        }
    }

    private static void meltCheeseCheck() {
        Queue<Cheese> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0) continue;

                // 적어도 2변 이상이 실내온도의 공기와 접촉
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if (map[nr][nc] == 0 && checked[nr][nc]) cnt++;
                    if (cnt >= 2) {
                        queue.offer(new Cheese(i, j));
                        break;
                    }
                }
            }
        }
        meltCheese(queue);
    }

    private static void airCheck() {
        checked = new boolean[N + 2][M + 2];
        Queue<Cheese> queue = new LinkedList<>();
        queue.offer(new Cheese(0, 0));
        checked[0][0] = true;
        while (!queue.isEmpty()) {
            Cheese cheese = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cheese.r + dr[d];
                int nc = cheese.c + dc[d];
                if (!safe(nr, nc)) continue;
                if (checked[nr][nc]) continue;
                if (map[nr][nc] == 0) {
                    checked[nr][nc] = true;
                    queue.offer(new Cheese(nr, nc));
                }
            }
        }
    }

    private static boolean safe(int nr, int nc) {
        return 0 <= nr && 0 <= nc && nr < N + 2 && nc < M + 2;
    }
}
