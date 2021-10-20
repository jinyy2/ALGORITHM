package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1931_회의실배정 {
    static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if (this.end == o.end) {
                return this.start - o.start;
            } else {
                return this.end - o.end;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Node(s, e));
        }
        Collections.sort(list);
        int e = 0;
        int cnt = 0;
        for (Node node : list) {

            if (e <= node.start) {
                e = node.end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}