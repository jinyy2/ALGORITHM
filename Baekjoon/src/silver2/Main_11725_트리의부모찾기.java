package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11725_트리의부모찾기 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] checked;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
            list.get(e).add(s);
        }

        checked = new boolean[N + 1];
        parents = new int[N + 1];
//        dfs(1);
        bfs();
        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }

    }

    public static void dfs(int node) {
        checked[node] = true;
        for (int child : list.get(node)) {
            if (checked[child]) continue;
            parents[child] = node;
            dfs(child);
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            checked[node] = true;
            for (int child : list.get(node)) {
                if (checked[child]) continue;
                parents[child] = node;
                queue.offer(child);
            }
        }
    }
}
