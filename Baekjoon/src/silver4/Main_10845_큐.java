package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                deque.offer(value);
            } else if (command.equals("pop")) {
                if (deque.isEmpty()) sb.append("-1\n");
                else sb.append(deque.poll()).append("\n");
            } else if (command.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (command.equals("empty")) {
                if (deque.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (command.equals("front")) {
                if (!deque.isEmpty()) {
                    sb.append(deque.peekFirst()).append("\n");
                } else sb.append("-1\n");
            } else if (command.equals("back")) {
                if (!deque.isEmpty()) {
                    sb.append(deque.peekLast()).append("\n");
                } else sb.append("-1\n");
            }
        }
        System.out.println(sb.toString());
    }

}
