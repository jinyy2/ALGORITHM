package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1874_스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        int idx = 0;
        for (int i = 1; i <= N; i++) {
            if (i < num[idx]) {
                stack.add(i);
                sb.append("+\n");
            } else if (i == num[idx]) {
                sb.append("+\n-\n");
                idx++;
            } else if (num[idx] < i) {
                boolean flag = true;
                while (flag) {
                    if (!stack.isEmpty() && num[idx] == stack.peek()) {
                        stack.pop();
                        idx++;
                        sb.append("-\n");
                    } else {
                        flag = false;
                        stack.add(i);
                        sb.append("+\n");
                    }
                }
            }
        }
        boolean flag = true;
        while (flag) {
            if (!stack.isEmpty() && num[idx] == stack.peek()) {
                stack.pop();
                idx++;
                sb.append("-\n");
            } else {
                flag = false;
            }
            if (idx == N) break;
        }
        if (!stack.isEmpty()) System.out.println("NO");
        else System.out.println(sb.toString());

    }
}
