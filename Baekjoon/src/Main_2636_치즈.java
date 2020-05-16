import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2636_치즈 {

   static int R, C;
   static int[][] map;
   static int[] dy = { -1, 0, 1, 0 };
   static int[] dx = { 0, 1, 0, -1 };
   static boolean[][] visited;
   static int cheezeCnt;
   static int timeCnt;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = null;

      st = new StringTokenizer(br.readLine());
      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
      map = new int[R][C];
      timeCnt = 0;

      for (int i = 0; i < R; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < C; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
            if (map[i][j] == 1)
               cheezeCnt++;
         }
      } // input-end

//      print(map); // input-check
      while (!cheezeEmpty()) {
         visited = new boolean[R][C];
         cheezeCnt();
         dfs(0, 0);
         timeCnt++;
      }
      System.out.println(timeCnt);
      System.out.println(cheezeCnt);
   }

   // 치즈조각 개수 확인
   private static void cheezeCnt() {
      cheezeCnt = 0;
      
      for (int i = 0; i < R; i++) {
         for (int j = 0; j < C; j++) {
            if (map[i][j] == 1)
               cheezeCnt++;
         }
      }
   }

   // 치즈가 남아있는지 확인
   private static boolean cheezeEmpty() {
      for (int i = 0; i < R; i++) {
         for (int j = 0; j < C; j++) {
            if (map[i][j] == 1)
               return false;
         }
      }
      return true;
   }

   // 공기와 접촉한 치즈 녹이기
   private static void dfs(int y, int x) {
      visited[y][x] = true;
      
      for (int d = 0; d < 4; d++) {
         int ny = y + dy[d];
         int nx = x + dx[d];

         if (safe(ny, nx) && map[ny][nx] == 1) {
            visited[ny][nx] = true;
            map[ny][nx] = 0;
         } else if (safe(ny, nx) && !visited[ny][nx] && map[ny][nx] == 0) {
            dfs(ny, nx);
         }
      }
   }

   // 배열 나가지 않게 하는 method
   private static boolean safe(int ny, int nx) {
      return ny >= 0 && ny < R && nx >= 0 && nx < C;
   }

   // input check method
   private static void print(int[][] pr) {
      for (int i = 0; i < pr.length; i++) {
         for (int j = 0; j < pr[i].length; j++) {
            System.out.print(pr[i][j] + " ");
         }
         System.out.println();
      }
   }
}