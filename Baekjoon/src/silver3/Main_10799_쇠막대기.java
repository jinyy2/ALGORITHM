package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        char[] ch = br.readLine().toCharArray();
        int sum = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                stack.add('(');
            } else if (ch[i] == ')') {
                stack.pop();
                if (ch[i - 1] == '(') sum += stack.size();
                else sum++;
            }
        }
        System.out.println(sum);
    }
}
