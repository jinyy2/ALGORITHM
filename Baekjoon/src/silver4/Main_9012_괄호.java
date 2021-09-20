package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack;
        loop:for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            stack = new Stack<>();
            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == ')') {
                    if (stack.isEmpty()) {
                        sb.append("NO\n");
                        continue loop;
                    } else stack.pop();
                } else {
                    stack.add('(');
                }
            }
            if (stack.isEmpty()) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb.toString());
    }
}
