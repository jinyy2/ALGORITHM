package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int[] result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < N; i++) {
            if (num[stack.peek()] < num[i]) {
                while (!stack.isEmpty() && num[stack.peek()] < num[i]) {
                    result[stack.pop()] = num[i];
                }
                stack.push(i);
            } else {
                stack.push(i);
            }
        }
        for (int i = 0; i < N - 1; i++) {
            if (result[i] == 0) sb.append(-1).append(" ");
            else sb.append(result[i]).append(" ");
        }
        sb.append("-1");
        System.out.println(sb.toString());
    }
}
