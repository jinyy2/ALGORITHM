package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_10866_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        Deque<Integer> deque = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push_front")) {
                int pushFrontValue = Integer.parseInt(st.nextToken());
                deque.offerFirst(pushFrontValue);
            } else if (command.equals("push_back")) {
                int pushBackValue = Integer.parseInt(st.nextToken());
                deque.offerLast(pushBackValue);
            } else if (command.equals("pop_front")) {
                if (deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.pollFirst()).append("\n");
            } else if (command.equals("pop_back")) {
                if (deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.pollLast()).append("\n");
            } else if (command.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (command.equals("empty")) {
                if (deque.isEmpty()) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            } else if (command.equals("front")) {
                if (deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.peekFirst()).append("\n");
            } else if (command.equals("back")) {
                if (deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.peekLast()).append("\n");
            }
        }
        System.out.println(sb.toString());

    }
}
