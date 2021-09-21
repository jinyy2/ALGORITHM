package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17299_오등큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[N];
        int[] count = new int[1000001];
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            count[num[i]]++;
        }
        for (int i = 0; i < N; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }
            while (!stack.isEmpty() && count[num[stack.peek()]] < count[num[i]]) {
                result[stack.pop()] = num[i];
            }
            stack.push(i);


        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(result[i] + " ");
        }
        System.out.println(sb.toString());

    }
}
