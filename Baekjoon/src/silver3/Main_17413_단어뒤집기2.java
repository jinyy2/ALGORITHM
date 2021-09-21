package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_17413_단어뒤집기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] ch = br.readLine().toCharArray();
        boolean flag = false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '>') {
                sb.append('>');
                flag = false;
            } else if (ch[i] == '<') {
                sb.append(flushStack(stack));
                sb.append('<');
                flag = true;
            } else if (flag) {
                sb.append(ch[i]);
            } else if (ch[i] != ' ') {
                stack.add(ch[i]);
            } else if (ch[i] == ' ') {
                sb.append(flushStack(stack)).append(' ');
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }

    public static String flushStack(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();

    }
}
