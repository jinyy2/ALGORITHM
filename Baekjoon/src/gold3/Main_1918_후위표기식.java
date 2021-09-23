package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main_1918_후위표기식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] ch = br.readLine().toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        map.put('(', 0);
        map.put(')', 0);
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);

        for (int i = 0; i < ch.length; i++) {
            if ('A' <= ch[i] && ch[i] <= 'Z') {
                sb.append(ch[i]);
            } else if (ch[i] == '(') {
                stack.push(ch[i]);
            } else if (ch[i] == ')') {
                while (!stack.isEmpty()) {
                    char op = stack.pop();
                    if (op == '(')
                        break;
                    else
                        sb.append(op);
                }
            } else {
                while (!stack.isEmpty() && map.get(stack.peek()) >= map.get(ch[i])) {
                    sb.append(stack.pop());
                }
                stack.push(ch[i]);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());

    }

}
