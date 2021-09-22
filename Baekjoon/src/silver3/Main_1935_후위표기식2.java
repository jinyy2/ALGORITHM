package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main_1935_후위표기식2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        char[] ch = br.readLine().toCharArray();
        Map<Character, Double> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put((char) ('A' + i), Double.parseDouble(br.readLine()));
        }
        double sum = 0;
        for (int i = 0; i < ch.length; i++) {
            if ('A' <= ch[i] && ch[i] <= 'Z') {
                stack.push(map.get(ch[i]));
            } else {
                double last = stack.pop();
                double first = stack.pop();
                if (ch[i] == '+') {
                    stack.push(first + last);
                } else if (ch[i] == '*') {
                    stack.push(first * last);
                } else if (ch[i] == '/') {
                    stack.push(first / last);
                } else if (ch[i] == '-') {
                    stack.push(first - last);

                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
