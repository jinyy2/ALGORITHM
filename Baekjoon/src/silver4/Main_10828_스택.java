package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_10828_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("push")) {
                stack.add(Integer.parseInt(command[1]));
            } else if (command[0].equals("pop")) {
                if (stack.isEmpty()) sb.append("-1\n");
                else sb.append(stack.pop() + "\n");
            } else if (command[0].equals("size")) {
                sb.append(stack.size() + "\n");
            } else if (command[0].equals("empty")) {
                if (stack.isEmpty()) sb.append("1\n");
                else sb.append("0\n");
            } else if (command[0].equals("top")) {
                if (stack.isEmpty()) sb.append("-1\n");
                else sb.append(stack.peek() + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
